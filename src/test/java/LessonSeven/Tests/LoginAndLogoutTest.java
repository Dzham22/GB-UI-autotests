package LessonSeven.Tests;

import LessonFive.BaseTest;
import LessonSeven.MainPages.MainLoginPage;
import LessonSeven.Pages.LoginAndLogoutPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Авторизация e-Katalog.ru")
public class LoginAndLogoutTest extends BaseTest {

    String login = "jrockiy@mail.ru";
    String password = "9Torres99";
    public static final String URL = "https://www.e-katalog.ru/";



    @Test
    @DisplayName("Успешная авторизация - позитивный сценарий")
    @Severity(SeverityLevel.BLOCKER)
    void successAuthTest() {
        webDriver.get(URL);

        new MainLoginPage(webDriver)
                .clickLoginButton()
                .login(login,password)
                .clickLogoutButtonWaitUntilLogout();
    }

    @Test
    @DisplayName("Неуспешная авторизация - нагетивный сценарий")
    @Severity(SeverityLevel.NORMAL)
    void failureAuthTest() {
      webDriver.get(URL);

      new MainLoginPage(webDriver)
              .clickLoginButton()
              .login(login, "ErrorPassword");
      new LoginAndLogoutPage(webDriver)
              .checkError("Пароль указан неверно!");
    }
}


