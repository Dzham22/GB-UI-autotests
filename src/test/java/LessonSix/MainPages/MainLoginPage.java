package LessonSix.MainPages;

import LessonSix.Pages.BasePage;
import LessonSix.Pages.LoginAndLogoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


    public class MainLoginPage extends BasePage {
        Actions actions = new Actions(webDriver);

        public MainLoginPage(WebDriver webDriver) {
            super(webDriver);
        }


    public LoginAndLogoutPage clickLoginButton () {
        webDriver.findElement(By.cssSelector(".wu_entr > em")).click();
        webDriver.findElement(By.cssSelector(".signin-with-ek")).click();
        return new LoginAndLogoutPage(webDriver);
    }

    public MainLoginPage clickLogoutButton () {
        webDriver.findElement(By.xpath("//a[contains(@class,'help2')]")).click();
        return new MainLoginPage(webDriver);

    }

    public MainLoginPage waitUntilLogout () {

        new WebDriverWait(webDriver, 2)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'header_action_login')]//*[text()='Войти']")));
        return this;
    }

}
