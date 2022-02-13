package LessonFive;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocationChangeRegionCityTest extends BaseTest{

    @Test
    void positiveChangeLocationTest() {
        Actions actions = new Actions(webDriver);
        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(1200, 820));

        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]//*[text()='Москва']")).click();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'jouter-white')]")))
                .pause(Duration.ofSeconds(2))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//div[contains(@class, 'jouter-white')]//div[contains(@class, 'lf-icon-up')]")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'jouter-white')]//div[contains(@class, 'lf-popup open')]/a")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]/div/em")).click();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'jouter-white')]")))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]//div[contains(@class, 'posr')]/input")).click();
        actions.sendKeys("Нур-Султан").pause(Duration.ofSeconds(3)).build().perform();
        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]//td[contains(@class, 'city')]")).click();


        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'cr-contr')]//*[text()='Нур-Султан']")));
    }


}
