package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$x;

public class MouseOverPage extends BasePage {

    private SelenideElement clickMeButton = $x("//div/a[text()='Click me']");
    private SelenideElement clickMeButtonCounter = $x("//span[@id='clickCount']");

    public void hoverClickMeButton() {
        clickMeButton.hover();
    }


    public String getClickCount() {
        return clickMeButtonCounter.getText();
    }

    public void doubleClick(int clickCount) {
        for (int i = 0; i < clickCount; i++) {
            clickMeButton.doubleClick();
        }
    }

    public String getClickMeAttribute(String attributeName) {
        return clickMeButton.getAttribute(attributeName);
    }

}