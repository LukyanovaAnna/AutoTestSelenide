package org.example.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$x;

public class AlertsPage extends BasePage{

    SelenideElement promptButton = $x("//button[@id='promptButton']");
    SelenideElement confirmButton = $x("//button[@id='confirmButton']");

    public void clickPromptButton(){
        promptButton.click();
    }

    public void confirmAlert(){
        Selenide.switchTo().alert().accept();
    }

    public void dismissAlert(){
        Selenide.switchTo().alert().dismiss();
    }

    public String getTextFromAlert(){
        return Selenide.switchTo().alert().getText();
    }
    public void setTextToAlert(String text){
        Selenide.switchTo().alert().sendKeys(text);

    }


    public void clickConfirmButton(){
        confirmButton.click();
    }

    public void alertDay(){
        if (LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            Selenide.switchTo().alert().accept();
        } else {
            Selenide.switchTo().alert().dismiss();
        }
    }
}
