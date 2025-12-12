package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DynamicIdPage extends BasePage{

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement dynamicIdButton;

    DynamicIdPage(WebDriver driver, Actions actions){
        super(driver, actions);
    }
}
