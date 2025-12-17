package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicTablePage extends BasePage {

   private SelenideElement cpuValue = $x("//p[@class='bg-warning']");
   private ElementsCollection columHeaders = $$x("//p[@class='bg-warning']");
    private SelenideElement chromeRow = $x("//span[text()='Chrome']/..");

    @Step("Получить значение CPU")
    public String getCpuValue(){
        return cpuValue.getText();
    }

    @Step("Получить заголовки колонок таблицы")

    public ElementsCollection getHeader(){
        return columHeaders;
    }

    @Step("Получить CromeRow")
    public WebElement getCromeRow(){
        return chromeRow;
    }
}
