package LessonSeven.MainPages;

import LessonSeven.Pages.BasePage;
import LessonSeven.Pages.LoginAndLogoutPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainLoginPage extends BasePage {
       public MainLoginPage(WebDriver webDriver) {
            super(webDriver);
        }

    @Step("Кликнуть на кнопку \"Войти\"")
    public LoginAndLogoutPage clickLoginButton () {
        webDriver.findElement(By.cssSelector(".wu_entr > em")).click();
        webDriver.findElement(By.cssSelector(".signin-with-ek")).click();
        return new LoginAndLogoutPage(webDriver);
    }

    @Step("Кликнуть на кнопку \"Выйти\" и подождать, пока не выполнится выход из системы")
    public MainLoginPage clickLogoutButtonWaitUntilLogout () {
       webDriver.findElement(By.xpath("//div[@class='header_action_login']//a[contains(@class,'help2')]"))
               .click();
    //   return new MainLoginPage(webDriver);
    //}

    //@Step("Подождать, пока не выполнится выход из системы")
    //public MainLoginPage waitUntilLogout () {

        new WebDriverWait(webDriver, 2)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'header_action_login')]//*[text()='Войти']")));
     return this;
    }

}
