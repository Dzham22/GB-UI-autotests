package LessonSix.Pages;

import LessonSix.MainPages.MainProductSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ProductSearchPage  extends BasePage{
    Actions actions = new Actions(webDriver);

    public ProductSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainProductSearchPage enterAValueInTheSearch (){
        webDriver.findElement(By.id("ek-search")).sendKeys("Сумка для ноутбука");
        return new MainProductSearchPage(webDriver);
    }

    public MainProductSearchPage moveToAccordeonElement () {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'list-sort ')]//div[contains(@class, 'lf-icon-up')]")))
                .click()
                .pause(Duration.ofSeconds(3))
                .build()
                .perform();
        return new MainProductSearchPage(webDriver);
    }

    public ProductSearchPage moveAndSelectDeliveryCheckbox () {

        actions.moveToElement(webDriver.findElement(By.xpath("//div[@class = 'only-with-delivery-offer']/input")))
                .click()
                .pause(Duration.ofSeconds(5))
                .build()
                .perform();
        return this;
    }

}

