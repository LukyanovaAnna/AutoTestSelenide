package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DynamicIdPage extends BasePage{

    public SelenideElement dynamicIdButton = $x("//button[@class='btn btn-primary']");

}
