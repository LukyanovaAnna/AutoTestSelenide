package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class AlertsPage extends BasePage{

    By promptButton = By.xpath("//button[@id='promptButton']");
    By confirmButton = By.xpath("//button[@id='confirmButton']");

    public void clickPromptButton(){
        driver.findElement(promptButton).click();
    }

    public void confirmAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert(){
        return driver.switchTo().alert().getText();
    }
    public void setTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);

    }

    public AlertsPage(WebDriver driver, Actions actions){
        super(driver, actions);

    }

    public void clickConfirmButton(){
        driver.findElement(confirmButton).click();
    }

    public void alertDay(){
        if (LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }
    }
    public void confirmSecondAlert(){
        driver.switchTo().alert().accept();
    }

}
