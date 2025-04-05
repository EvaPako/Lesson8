package mts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    // Локаторы элементов страницы
    public By onlinePayBlock = By.xpath(
            "//*[@id='pay-section']/div/div/div[2]/section/div/h2");

    private By visaLogo = By.cssSelector("img[alt='Visa']");
    private By vByVisaLogo = By.cssSelector("img[alt='Verified By Visa']");
    private By masterCardLogo = By.cssSelector("img[alt='MasterCard']");
    private By MasterCardSCLogo = By.cssSelector("img[alt='MasterCard Secure Code']");
    private By belcardLogo = By.cssSelector("img[alt='Белкарт']");

    private By aboutServiceLink = By.linkText("Подробнее о сервисе");


     private By usernameField = By.id("username");
     private By passwordField = By.id("password");
     private By loginButton = By.id("login");

    // Конструктор
    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    // Методы для взаимодействия с элементами страницы
    public void clickAboutService(){
        WebElement aboutServiceElement = driver.findElement(aboutServiceLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutServiceElement).doubleClick().build().perform();
    }

    public void navigateBack(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.navigate().back();
        driver.navigate().refresh();
    }

    public WebElement getWebElement(By elementLocator){
        return driver.findElement(elementLocator);
    }

    public void enterUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}

