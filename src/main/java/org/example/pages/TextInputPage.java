package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TextInputPage extends BasePage {

    public TextInputPage (WebDriver driver, Actions actions){
        super(driver, actions);
    }

    By changeButton = By.xpath("//button[@id='updatingButton']");
    By inputMyButton = By.xpath("//input[@id='newButtonName']");

    public void inputClickMyButton(){
        driver.findElement(inputMyButton).click();
    }

    public void clearInputMyButton(){
        driver.findElement(inputMyButton).clear();
    }

    public void typeInputMyButton(String text){
        driver.findElement(inputMyButton).sendKeys(text);
    }

    public String getInputMyButtonValue(){
        return driver.findElement(inputMyButton).getAttribute("value");
    }




}
