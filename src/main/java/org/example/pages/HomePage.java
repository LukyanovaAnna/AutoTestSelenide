package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage{

    private static final String LINK_LOCATION_PATTERN = "//h3/a[text()='%s']";

    public void redirectToSection(String sectionName) {
        driver.findElement(By.xpath(LINK_LOCATION_PATTERN.formatted(sectionName))).click();
    }

    public HomePage(WebDriver driver, Actions actions){
        super(driver, actions);
    }
}
