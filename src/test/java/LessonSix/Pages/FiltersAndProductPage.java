package LessonSix.Pages;

import LessonSix.MainPages.MainFiltersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FiltersAndProductPage extends BasePage {


    public FiltersAndProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainFiltersPage clickOnParameterInTheFilter() {
        webDriver.findElement(By.xpath("//div[contains(@class, 'mainmenu-sublist')]//a[contains(@class, 'mainmenu-subitem mainmenu-icon298')]")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'poduct-presets')]//a[contains(@href, '/list/298/pr-4518/')]")).click();
        return new MainFiltersPage (webDriver);
    }

    public FiltersAndProductPage selectAndClickBrandInTheFilter(){
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Показать")));
        webDriver.findElement(By.xpath("//div[contains(@class, 'arrow-start')]/*[text() ='Показать']")).click();
        return new FiltersAndProductPage(webDriver);

    }
    public MainFiltersPage moveToChosenModifications(){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class, 'conf-div-short')]//table[contains(@data-group-url, '/XIAOMI-MI-GAMING-LAPTOP-2019.htm')]")))
                .pause(Duration.ofSeconds(1))
                .build()
                .perform();
        actions.moveToElement(webDriver.findElement(By.xpath("//div[contains(@id, 'con-1682153')]/table")))
                .pause(Duration.ofSeconds(1))
                .build()
                .perform();
        return new MainFiltersPage(webDriver);

    }









}
