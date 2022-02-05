package LessonFive;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

public class FiltersAndProductComparisonTest extends BaseTest{

    @Test
    void PositiveFilterTest(){

        JavascriptExecutor js;
        js = (JavascriptExecutor) webDriver;
        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(1200, 820));
        webDriver.findElement(By.xpath("//*[text()='Компьютеры']")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'mainmenu-sublist')]//a[contains(@class, 'mainmenu-subitem mainmenu-icon298')]")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'poduct-presets')]//a[contains(@href, '/list/298/pr-4518/')]")).click();
        js.executeScript("window.scrollTo(0,200)");
        webDriver.findElement(By.xpath("//label[contains(@for, 'br3917')]")).click();
        webDriver.findElement(By.linkText("Показать")).click();
        webDriver.findElement(By.cssSelector("#con-1682153 .conf-tr:nth-child(1) .conf-label")).click();
        webDriver.findElement(By.cssSelector(".conf-tr:nth-child(9) .conf-label")).click();
        webDriver.findElement(By.xpath("//li[contains(@class, \'goods-bar-section\')]//span[contains(@id, \'name_bm_compared\')]")).click();




    }

}
