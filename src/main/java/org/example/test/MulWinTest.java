package org.example.test;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class MulWinTest extends BaseTest{



    @Test
    public void mulWinTest(){

        String playGrHandle = getWebDriver().getWindowHandle();

        getWebDriver().switchTo().newWindow(WindowType.TAB);

        getWebDriver().get("https://google.com/");

        // ненадежно getWebDriver().switchTo().window("File Upload");

        String googleHandle = getWebDriver().getWindowHandle(); //возвращает ключ к вкладке


        Set<String> browserTabs = getWebDriver().getWindowHandles(); //возвращает абсолютно все
        // ключи к открытым вкладкам по порядку

        getWebDriver().switchTo().window(playGrHandle);

        homePage.redirectToSection("File Upload");


    }
}
