package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import static com.codeborne.selenide.Selenide.$x;

// @Data // (ламбок: @Getter + @Setter, еще есть @ALLArgsConstructor)

public class DynamicIdPage extends BasePage{

    private SelenideElement dynamicIdButton = $x("//button[@class='btn btn-primary']");


    @Step("Вернуть элемент dynamicIdButton")
    public SelenideElement getDynamicElement(){
        return dynamicIdButton;
    }
}
