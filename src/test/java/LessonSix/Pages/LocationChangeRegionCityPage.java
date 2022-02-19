package LessonSix.Pages;

import LessonSix.MainPages.MainLocationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class LocationChangeRegionCityPage extends BasePage{
    Actions actions = new Actions(webDriver);

    public LocationChangeRegionCityPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainLocationPage clickTheRegionButtonChange(){
        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'jouter-white')]")))
                .pause(Duration.ofSeconds(2))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//div[contains(@class, 'jouter-white')]//div[contains(@class, 'lf-icon-up')]")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'jouter-white')]//div[contains(@class, 'lf-popup open')]/a")).click();
        return new MainLocationPage(webDriver);
    }

    public MainLocationPage clickAndChangeTheCity(){
        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]//div[contains(@class, 'posr')]/input")).click();
        actions.sendKeys("Нур-Султан").pause(Duration.ofSeconds(3)).build().perform();
        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]//td[contains(@class, 'city')]")).click();
        return new MainLocationPage(webDriver);
    }
}
