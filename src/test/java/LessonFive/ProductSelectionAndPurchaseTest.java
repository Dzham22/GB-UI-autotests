package LessonFive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

@DisplayName("Выбор и покупка товара")
public class ProductSelectionAndPurchaseTest extends BaseTest {

    @Test
    void PositiveProductTest() {

        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(1200, 820));

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//*[text()='Компьютеры']")))
                .build()
                .perform();

        webDriver.findElement(By.cssSelector(".mainmenu-icon298 > .image")).click();
        webDriver.findElement(By.cssSelector(".touchcarousel-item:nth-child(1) > .ctg-slider__name > span")).click();
        webDriver.findElement(By.xpath("//td[contains(@id, 'pr_c_2102704')]//a[contains(@class, 'ib')]/u")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'hide-blacked')]/a")).click();


    }

    @Test
    void negativeProductTest() {

        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(1200, 820));

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//*[text()='Компьютеры']")))
                .build()
                .perform();

        webDriver.findElement(By.cssSelector(".mainmenu-icon298 > .image")).click();
        webDriver.findElement(By.cssSelector(".touchcarousel-item:nth-child(1) > .ctg-slider__name > span")).click();
        webDriver.findElement(By.xpath("//td[contains(@id, 'pr_c_2102704')]//a[contains(@class, 'ib')]/u")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'hide-blacked')]/a")).click();


    }
}
