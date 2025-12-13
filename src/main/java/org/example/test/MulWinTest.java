package org.example.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class MulWinTest extends BaseTest{

    WebDriver driver = WebDriverRunner.getWebDriver();


    @Test
    public void mulWinTest(){

        String playGrHandle = driver.getWindowHandle();

        Selenide.switchTo().newWindow(WindowType.TAB);

        Selenide.open("https://google.com/");

        // ненадежно getWebDriver().switchTo().window("File Upload");

        String googleHandle = driver.getWindowHandle(); //возвращает ключ к вкладке


        Set<String> browserTabs = driver.getWindowHandles(); //возвращает абсолютно все
        // ключи к открытым вкладкам по порядку

        Selenide.switchTo().window(playGrHandle);

        homePage.redirectToSection("File Upload");

        Selenide.closeWindow();


    }
}
