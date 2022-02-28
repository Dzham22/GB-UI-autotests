package LessonSeven.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected JavascriptExecutor js;
    protected WebDriver webDriver;
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

}






