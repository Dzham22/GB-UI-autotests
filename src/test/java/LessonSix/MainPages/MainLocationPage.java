package LessonSix.MainPages;

import LessonSix.Pages.BasePage;
import LessonSix.Pages.LocationChangeRegionCityPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainLocationPage extends BasePage {

    public MainLocationPage(WebDriver webDriver) {
        super(webDriver);
    }


    public LocationChangeRegionCityPage ClickOnTheLocationButton(){
        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]//*[text()='Москва']")).click();
        return new LocationChangeRegionCityPage(webDriver);
    }

    public LocationChangeRegionCityPage moveAndClickTheCityButton(){
        webDriver.findElement(By.xpath("//div[contains(@class, 'cr-contr')]/div/em")).click();

        return new LocationChangeRegionCityPage(webDriver);

    }
    public void waitUntilCityChanges () {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'cr-contr')]//*[text()='Нур-Султан']")));

    }
}
