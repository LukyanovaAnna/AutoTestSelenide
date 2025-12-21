package org.example.pages;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;


public class HomePage extends BasePage{

    private static final String LINK_LOCATION_PATTERN = "//h3/a[text()='%s']";

    @Step("Переход на страницу {sectionName}")
    public void redirectToSection(String sectionName) {
        $x(LINK_LOCATION_PATTERN.formatted(sectionName)).click();
    }

}
