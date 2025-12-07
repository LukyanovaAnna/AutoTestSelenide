package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class GoogleTest {

    WebDriver driver;
    @BeforeClass
    public WebDriver prepare(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;
    }
    //@AfterMethod
    //public void shutDown(){
       // driver.quit();
    //}
    @Test
    public void googleSearchTest(){
        String expectedHeader = "Уточки Микс цветной";
        driver.get("http://www.google.com/");
        By searchInput = By.xpath("//textarea[@id='APjFqb']");
        By searchButtonLoc = By.xpath("//div[@class='lJ9FBc']//input[@name='btnK']");
        WebElement search = driver.findElement(searchInput);
        search.sendKeys("уточки");
        driver.findElement(searchButtonLoc).click();

        By resultSet = By.xpath("//a/h3");
        List <WebElement> seachList = driver.findElements(resultSet);

        WebElement target = seachList.stream().filter(el->el.getText().equals(expectedHeader)).findAny().orElseThrow();
        Assert.assertEquals(target.getText(), expectedHeader);

        target.findElement(By.xpath("./..")).click();
        System.out.println("");


    }
}
