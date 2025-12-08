package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextInputPage extends BasePage {

    public TextInputPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    By changeButton = By.xpath("//button[@id='updatingButton']");
    By input = By.xpath("//input[@id='newButtonName']");

    public void clickChangeButton() {
        driver.findElement(changeButton).click();
    }

    public void clearInput() {
        driver.findElement(input).clear();
    }

    public void typeInput(String text) {
        driver.findElement(input).sendKeys(text);
    }

    public String getInputValue() {
        return driver.findElement(input).getAttribute("value");
    }

    public String getChangeButtonText(){
        return driver.findElement(changeButton).getText();
    }

}

