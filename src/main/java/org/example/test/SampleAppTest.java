package org.example.test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;


public class SampleAppTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        Selenide.open("/sampleapp");
        sampleAppPage.clearInputs();
        $x("//label[@id='loginstatus']").shouldHave(Condition.text("User logged out."));
    }

    @Test
    @Description("Проверка отработки Sample App")
    @Epic("Аутентификация и авторизация")
    @Feature("Авторизация по логину и паролю")
    @Story("Ошибка валидации при отсутствии данных в обязательных полях")
    public void testEmptyInputs() {

        sampleAppPage.clickButtonLogIn();

        sampleAppPage.getLoginStatusText();

        Assert.assertEquals(sampleAppPage.getLoginStatusText(), "Invalid username/password");

        //String loginStatusText1 = sampleAppPage.getLoginStatusText();
        //Assert.assertEquals(loginStatusText1, "Invalid username/password");
    }

        @Test
        @Story("Ошибка валидации при отсутствии данных в поле inputUserName")
        public void testEmptyInputUserName() {

            sampleAppPage.typeInputUserName("Name");

            sampleAppPage.clickButtonLogIn();

            sampleAppPage.getLoginStatusText();

            Assert.assertEquals(sampleAppPage.getLoginStatusText(), "Invalid username/password");
        }
        @Test
        @Story("Успешный вход с валидными данными")
        public void testValidLogin() {

        sampleAppPage.typeInputUserName("Name");

        sampleAppPage.typeInputPassword("pwd");

        sampleAppPage.clickButtonLogIn();

        sampleAppPage.getLoginStatusText();

        Assert.assertEquals(sampleAppPage.getLoginStatusText(), "Welcome, Name!");
    }
}
