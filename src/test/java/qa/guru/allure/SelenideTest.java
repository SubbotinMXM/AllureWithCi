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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static net.bytebuddy.agent.builder.AgentBuilder.Default.of;

@DisplayName("Тесты на селениде")
public class SelenideTest extends TestBase{

    private final static String word = "дюна";

    @Test
    @DisplayName("Первый тест")
    @Description("Проверяем, что получается на лордфильме найти нужное слово")
    @Owner("Максим Субботин")
    @Tag("smoke")
    void foo1() {
        step("Открываем lordfilm", () -> {
            open("https://mix.lordfilmx.lol/");
        });
        step("Ищем фильм " + word, () -> {
            $x("//input[@placeholder='Введите название']")
                    .setValue("дюна")
                    .pressEnter();
        });
        step("Проверяем, что на странице поиска есть слово " + word, () -> {
            $x("//input[@value='дюна']")
                    .shouldBe(visible);
        });
    }
    @Test
    @DisplayName("Второй тест")
    @Description("Проверяем, что получается на лордфильме найти нужное слово")
    @Owner("Максим Субботин")
    @Tag("smoke")
    void foo2() {
        step("Открываем lordfilm", () -> {
            open("https://mix.lordfilmx.lol/");
        });
        step("Ищем фильм " + word, () -> {
            $x("//input[@placeholder='Введите название']")
                    .setValue("дюна")
                    .pressEnter();
        });
        step("Проверяем, что на странице поиска есть слово " + word, () -> {
            $x("//input[@value='дюна']")
                    .shouldBe(visible);
        });
    }
    @Test
    @DisplayName("Третий тест (сломан)")
    @Description("Проверяем, что получается на лордфильме найти нужное слово")
    @Owner("Максим Субботин")
    @Tag("prod")
    void foo3() {
        step("Открываем lordfilm", () -> {
            open("https://mix.lordfilmx.lol/");
        });
        step("Ищем фильм " + word, () -> {
            $x("//input[@placeholder='Введите название']")
                    .setValue("дюна")
                    .pressEnter();
        });
        step("Проверяем, что на странице поиска есть слово " + word, () -> {
            $x("//input[@value='дывуоав']")
                    .shouldBe(visible);
        });
    }
    @Test
    @DisplayName("Четвертый тест")
    @Description("Проверяем, что получается на лордфильме найти нужное слово")
    @Owner("Максим Субботин")
    @Tag("prod")
    void foo4() {
        step("Открываем lordfilm", () -> {
            open("https://mix.lordfilmx.lol/");
        });
        step("Ищем фильм " + word, () -> {
            $x("//input[@placeholder='Введите название']")
                    .setValue("дюна")
                    .pressEnter();
        });
        step("Проверяем, что на странице поиска есть слово " + word, () -> {
            $x("//input[@value='дюна']")
                    .shouldBe(visible);
        });
    }
    @Test
    @DisplayName("Пятый тест (сломан)")
    @Description("Проверяем, что получается на лордфильме найти нужное слово")
    @Owner("Максим Субботин")
    @Tag("web")
    void foo5() {
        step("Открываем lordfilm", () -> {
            open("https://mix.lordfilmx.lol/");
        });
        step("Ищем фильм " + word, () -> {
            $x("//input[@placeholder='Введите название']")
                    .setValue("дюна")
                    .pressEnter();
        });
        step("Проверяем, что на странице поиска есть слово " + word, () -> {
            $x("//input[@value='кадлвоыаимдв']")
                    .shouldBe(visible);
        });
    }
}
