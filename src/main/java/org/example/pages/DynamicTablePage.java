package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicTablePage extends BasePage {

   private SelenideElement cpuValue = $x("//p[@class='bg-warning']");
   private ElementsCollection columHeaders = $$x("//p[@class='bg-warning']");
    private SelenideElement chromeRow = $x("//span[text()='Chrome']/..");

    public String getCpuValue(){
        return cpuValue.getText();
    }

    public ElementsCollection getHeader(){
        return columHeaders;
    }

    public WebElement getCromeRow(){
        return chromeRow;
    }
}
