package LessonSix.MainPages;

import LessonSix.Pages.BasePage;
import LessonSix.Pages.FiltersAndProductPage;
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

    public FiltersAndProductPage clickSubmenuLaptops() {

        webDriver.findElement(By.xpath("//*[text()='Компьютеры']")).click();
        return new FiltersAndProductPage(webDriver);
    }

    public  FiltersAndProductPage moveToElementAndClick(){
        JavascriptExecutor js;
        js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0,200)");
        webDriver.findElement(By.xpath("//label[contains(@for, 'br3917')]")).click();
        return new FiltersAndProductPage(webDriver);

    }

    public MainFiltersPage chooseTwoOptionsForComparison (){
        webDriver.findElement(By.xpath("//div//td[contains(@class, 'conf-td')]/label[contains(@for, 'chk_1718063')]")).click();
        webDriver.findElement(By.xpath("//div//td[contains(@class, 'conf-td')]/label[contains(@for, 'chk_1653337')]")).click();
        return new MainFiltersPage(webDriver);

    }

    public MainFiltersPage clickTheCompareButton(){
        webDriver.findElement(By.xpath("//div/ul/li[contains(@id, 'compared')]/a")).click();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'common-table-div s-width')]//h1")))
                .pause(Duration.ofSeconds(2))
                .build()
                .perform();
        return new MainFiltersPage(webDriver);

    }

}
