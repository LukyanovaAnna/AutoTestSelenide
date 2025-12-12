package org.example.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest  extends BaseTest {

    @Test
    public void uploadTest() throws InterruptedException {

        homePage.redirectToSection("File Upload");

       getWebDriver().switchTo().frame(0);

        File file = new File("src/main/resources/FileToUpload.txt");
        fileUploadPage.uploadFile(file.getAbsolutePath());
    }
}