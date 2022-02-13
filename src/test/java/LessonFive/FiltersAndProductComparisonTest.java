package LessonFive;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Показать")));
        webDriver.findElement(By.xpath("//div[contains(@class, 'arrow-start')]/*[text() ='Показать']")).click();

        Actions actions = new Actions(webDriver);
             actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'conf-div-short')]//table[contains(@data-group-url, '/XIAOMI-MI-GAMING-LAPTOP-2019.htm')]")))
                     .pause(Duration.ofSeconds(1))
                     .build()
                     .perform();
             actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@id, 'con-1682153')]/table")))
                     .pause(Duration.ofSeconds(1))
                     .build()
                     .perform();

        webDriver.findElement(By.xpath("//div//td[contains(@class, 'conf-td')]/label[contains(@for, 'chk_1718063')]")).click();
        webDriver.findElement(By.xpath("//div//td[contains(@class, 'conf-td')]/label[contains(@for, 'chk_1653337')]")).click();
        webDriver.findElement(By.xpath("//div/ul/li[contains(@id, 'compared')]/a")).click();

        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'common-table-div s-width')]//h1")))
                .pause(Duration.ofSeconds(2))
                .build()
                .perform();



    }

}
