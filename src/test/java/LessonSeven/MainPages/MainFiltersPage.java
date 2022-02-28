package LessonSeven.MainPages;

import LessonSeven.Pages.BasePage;
import LessonSeven.Pages.FiltersAndProductPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class MainFiltersPage extends BasePage {
        Actions actions = new Actions(webDriver);
        public MainFiltersPage(WebDriver webDriver) {
            super(webDriver);
        }


    @Step("Кликнуть на подменю \"Комрьютеры\"")
    public FiltersAndProductPage clickSubmenuLaptops() {

        webDriver.findElement(By.xpath("//*[text()='Компьютеры']")).click();
        return new FiltersAndProductPage(webDriver);
    }

    @Step("Переместиться на фильтры на кликнуть ссылку \"Все бренды\"")
    public FiltersAndProductPage moveToElementAndClick(){
        js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0,200)");
        actions.moveToElement(webDriver.findElement(By.xpath("//span[@id='br_all']/em")))
                .pause(Duration.ofSeconds(1))
                .click()
                .build()
                .perform();
        return new FiltersAndProductPage(webDriver);
    }

    @Step("Выбрать и кликнуть на два товара из модификации")
    public MainFiltersPage chooseTwoOptionsForComparison (){
        webDriver.findElement(By.xpath("//div//td[contains(@class, 'conf-td')]/label[contains(@for, 'chk_1682198')]")).click();
        webDriver.findElement(By.xpath("//div//td[contains(@class, 'conf-td')]/label[contains(@for, 'chk_1653337')]")).click();
        return new MainFiltersPage(webDriver);

    }

    @Step("Кликнуть на кнопку \"Сравнить\"")
    public MainFiltersPage clickTheCompareButton(){
        webDriver.findElement(By.xpath("//div/ul/li[contains(@id, 'compared')]/a")).click();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'common-table-div s-width')]//h1")))
                .pause(Duration.ofSeconds(2))
                .build()
                .perform();
        return new MainFiltersPage(webDriver);
    }
}
