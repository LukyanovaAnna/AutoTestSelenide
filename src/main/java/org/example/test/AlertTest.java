package org.example.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;

import static java.lang.Thread.*;
import static java.lang.Thread.sleep;

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

        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());

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
        } //почему просит Thread.sleep(2000) обернуть в try?

        alertsPage.alertDay();

        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());

        alertsPage.confirmAlert();
        }




}


