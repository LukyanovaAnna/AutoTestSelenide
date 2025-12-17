package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class TextInputPage extends BasePage {

    private SelenideElement changeButton = $x("//button[@id='updatingButton']");
    private SelenideElement input = $x("//input[@id='newButtonName']");

    @Step("Кликнуть по кнопке ChangeButton")
    public void clickChangeButton() {
        changeButton.click();
    }

    @Step("Очистить поле ввода")
    public void clearInput() {
        input.clear();
    }

    @Step("Написать текст в поле ввода")
    public void typeInput(String text) {
        input.sendKeys(text);
    }

    @Step("Получить значение из поля ввода")
    public String getInputValue() {
        return input.getAttribute("value");
    }

    @Step("Получить значение из кнопки ChangeButton")
    public String getChangeButtonText(){
        return changeButton.getText();
    }

}

