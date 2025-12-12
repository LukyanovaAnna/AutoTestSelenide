package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadPage extends BasePage{

    By uploadFileInput = By.xpath("//input[@id='browse']");

    public void uploadFile(String pathToFile) {
        driver.findElement(uploadFileInput).sendKeys(pathToFile);
    }



    public FileUploadPage(WebDriver driver, Actions actions){
        super (driver, actions);
    }
}

