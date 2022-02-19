package LessonSix.Tests;

import LessonFive.BaseTest;
import LessonSix.Pages.LoginAndLogoutPage;
import LessonSix.MainPages.MainLoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Авторизация e-Katalog.ru")
public class LoginAndLogoutTest extends BaseTest {

    String login = "jrockiy@mail.ru";
    String password = "9Torres99";
    public static final String URL = "https://www.e-katalog.ru/";



    @Test
    @DisplayName("Успешная авторизация - позитивный сценарий")
    void successAuthTest() {
        webDriver.get(URL);

        new MainLoginPage(webDriver)
                .clickLoginButton()
                .login(login,password)
                .clickLogoutButton()
                .waitUntilLogout();

    }

    @Test
    @DisplayName("Неуспешная авторизация - нагетивный сценарий")
    void failureAuthTest() {
      webDriver.get(URL);

      new MainLoginPage(webDriver)
              .clickLoginButton()
              .login(login, "ErrorPassword");
      new LoginAndLogoutPage(webDriver)
              .checkError("Пароль указан неверно!");
    }
}


