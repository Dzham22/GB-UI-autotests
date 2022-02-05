package LessonFive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@DisplayName("Авторизация e-Katalog.ru")
public class LoginAndLogoutTest extends BaseTest {


    @Test
    @DisplayName("Успешная авторизация - позитивный сценарий")
    void successAuthTest() {

        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(800, 1200));
        webDriver.findElement(By.cssSelector(".wu_entr > em")).click();
        webDriver.findElement(By.cssSelector(".signin-with-ek")).click();

        By authFormLocator = By.xpath("//div[contains(@id, 'mui_user_login_window')]");
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.xpath("//input[contains(@name, 'l_')]")).sendKeys("jrockiy@mail.ru");
        authForm.findElement(By.xpath("//div[contains(@class, 'signin-password ek-form-group')]/input[contains(@name, 'pw_')]")).sendKeys("9Torres99");
        authForm.findElement(By.xpath("//div[contains(@class, 'signin-actions ml-auto')]/button[contains(@class, 'ek-form-btn blue')]")).click();
        webDriver.findElement(By.xpath("//a[contains(@class,'help2')]")).click();


        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Войти")));

    }


    @Test
    @DisplayName("Неуспешная авторизация - нагетивный сценарий")
    void failureAuthTest() {

        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(800, 1200));
        webDriver.findElement(By.cssSelector(".wu_entr > em")).click();
        webDriver.findElement(By.cssSelector(".signin-with-ek")).click();

        By authFormLocator = By.xpath("//div[contains(@id, 'mui_user_login_window')]");
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.xpath("//input[contains(@name, 'l_')]")).sendKeys("jrockiy@mail.ru");
        authForm.findElement(By.xpath("//div[contains(@class, 'signin-password ek-form-group')]/input[contains(@name, 'pw_')]"))
                .sendKeys("JokerFace");
        authForm.findElement(By.xpath("//div[contains(@class, 'signin-actions ml-auto')]/button[contains(@class, 'ek-form-btn blue')]")).click();
        webDriver.findElement(By.xpath("//a[contains(@class,'help2')]")).click();


        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Пароль указан неверно!']")));

    }
}