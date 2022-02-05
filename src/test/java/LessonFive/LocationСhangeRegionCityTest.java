package LessonFive;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

public class LocationСhangeRegionCityTest extends BaseTest{

    @Test
    void positiveChangeLocationTest() {
        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(1076, 816));
        webDriver.findElement(By.id("gz67ymjh4tm")).click();
        webDriver.findElement(By.cssSelector(".lf-select")).click();
        webDriver.findElement(By.linkText("Казахстан")).click();
        webDriver.findElement(By.id("gz67yqmjyov")).click();
        webDriver.findElement(By.id("gz67ys0w61v")).click();
        webDriver.findElement(By.id("gz6806y4mtv")).sendKeys(Keys.DOWN);
        webDriver.findElement(By.id("gz67ys0w61v")).sendKeys("Алматы");
        webDriver.findElement(By.cssSelector(".city")).click();

    }

    @Test
    void negativeChangeLocationTest() {

    }
}
