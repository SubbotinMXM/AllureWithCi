package qa.guru.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;

public class TestBase {
    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String jenkins = System.getProperty("jenkins");
        if ("true".equals(jenkins)) {
            // Запуск тестов удаленно (./gradlew clean test -Djenkins=true)
            System.out.println("Running tests remotely");
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", ImmutableMap.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        } else {
            // Запуск тестов локально (./gradlew clean test)
            System.out.println("Running tests locally");
            System.setProperty("webdriver.chrome.driver", "/Users/maksimsubbotin/Documents/Programm/chromedriver");
        }
    }
}
