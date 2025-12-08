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

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class TextInputTest extends BaseTest {


    @Test
    public void textInputTest(){

        homePage.redirectToSection("Text Input");

        textInputPage.clearInputMyButton();
        textInputPage.typeInputMyButton("TEST");
        String enteredText = textInputPage.getInputMyButtonValue();

        textInputPage.inputClickMyButton();

        Assert.assertEquals(enteredText,textInputPage.getInputMyButtonValue ());

        textInputPage.clearInputMyButton();

        textInputPage.typeInputMyButton("TEST2");

        String enteredText2 = textInputPage.getInputMyButtonValue();

        textInputPage.inputClickMyButton();

        Assert.assertEquals(enteredText2,textInputPage.getInputMyButtonValue ());


    }
}
