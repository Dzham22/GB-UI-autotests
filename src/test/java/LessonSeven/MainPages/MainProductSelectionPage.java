package LessonSeven.MainPages;

import LessonSeven.Pages.BasePage;
import LessonSeven.Pages.ProductSelectionAndPurchasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MainProductSelectionPage extends BasePage {
    Actions actions = new Actions(webDriver);
    public MainProductSelectionPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Кликнуть на подменю \"Ноутбуки\"")
    public MainProductSelectionPage clickTheLaptopsSubmenu(){
        webDriver.findElement(By.xpath("//div[contains(@class, 's-width')]//li[contains(@class, 'mainmenu-item')]//a[contains(@class, 'mainmenu-subitem mainmenu-icon298')]"))
                .click();
        return new MainProductSelectionPage(webDriver);
    }

    @Step("Кликнуть на ноутбук")
    public ProductSelectionAndPurchasePage clickOnTheLaptop() {
        webDriver.findElement(By.cssSelector(".touchcarousel-item:nth-child(1) > .ctg-slider__name > span")).click();
        return new ProductSelectionAndPurchasePage(webDriver);
    }

    @Step("Выбрать интернет-магазин из кликнуть на него")
    public MainProductSelectionPage moveToOnlineStoreAndClickOnIt () {

        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@id, 'conf_prices_2102704_row')]//td[contains(@class, 'conf-prices-logo')]/a/img [contains(@alt, 'Svyaznoy.ru')]")))
                .click()
                .pause(Duration.ofSeconds(5))
                .build()
                .perform();
        return this;
    }

}