package org.example.test;

import com.codeborne.selenide.Selenide;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

// @Log4j2 // делает за нас: // Logger loggerAlert = LogManager.getLogger(AlertTest.class);

public class AlertTest extends BaseTest{

    Logger loggerAlert = LogManager.getLogger(AlertTest.class);

    @Test
    public void touchAlerts(){
        homePage.redirectToSection("Alerts");

        alertsPage.clickPromptButton();

        final String inputText = "TestAlert";

      loggerAlert.debug("test words are {}", inputText);

        String expectedText = "User value: %s".formatted(inputText);
        // String.format(expectedText, inputText);
        alertsPage.setTextToAlert(inputText);
        alertsPage.confirmAlert();

        Selenide.sleep(6000);
        Selenide.Wait().until(ExpectedConditions.alertIsPresent());

        String actualText = alertsPage.getTextFromAlert();

        alertsPage.confirmAlert();

        Assert.assertEquals(actualText, "test"); //expectedText


    }
    @Test
    public void secondTouchAlerts(){
        homePage.redirectToSection("Alerts");

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


