package LessonThree;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginAndLogout {

        public static void main(String[] args) throws InterruptedException
        {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--blink-settings=imagesEnabled=false");


            WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            webDriver.get("https://www.e-katalog.ru/");

            webDriver.manage().window().setSize(new Dimension(1200, 820));

            webDriver.findElement(By.cssSelector(".wu_entr > em")).click();
            webDriver.findElement(By.cssSelector(".signin-with-ek")).click();

            By authFormLocator = By.xpath("//div[contains(@id, 'mui_user_login_window')]");
            WebElement authForm = webDriver.findElement(authFormLocator);
            authForm.findElement(By.xpath("//input[contains(@name, 'l_')]")).sendKeys("jrockiy@mail.ru");
            authForm.findElement(By.xpath("//div[contains(@class, 'signin-password ek-form-group')]/input[contains(@name, 'pw_')]")).sendKeys("9Torres99");
            authForm.findElement(By.xpath("//div[contains(@class, 'signin-actions ml-auto')]/button[contains(@class, 'ek-form-btn blue')]")).click();
            webDriver.findElement(By.xpath("//a[contains(@class,'help2')]")).click();



            new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[text()='Войти']"))));
            webDriver.quit();

        }


}
