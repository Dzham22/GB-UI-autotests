package LessonSix.MainPages;

import LessonSix.Pages.BasePage;
import LessonSix.Pages.ProductSelectionAndPurchasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MainProductSelectionPage extends BasePage {
    Actions actions = new Actions(webDriver);
    public MainProductSelectionPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainProductSelectionPage clickTheLaptopsSubmenu(){
        webDriver.findElement(By.xpath("//div[contains(@class, 's-width')]//li[contains(@class, 'mainmenu-item')]//a[contains(@class, 'mainmenu-subitem mainmenu-icon298')]"))
                .click();
        return new MainProductSelectionPage(webDriver);
    }

    public ProductSelectionAndPurchasePage clickOnTheLaptop() {
        webDriver.findElement(By.cssSelector(".touchcarousel-item:nth-child(1) > .ctg-slider__name > span")).click();
        return new ProductSelectionAndPurchasePage(webDriver);
    }

    public MainProductSelectionPage selectAnOptionAndClickButton () {

        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@id, 'conf_prices_2102704_row')]//td[contains(@class, 'conf-prices-logo')]/a/img [contains(@alt, 'Svyaznoy.ru')]")))
                .click()
                .pause(Duration.ofSeconds(5))
                .build()
                .perform();
        return this;
    }

}