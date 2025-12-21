package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SampleAppPage extends BasePage{

    private SelenideElement inputUserName = $x("//input[@placeholder='User Name']");
    private SelenideElement inputPassword = $x("//input[@placeholder='********']");
    private SelenideElement buttonLogIn = $x("//button[@id='login']");
    private SelenideElement loginStatus = $x("//label[@id='loginstatus']");

    @Step("Кликнуть по кнопке buttonLogIn")
    public void clickButtonLogIn() {
        buttonLogIn.click();
    }

    @Step("Очистить поля ввода")
    public void clearInputs() {
        inputUserName.clear();
        inputPassword.clear();
    }

    @Step("Написать текст в поле ввода inputPassword")
    public void typeInputPassword(String text) {
        inputPassword.sendKeys(text);
    }

    @Step("Написать текст в поля ввода inputUserName")
    public void typeInputUserName(String text) {
        inputUserName.sendKeys(text);
    }

    @Step("Получить значение из поля ввода")
    public String getInputValue() {
        return inputPassword.getAttribute("value");
    }

    @Step("Получить значение из loginStatus")
    public String getLoginStatusText(){
        return loginStatus.getText();
    }
}
