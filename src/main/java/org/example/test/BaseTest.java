package org.example.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public abstract class BaseTest {

    protected Properties runProperties; //Это объект класса Properties,
    // который будет содержать все параметры из файла


    protected HomePage homePage = new HomePage();
    protected MouseOverPage mouseOverPage = new MouseOverPage();
    protected AlertsPage alertsPage = new AlertsPage();
    protected TextInputPage textInputPage = new TextInputPage();
    protected FileUploadPage fileUploadPage = new FileUploadPage();
    protected DynamicTablePage dynamicTablePage = new DynamicTablePage();
    //Создаём объекты Page объектов


    @BeforeClass
    public void openBasePage(){
        try {
            setProperties();
        }catch (IOException e){
            throw new RuntimeException("Не удалось загрузить properties", e);
        }

        Configuration.browser = "chrome";

        Selenide.open(runProperties.getProperty("baseUrl"));
    }

    public static WebDriver getWebDriver() {
        return WebDriverRunner.getWebDriver(); //Глобальный доступ к WebDriver
        // (если вдруг понадобится)
    }


    private void setProperties() throws IOException { //throws IOException —
        // если не найдётся файл, Java “передаст” исключение наверх
        runProperties = new Properties(); //Properties — это контейнер для настроек из файла (key=value)
        FileInputStream fis = new FileInputStream("src/main/resources/properties.properties");
        runProperties.load(fis); //runProperties — это просто “контейнер” для настроек из файла,
        // чтобы удобно к ним обращаться в коде.
    }

    @AfterSuite(alwaysRun = true) //браузер закроется даже если тесты упали
    public void closeBrowser(){
        Selenide.closeWebDriver(); //явное закрытие — best practice
    }

    public void switchToLastOpenTab() {
        WebDriver driver = getWebDriver();
        List<String> handles = driver.getWindowHandles().stream().toList();
        driver.switchTo().window(handles.get(handles.size() - 1));
    }
}



