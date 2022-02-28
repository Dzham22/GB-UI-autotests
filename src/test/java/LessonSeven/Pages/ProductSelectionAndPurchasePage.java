package LessonSeven.Pages;

import LessonSeven.MainPages.MainProductSelectionPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ProductSelectionAndPurchasePage extends BasePage {
    Actions actions = new Actions(webDriver);

    public ProductSelectionAndPurchasePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Переместить на главное меню")
    public MainProductSelectionPage moveToHeaderMenu() {

        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'mainmenu ff-roboto')]//*[text()='Компьютеры']")))
                .build()
                .perform();
        return new MainProductSelectionPage(webDriver);
    }

    @Step("Кликнуть на модификацию")
    public MainProductSelectionPage clickOnModification() {

        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'item-block q11 ff-roboto')]//td[contains(@class, 'conf-td c21')]/a[contains(@id, 'link-d-2102704')]")))
                .click()
                .pause(Duration.ofSeconds(3))
                .build()
                .perform();
        return new MainProductSelectionPage(webDriver);
    }
}
