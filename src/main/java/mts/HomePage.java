package mts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import java.time.Duration;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

public class HomePage {
    private final WebDriver driver;

    public By onlinePayBlock = By.xpath(
            "//*[@id='pay-section']//h2");

    private final By buttonCookieAgree = By.id("cookie-agree");

    public By visaLogo = By.cssSelector("img[alt='Visa']");
    public By vByVisaLogo = By.cssSelector("img[alt='Verified By Visa']");
    public By masterCardLogo = By.cssSelector("img[alt='MasterCard']");
    public By MasterCardSCLogo = By.cssSelector("img[alt='MasterCard Secure Code']");
    public By belcardLogo = By.cssSelector("img[alt='Белкарт']");


    public final By [] paymentLogos = {
            visaLogo,
            vByVisaLogo,
            masterCardLogo,
            MasterCardSCLogo,
            belcardLogo};

    private final By ServiceInfo = By.linkText("Подробнее о сервисе");

    private final By serviceDropdown = By.xpath("//*[@id='pay-section']//button/span[2]");
    private final By phoneField = By.xpath("//*[@id='connection-phone']");
    private final By sumField = By.xpath("//*[@id='connection-sum']");
    private final By payButton = By.xpath("//*[@id='pay-connection']/button");


    public final By uslugiSvyazi = By.xpath( "//*[@id='pay-section'']//ul/li[1]/p");
    public final By homeInternet = By.xpath( "//*[@id='pay-section'']//ul/li[2]/p");
    public final By rassrochka = By.xpath( "//*[@id='pay-section']//ul/li[3]/p");
    public final By sadolzhnost = By.xpath("//*[@id='pay-section']//ul/li[4]/p");


    public String [][] elementsPayForm = new String[][]{
            {"connection-phone", "Номер телефона"},
            {"connection-sum", "Сумма"},
            {"connection-email", "E-mail для отправки чека"},
            {"internet-phone", "Номер абонента"},
            {"internet-sum", "Сумма"}
    };

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies(){
        WebElement cook = driver.findElement(buttonCookieAgree);
        if (cook.isDisplayed()){
            cook.click();
        }

    }

   public void clickAboutService(){
       driver.findElement(ServiceInfo).click();

    }

    public WebElement getWebElement(By elementLocator){
        return driver.findElement(elementLocator);
    }

    public void enterPhone(String phone) {
        WebElement phoneElement = driver.findElement(phoneField);
        phoneElement.clear();
        phoneElement.sendKeys(phone);
    }

    public void enterSum(String sum) {
        WebElement sumElement = driver.findElement(sumField);
        sumElement.clear();
        sumElement.sendKeys(sum);
    }

    public void clickPay() {
        driver.findElement(payButton).click();
    }

    public void navigateBack(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().back();

    }


    public void selectService(String service) {
        driver.findElement(serviceDropdown).sendKeys(service); // Выбор услуги из выпадающего списка
    }

    public String getPhonePlaceholder() {
        return driver.findElement(phoneField).getAttribute("placeholder");
    }

    public String getSumPlaceholder() {
        return driver.findElement(sumField).getAttribute("placeholder");
    }
}




