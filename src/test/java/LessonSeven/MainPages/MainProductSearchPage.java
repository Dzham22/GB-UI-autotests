package LessonSeven.MainPages;

import LessonSeven.Pages.BasePage;
import LessonSeven.Pages.ProductSearchPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainProductSearchPage extends BasePage {

    public MainProductSearchPage(WebDriver webDriver) {
            super(webDriver);
        }

    @Step("Кликнуть на поле поиска")
    public ProductSearchPage clickInTheSearchField(){
        webDriver.findElement(By.id("ek-search")).click();
        return new ProductSearchPage(webDriver);

    }

    @Step("Кликнуть на кнопку \"Поиск\"")
    public ProductSearchPage clickSearchButton (){
        webDriver.findElement(By.xpath("//div[contains(@class, 'header_search')]/*[text() = 'Найти']")).click();
        return new ProductSearchPage(webDriver);
    }

    @Step("Выбрать один из парамертров элемента")
    public ProductSearchPage chooseOneOfTheAccordeonOptions (){
        webDriver.findElement(By.xpath("//div[contains(@class, 'list-sort ')]//div[contains(@class, 'lf-popup open')]/*[text()='от дорогих к дешевым']"))
                .click();
        return new ProductSearchPage(webDriver);
    }










}
