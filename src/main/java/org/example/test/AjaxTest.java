package org.example.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AjaxTest extends BaseTest {

    @Test
    @Description("Проверка отработки ajax запросов")
    @Epic("AUTOTEST")
    public void ajaxTest() {

        homePage.redirectToSection("AJAX Data");

        ajaxPage.startAjaxJob();

        Selenide
                .Wait()
                .withTimeout(Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOf(ajaxPage.getSpinner()));

        ElementsCollection actualData = ajaxPage.getDataLoaded();

        Assert.assertEquals(actualData.size(), 1);

        ajaxPage.startAjaxJob();

        Selenide
                .Wait()
                .withTimeout(Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOf(ajaxPage.getSpinner()));

        ElementsCollection actualData1 = ajaxPage.getDataLoaded();

        Assert.assertEquals(actualData1.size(), 2);
    }
}
