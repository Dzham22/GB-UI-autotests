package LessonThree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import java.util.concurrent.TimeUnit;

public class ProductSelectionAndPurchase {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://www.e-katalog.ru/");
        webDriver.manage().window().setSize(new Dimension(1200, 820));

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//*[text()='Компьютеры']")))
                .build()
                .perform();

        webDriver.findElement(By.cssSelector(".mainmenu-icon298 > .image")).click();
        webDriver.findElement(By.cssSelector(".touchcarousel-item:nth-child(1) > .ctg-slider__name > span")).click();
        webDriver.findElement(By.xpath("//td[contains(@id, 'pr_c_2102704')]//a[contains(@class, 'ib')]/u")).click();
        webDriver.findElement(By.xpath("//div[contains(@class, 'hide-blacked')]/a")).click();


     Thread.sleep(10000);
     webDriver.quit();

    }
}