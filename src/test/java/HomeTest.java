import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import mts.HomePage;

public class HomeTest {
    private static WebDriver driver;
    private static HomePage homePage;


    @BeforeSuite
    public static void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        homePage = new HomePage(driver);
        homePage.acceptCookies();

    }

    @AfterSuite
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 0)
    public void verifyText() {

        WebElement webElement = homePage.getWebElement(homePage.onlinePayBlock);
        Assert.assertEquals(webElement.getText(), "Онлайн пополнение\nбез комиссии");

    }

    @Test(priority = 1)
    public void verifyLogotype() {

        try {
            for (By logo : homePage.paymentLogos) {
            WebElement logoElement = homePage.getWebElement(logo);
            Assert.assertTrue(logoElement.isDisplayed(), "Логотип не найден: " + logo);
        }

        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }

  @Test(priority = 2)
    public void checkServiceLink() {
        homePage.clickAboutService();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assert.assertEquals(actualUrl, expectedUrl, "URL не соответствует ожидаемому");
        homePage.navigateBack();
    }

    @Test(priority = 3)
    public void Input () {
        homePage.enterPhone("297777777");
        homePage.enterSum("250");
        homePage.clickPay();
    }

    @Test(priority = 4)
    public void testPlaceHolders(){

        try {
            for (String[] element : homePage.elementsPayForm) {
                WebElement inputField = homePage.getWebElement(By.id(element[0]));
                String placeholderValue = inputField.getAttribute("placeholder");
                Assert.assertEquals(placeholderValue, element[1], "У элемента " + element[0] + " надпись незаполненого поля не соответствует ожидаемому");
            }

        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
    }

    @Test(priority = 5)
    public void checkFrame () {

        //Выбираем Услуги связи
        homePage.enterPhone("297777777");
        homePage.enterSum("250");
        homePage.clickPay();
    }
}



