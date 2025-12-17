package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;

public class MouseOverPage extends BasePage {

    private SelenideElement clickMeButton = $x("//div/a[text()='Click me']");
    private SelenideElement clickMeButtonCounter = $x("//span[@id='clickCount']");

    @Step("Навести мышь на кнопку")
    public void hoverClickMeButton() {
        clickMeButton.hover();
    }
    @Step("Получить количество кликов в кнопке")
    public String getClickCount() {
        return clickMeButtonCounter.getText();
    }

    @Step("Кликнуть по кнопке 2 раза")
    public void doubleClick(int clickCount) {
        for (int i = 0; i < clickCount; i++) {
            clickMeButton.doubleClick();
        }
    }

    @Step("Получить значение атрибута")
    public String getClickMeAttribute(String attributeName) {
        return clickMeButton.getAttribute(attributeName);
    }

}