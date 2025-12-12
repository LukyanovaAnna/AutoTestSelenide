package org.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicTableTest extends BaseTest{
    @Test
    public void tableTest(){
        homePage.redirectToSection("Dynamic Table");

        String expectedValue = dynamicTablePage.getCpuValue();

        List<WebElement> actualHeaders = dynamicTablePage.getHeader();

        int cupIndex = 0;

        for (int i=0; i<actualHeaders.size(); i++){
            String header = actualHeaders.get(i).getText();
            if (header.equals("CPU")){
                cupIndex = i;
                break;
            }

        }
        String tableValue = dynamicTablePage.getCromeRow().
                findElements(By.xpath("./span")).
                get(cupIndex).getText();

        Assert.assertTrue(expectedValue.contains(tableValue));
    }

}
