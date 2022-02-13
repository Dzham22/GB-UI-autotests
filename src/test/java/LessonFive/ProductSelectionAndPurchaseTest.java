package LessonFive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

@DisplayName("Выбор и покупка товара")
public class ProductSelectionAndPurchaseTest extends BaseTest {

    @Test
    void PositiveProductTest() {

        Actions actions = new Actions(webDriver);
        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(1200, 820));

        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'mainmenu ff-roboto')]//*[text()='Компьютеры']")))
                .build()
                .perform();

        webDriver.findElement(By.xpath("//div[contains(@class, 's-width')]//li[contains(@class, 'mainmenu-item')]//a[contains(@class, 'mainmenu-subitem mainmenu-icon298')]"))
                .click();
        webDriver.findElement(By.cssSelector(".touchcarousel-item:nth-child(1) > .ctg-slider__name > span")).click();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'item-block q11 ff-roboto')]//td[contains(@class, 'conf-td c21')]/a[contains(@id, 'link-d-2102704')]")))
                .click()
                .pause(Duration.ofSeconds(3))
                .build()
                .perform();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@id, 'conf_prices_2102704_row')]//td[contains(@class, 'conf-prices-logo')]/a/img [contains(@alt, 'Svyaznoy.ru')]")))
              .click()
              .pause(Duration.ofSeconds(5))
              .build()
              .perform();


    }


}
