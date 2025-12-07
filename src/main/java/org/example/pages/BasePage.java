package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    protected WebDriver driver;
    protected Actions actions;

    BasePage(WebDriver driver, Actions actions){
        this.driver = driver;
        this.actions = actions;
    }
}
