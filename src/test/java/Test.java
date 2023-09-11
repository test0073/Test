import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

class Test extends BrowserSetup {

    private final static String URL = "file:///C:/Users/admin/Downloads/qa-test.html";
    private final static String LOGIN = "test@protei.ru";
    private final static String WHONGLOGIN = "test protei.ru";
    private final static String PASSWORD = "test";
    private final static String WHONGPASSWORD = "test1";

    @org.junit.jupiter.api.Test
    public void check() {
        open(URL);
        step("Проверка \"Окна авторизации\"", () -> {
            $x("//input[@id='loginEmail']").shouldBe(visible).setValue(WHONGLOGIN);
            $x("//input[@id='loginPassword']").setValue(PASSWORD);
            $(byText("Вход")).click();
            $(byText("Неверный формат E-Mail")).shouldBe(visible);
            $x("//input[@id='loginEmail']").setValue(LOGIN);
            $x("//input[@id='loginPassword']").setValue(WHONGPASSWORD);
            $(byText("Вход")).click();
            $(byText("Неверный E-Mail или пароль")).shouldBe(visible);
            $x("//input[@id='loginPassword']").setValue(PASSWORD);
            $(byText("Вход")).click();
        });
        step("Проверка поля  \"E-Mail\"", () -> {
            $(".uk-form-label", 2).shouldHave(text("E-Mail:")).shouldBe(visible);
            $x("//input[@id='dataEmail']").setValue(WHONGLOGIN);
            $(byText("Добавить")).click();
            $(byText("Неверный формат E-Mail")).shouldBe(visible);
            $x("//input[@id='dataEmail']").setValue(LOGIN);
        });
        step("Проверка создания документа \"Мужской пол\"", () -> {
            step("Проверка \"Добавления в список dataCheck \"", () -> {
                $x("//input[@id='dataName']").setValue("Даниил");
                $x("//input[@id='dataCheck11']").click();
                $(byText("Добавить")).click();
                $(byText("Данные добавлены.")).shouldBe(visible);
                $(byText("Ok")).click();
                $x("//input[@id='dataCheck12']").click();
                $(byText("Добавить")).click();
                $(byText("Данные добавлены.")).shouldBe(visible);
                $(byText("Ok")).click();
            });
            step("Проверка кнопки \"Добавления в список dataSelect\"", () -> {
                $x("//input[@id='dataSelect21']").click();
                $(byText("Добавить")).click();
                $(byText("Данные добавлены.")).shouldBe(visible);
                $(byText("Ok")).click();
                $x("//input[@id='dataSelect22']").click();
                $(byText("Добавить")).click();
                $(byText("Данные добавлены.")).shouldBe(visible);
                $(byText("Ok")).click();
                $x("//input[@id='dataSelect23']").click();
                $(byText("Добавить")).click();
                $(byText("Данные добавлены.")).shouldBe(visible);
                $(byText("Ok")).click();
            });
        });
        step("Проверка создания документа \"Женский пол\"", () -> {
            step("Проверка \"Добавления в список dataCheck \"", () -> {
                $x("//select[@id='dataGender']").click();
                $(byText("Женский")).click();
                step("Проверка кнопки \"Добавления в список1\"", () -> {
                    $x("//input[@id='dataName']").setValue("Даниил");
                    $x("//input[@id='dataCheck11']").click();
                    $(byText("Добавить")).click();
                    $(byText("Данные добавлены.")).shouldBe(visible);
                    $(byText("Ok")).click();
                    $x("//input[@id='dataCheck12']").click();
                    $(byText("Добавить")).click();
                    $(byText("Данные добавлены.")).shouldBe(visible);
                    $(byText("Ok")).click();
                });
                step("Проверка кнопки \"Добавления в список dataSelect\"", () -> {
                    $x("//input[@id='dataSelect21']").click();
                    $(byText("Добавить")).click();
                    $(byText("Данные добавлены.")).shouldBe(visible);
                    $(byText("Ok")).click();
                    $x("//input[@id='dataSelect22']").click();
                    $(byText("Добавить")).click();
                    $(byText("Данные добавлены.")).shouldBe(visible);
                    $(byText("Ok")).click();
                    $x("//input[@id='dataSelect23']").click();
                    $(byText("Добавить")).click();
                    $(byText("Данные добавлены.")).shouldBe(visible);
                    $(byText("Ok")).click();
                });
            });
        });
    }
}
