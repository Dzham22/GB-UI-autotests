package LessonFive;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchTest extends BaseTest {
    @Test
    void positiveProductSearchTest() {


        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(1076, 816));
        webDriver.findElement(By.id("ek-search")).click();
        webDriver.findElement(By.id("ek-search")).sendKeys("Сумка для ноутбука");
        webDriver.findElement(By.linkText("Сумка для ноутбука с USB")).click();


    }


    @Test
    void negativeProductSearchTest() {
        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(1076, 816));
        webDriver.findElement(By.id("ek-search")).click();
        webDriver.findElement(By.id("ek-search")).sendKeys("Refbnm cwvre lkz yjen,erf");


        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'msg-search-div')]")));


    }

}
