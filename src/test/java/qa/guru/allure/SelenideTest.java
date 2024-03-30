package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Тесты на селениде")
public class SelenideTest {

    private final static String word = "огурчик";

    @Test
    @DisplayName("Поиск конкретного слова")
    @Description("Проверяем, что получается в гугле найти нужное нам слово")
    @Owner("Максим Субботин")
    void googleSearch(){
        System.setProperty("webdriver.chrome.driver", "/Users/maksimsubbotin/Documents/Programm/chromedriver");
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу гугла", () -> {
            open("https://www.google.ru/");
        });
        step("Ищем слово " + word, () ->{
            $x("//textarea[@name='q']")
                    .setValue("огурчик")
                    .pressEnter();
        });
        step("Проверяем, что на странице поиска есть слово " + word, () ->{
            $x("//h3[text()='огурчик']")
                    .shouldBe(visible);
        });
    }
}
