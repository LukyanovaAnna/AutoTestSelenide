package org.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.AlertsPage;
import org.example.pages.HomePage;
import org.example.pages.MouseOverPage;
import org.example.pages.TextInputPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest {

    protected Properties runProperties; //Это объект класса Properties,
    // который будет содержать все параметры из файла


    protected HomePage homePage = new HomePage(getWebDriver(), getActions());
    protected MouseOverPage mouseOverPage = new MouseOverPage(getWebDriver(), getActions());
    protected AlertsPage alertsPage = new AlertsPage(getWebDriver(),getActions());
    protected TextInputPage textInputPage = new TextInputPage(getWebDriver(),getActions());
    //Создаём объекты Page объектов

    private static WebDriver driver;
    private static Actions actions; //WebDriver будет один на весь проект
    //(пока тесты в одном процессе), как и Actions


    @BeforeClass
    public void openBasePage(){
        driver.get(runProperties.getProperty("baseUrl")); //То есть каждый тест, который наследует BaseTest,
        // перед запуском вызывает openBasePage(), а этот метод сам открывает baseUrl
    }


    public static WebDriver getWebDriver(){ //Это глобальная точка доступа к драйверу
        // (управляет созданием драйвера, хранением и выдачей),
        // тк private static WebDriver driver; // метод = “дай мне драйвер”
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver; //Без return getWebDriver().findElement(...) не работало бы,
            // потому что имеено здесь драйвер записывается в переменную
        } else {
            return driver;
        }
    }

    public  static Actions getActions(){
        if (actions == null) {
            return new Actions(getWebDriver()); //Actions использует driver для выполнения
            // всех сложных действий: hover, drag&drop, clickAndHold, sendKeys
        } else {
            return actions;
        }
    }

    @BeforeSuite
    public void setProperties() throws IOException { //throws IOException —
        // если не найдётся файл, Java “передаст” исключение наверх
        runProperties = new Properties(); //Properties — это контейнер для настроек из файла (key=value)
        FileInputStream fis = new FileInputStream("src/main/resources/properties.properties");
        runProperties.load(fis); //runProperties — это просто “контейнер” для настроек из файла,
        // чтобы удобно к ним обращаться в коде.
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}



