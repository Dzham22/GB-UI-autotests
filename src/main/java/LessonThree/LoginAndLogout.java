package LessonThree;

public class LoginAndLogout {

        public static void main( String[] args )
        {
            System.setProperty( "webdriver.chrome.driver","src/main/resources/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

            WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            webDriver.get("https://www.e-katalog.ru/");

            webDriver.manage().window().setSize(new Dimension(1300, 720));

            webDriver.findElement(By.linkText("Войти")).click();
            By authFormLocator = By.xpath("//form[contains(@name,'system_auth')]");
            new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
            WebElement authForm = webDriver.findElement(authFormLocator);
            authForm.findElement(By.name("USER_LOGIN")).sendKeys("autosupertravel@yandex.ru");
            authForm.findElement(By.name("USER_PASSWORD")).sendKeys("12345678");
            authForm.findElement(By.xpath("//button[span[text()='Войти']]")).click();

            webDriver.findElement(By.cssSelector("div.header__user")).click();
            webDriver.findElement(By.linkText("Выйти")).click();

            new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Войти")));
            webDriver.quit();
        }


}
