package org.example.test;

import org.example.pages.BasePage;
import org.example.pages.TextInputPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextInputTest extends BaseTest {


    @Test
    public void textInputTest(){

        homePage.redirectToSection("Text Input");

        textInputPage.clearInput();

        textInputPage.typeInput("TEST");

        String enteredText = textInputPage.getInputValue();

        textInputPage.clickChangeButton();

        Assert.assertEquals(enteredText,textInputPage.getChangeButtonText());

        textInputPage.clearInput();

        textInputPage.typeInput("TEST2");

        String enteredText2 = textInputPage.getInputValue();

        textInputPage.clickChangeButton();

        Assert.assertEquals(enteredText2,textInputPage.getChangeButtonText());


    }
}
