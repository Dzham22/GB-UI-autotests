package LessonSeven.MainPages;

import LessonSeven.Pages.BasePage;
import LessonSeven.Pages.LocationChangeRegionCityPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainLocationPage extends BasePage {

    public MainLocationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Клинуть на кнопку \"Локация\"" )
    public LocationChangeRegionCityPage ClickOnTheLocationButton(){
        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]//*[text()='Москва']")).click();
        return new LocationChangeRegionCityPage(webDriver);
    }
    @Step("Перейти и кликнуть кнопку" )
    public LocationChangeRegionCityPage moveAndClickTheCityButton(){
        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]/div/em")).click();

        return new LocationChangeRegionCityPage(webDriver);

    }

    @Step("Подождать, пока не сменится Город" )
    public void waitUntilCityChanges () {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'cr-contr')]//*[text()='Нур-Султан']")));

    }
}
