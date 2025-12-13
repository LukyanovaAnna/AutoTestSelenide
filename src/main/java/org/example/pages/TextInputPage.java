package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TextInputPage extends BasePage {

    SelenideElement changeButton = $x("//button[@id='updatingButton']");
    SelenideElement input = $x("//input[@id='newButtonName']");

    public void clickChangeButton() {
        changeButton.click();
    }

    public void clearInput() {
        input.clear();
    }

    public void typeInput(String text) {
        input.sendKeys(text);
    }

    public String getInputValue() {
        return input.getAttribute("value");
    }

    public String getChangeButtonText(){
        return changeButton.getText();
    }

}

