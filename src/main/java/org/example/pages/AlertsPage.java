package org.example.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$x;

@Data

public class AlertsPage extends BasePage{


    private SelenideElement promptButton = $x("//button[@id='promptButton']");
    private SelenideElement confirmButton = $x("//button[@id='confirmButton']");

    @Step("Нажать на кнопку PrompButton")
    public void clickPromptButton(){
        promptButton.click();
    }

    public void confirmAlert(){
        Selenide.switchTo().alert().accept();
    }

    public void dismissAlert(){
        Selenide.switchTo().alert().dismiss();
    }

    @Step("Получить текст алерта")
    public String getTextFromAlert(){
        return Selenide.switchTo().alert().getText();
    }

    @Step("Ввести текст в поле ввода")
    public void setTextToAlert(String text){
        Selenide.switchTo().alert().sendKeys(text);

    }

    @Step("Нажать кнопку подтвердить")
    public void clickConfirmButton(){
        confirmButton.click();
    }

    @Step("Пятница? да - подтвердить, нет - отклонить")
    public void alertDay(){
        if (LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            Selenide.switchTo().alert().accept();
        } else {
            Selenide.switchTo().alert().dismiss();
        }
    }
}
