package LessonFive;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ProductSearchTest extends BaseTest {
    @Test
    void positiveProductSearchTest() {

        Actions actions = new Actions(webDriver);
        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(1076, 816));
        webDriver.findElement(By.id("ek-search")).click();
        webDriver.findElement(By.id("ek-search")).sendKeys("Сумка для ноутбука");
        webDriver.findElement(By.xpath("//div[contains(@class, 'header_search')]/*[text() = 'Найти']")).click();

        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'list-sort ')]//div[contains(@class, 'lf-icon-up')]")))
                .click()
                .pause(Duration.ofSeconds(3))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//div[contains(@class, 'list-sort ')]//div[contains(@class, 'lf-popup open')]/*[text()='от дорогих к дешевым']"))
                .click();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'common-table-div s-width')]//div[contains(@class, 'ib only-with-delivery-offer')]/input")))
                .click()
                .pause(Duration.ofSeconds(5))
                .build()
                .perform();

    }


}
