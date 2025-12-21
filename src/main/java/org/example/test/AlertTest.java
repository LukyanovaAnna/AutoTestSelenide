package org.example.test;

import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

// @Log4j2 // делает за нас: // Logger loggerAlert = LogManager.getLogger(AlertTest.class);

public class AlertTest extends BaseTest{

    @BeforeMethod
    public void setUp() {
        Selenide.open("/alerts");
    }

    Logger loggerAlert = LogManager.getLogger(AlertTest.class);

    @Test
    public void touchAlerts(){
        //homePage.redirectToSection("Alerts"); хрупкий,
        // зависит от состояния DOM и предыдущих тестов.

        alertsPage.clickPromptButton();

        Selenide.Wait().until(ExpectedConditions.alertIsPresent());

        final String inputText = "TestAlert";

        loggerAlert.debug("test words are {}", inputText);

        String expectedText = "User value: %s".formatted(inputText);

        alertsPage.setTextToAlert(inputText);

        alertsPage.confirmAlert();

        Selenide.Wait().until(ExpectedConditions.alertIsPresent());

        String actualText = alertsPage.getTextFromAlert();

        alertsPage.confirmAlert();

        Assert.assertEquals(actualText, expectedText);

    }
    @Test
    public void secondTouchAlerts(){

        alertsPage.clickConfirmButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        alertsPage.alertDay();

        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(6));

        wait.until(ExpectedConditions.alertIsPresent());

        alertsPage.confirmAlert();
        }
}


