package LessonThree;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FiltersAndProductComparison  {
    public static void main(String[] args) throws InterruptedException {


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");
        JavascriptExecutor js;

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        js = (JavascriptExecutor) webDriver;
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(1200, 820));

        webDriver.findElement(By.xpath("//*[text()='Компьютеры']")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'mainmenu-sublist')]//a[contains(@class, 'mainmenu-subitem mainmenu-icon298')]")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'poduct-presets')]//a[contains(@href, '/list/298/pr-4518/')]")).click();
        js.executeScript("window.scrollTo(0,200)");
        webDriver.findElement(By.xpath("//label[contains(@for, 'br3917')]")).click();
        webDriver.findElement(By.linkText("Показать")).click();
        webDriver.findElement(By.cssSelector("#con-1682153 .conf-tr:nth-child(1) .conf-label")).click();
        webDriver.findElement(By.cssSelector(".conf-tr:nth-child(9) .conf-label")).click();
        webDriver.findElement(By.xpath("//li[contains(@class, \'goods-bar-section\')]//span[contains(@id, \'name_bm_compared\')]")).click();

        Thread.sleep(10000);
        webDriver.quit();
    }
}