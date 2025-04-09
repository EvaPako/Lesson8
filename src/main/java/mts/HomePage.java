package mts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

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

    private final By phoneField = By.xpath("//*[@id='connection-phone']");
    private final By sumField = By.xpath("//*[@id='connection-sum']");
    private final By payButton = By.xpath("//*[@id='pay-connection']/button");

    // Конструктор
    public HomePage (WebDriver driver) {
        this.driver = driver;
    }


   public void clickAboutService(){
       driver.findElement(ServiceInfo).click();

    }

    public void navigateBack(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().back();

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

    public void acceptCookies(){
        driver.findElement(buttonCookieAgree).click();

    }
}

