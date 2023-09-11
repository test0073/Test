import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BrowserSetup {
    /**
     * Настройки браузера
     */
    public void start() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 6000;
    }

    /**
     * Метод, который выполняется перед каждым тестом
     */
    @BeforeEach
    public void openBrowser() {
        start();
    }

    /**
     * Метод, который выполняется после каждого теста
     */
    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

