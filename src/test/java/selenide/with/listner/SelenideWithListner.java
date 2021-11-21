package selenide.with.listner;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideWithListner {


    @BeforeAll
    public static void setSelenideConfiguration() {
        addListener("AllureSelenide", new AllureSelenide());
    }

    private static final String URL = "https://github.com/qa-guru";
        private static final String REPOSITORY = "allure-notifications";
        private static final int ISSUE_NUMBER = 64;

        @Owner("AlexSvet")
        @Feature("Gidhub")
        @Story("Issues")
        @DisplayName("Selenide With Listner")
        @Link(name = "GitHub", url = "https://github.com/qa-guru")

        @Test
        public void testGithub() {
            // Подключение Листенера Allure
//           SelenideLogger.addListener("allure", new AllureSelenide());

            // Открываем целевую страницу
            open(URL);

            // Поиск репо
            $(linkText(REPOSITORY)).click();

            // Переход на другую страницу
            $(partialLinkText("Issues")).should(Condition.visible, Duration.ofSeconds(20));
            // Клик на Issues
            $(partialLinkText("Issues")).click();

            // Проверяем наличие #64
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        }
    }

