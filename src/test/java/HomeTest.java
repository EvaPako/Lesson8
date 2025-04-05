import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import mts.HomePage;

public class HomeTest {
    private static WebDriver driver;
    private static HomePage homePage;


    @BeforeSuite
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        //driver.findElement(By.xpath("//*[text()='Принять']")).click();

        // Создание экземпляра страницы
        homePage = new HomePage(driver);

        driver.manage().addCookie(new Cookie("_fbp", "fb.1.1743527539961.19365594915407187"));
        driver.manage().addCookie(new Cookie("_ga_7C99PNNT06", "GS1.1.1743527531.9.0.1743527531.60.0.0"));
        driver.manage().addCookie(new Cookie("_ga_DNC2PBDGDP", "GS1.1.1743527531.9.0.1743527531.0.0.0"));
        driver.manage().addCookie(new Cookie("BX_USER_ID", "66ad0f93a7a70c4401744df2df73ae77"));
        driver.manage().addCookie(new Cookie("PHPSESSID", "SSz91H39UDpODKb0UqKjHNl1AqNPxlPw"));
        driver.manage().addCookie(new Cookie("WEBIM_LOCALE", "ru"));

        //driver.navigate().refresh();
    }

    @AfterSuite
    public static void tearDown() {
        if (driver != null) {
            driver.navigate().refresh();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.quit();
        }
    }

    @Test(priority = 0)
    public void verifyText() {

        // Взаимодействие с элементами страницы через методы класса Page Object
//        loginPage.enterUsername("testuser");
//        loginPage.enterPassword("password123");
//        loginPage.clickLogin();

        //Assert.assertEquals(homePage.getWebElement(homePage.onlinePayBlock));
        Assert.assertEquals(driver.findElement(homePage.onlinePayBlock).getText(),
                        "Онлайн пополнение\nбез комиссии");

        //Assert.assertEquals(driver.findElement(By.xpath(
        //                "//*[@id='pay-section']/div/div/div[2]/section/div/h2")).getText(),
        //        "Онлайн пополнение\nбез комиссии");
    }

    @Test(priority = 2)
    public void checkServiceLink() {

        homePage.clickAboutService();

        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assert.assertEquals(actualUrl, expectedUrl, "URL не соответствует ожидаемому");

        homePage.navigateBack();

    }
}
