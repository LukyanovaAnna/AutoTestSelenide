package org.example.test;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicTableTest extends BaseTest{
    @Test
    public void tableTest(){
        homePage.redirectToSection("Dynamic Table");

        String expectedValue = dynamicTablePage.getCpuValue();

        ElementsCollection actualHeaders = dynamicTablePage.getHeader();

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
