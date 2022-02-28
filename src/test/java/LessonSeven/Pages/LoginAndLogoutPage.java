package LessonSeven.Pages;

import LessonSeven.MainPages.MainLoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginAndLogoutPage extends BasePage {


    public LoginAndLogoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Кликнуть на кнопку авторизации и ввести {login} и {password}")
    public MainLoginPage login (String login, String password){
        By authFormLocator = By.xpath("//div[contains(@id, 'mui_user_login_window')]");
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.xpath("//input[contains(@name, 'l_')]"))
                .sendKeys(login);
        authForm.findElement(By.xpath("//div[contains(@class, 'signin-password ek-form-group')]/input[contains(@name, 'pw_')]"))
                .sendKeys(password);
        authForm.findElement(By.xpath("//div[contains(@class, 'signin-actions ml-auto')]/button[contains(@class, 'ek-form-btn blue')]"))
                .click();

        return new MainLoginPage(webDriver);
    }

    @Step("Обратить внимание на ошибку")
    public void checkError(String errorText){
        assertThat(webDriver.findElement(By.xpath("//div[@class ='ek-form-text']"))
                .getText()).isEqualTo(errorText);
    }

}
