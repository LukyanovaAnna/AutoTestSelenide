package org.example.test;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class AlertTest extends BaseTest{

    @Test
    public void touchAlerts(){
        homePage.redirectToSection("Alerts");

        alertsPage.clickPromptButton();

        final String inputText = "TestAlert";
        String expectedText = "User value: %s".formatted(inputText);
        // String.format(expectedText, inputText);
        alertsPage.setTextToAlert(inputText);
        alertsPage.confirmAlert();

        Selenide.sleep(6000);
        Selenide.Wait().until(ExpectedConditions.alertIsPresent());

        String actualText = alertsPage.getTextFromAlert();

        alertsPage.confirmAlert();

        Assert.assertEquals(actualText, expectedText);


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


