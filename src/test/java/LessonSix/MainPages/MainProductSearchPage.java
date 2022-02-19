package LessonSix.MainPages;

import LessonSix.Pages.BasePage;
import LessonSix.Pages.ProductSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainProductSearchPage extends BasePage {

    public MainProductSearchPage(WebDriver webDriver) {
            super(webDriver);
        }

    public ProductSearchPage clickInTheSearchField(){
        webDriver.findElement(By.id("ek-search")).click();
        return new ProductSearchPage (webDriver);

    }

    public ProductSearchPage clickSearchButton (){
        webDriver.findElement(By.xpath("//div[contains(@class, 'header_search')]/*[text() = 'Найти']")).click();
        return new ProductSearchPage(webDriver);
    }

    public ProductSearchPage chooseOneOfTheCheckboxOptions (){
        webDriver.findElement(By.xpath("//div[contains(@class, 'list-sort ')]//div[contains(@class, 'lf-popup open')]/*[text()='от дорогих к дешевым']"))
                .click();
        return new ProductSearchPage (webDriver);
    }










}
