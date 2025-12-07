package org.example.test;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class TextInputTest extends BaseTest {


    @Test
    public void textInputTest(){

        homePage.redirectToSection("Text Input");

        By changeButton = By.xpath("//button[@id='updatingButton']");
        By inputMyButton = By.xpath("//input[@id='newButtonName']");

        WebElement input = getWebDriver().findElement(inputMyButton);
        input.clear();

        input.sendKeys("TEST");

        String enteredText = input.getAttribute("value");

        WebElement button = getWebDriver().findElement(changeButton);
        button.click();


        Assert.assertEquals(enteredText, button.getText());

        input.clear();

        input.sendKeys("TEST2");

        String secondEnteredText = input.getAttribute("value");

        WebElement secondButton = getWebDriver().findElement(changeButton); //нужно ли находить второй раз этот же элемент?
        button.click();

        Assert.assertEquals(secondEnteredText, button.getText());


    }
}
