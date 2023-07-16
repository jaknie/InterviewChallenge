package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MainPage {

    WebDriver driver;
    WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button.cmplz-btn.cmplz-accept")
    public WebElement acceptCookies;

    @FindBy(xpath = "(//li[contains(@class, 'wpml-ls-current-language')])")
    public WebElement languageFlag;

    @FindBy(xpath = "//nav[@id='top-menu-nav']//img[@alt='DE']")
    public WebElement germanFlag;

    @FindBy(xpath = "//nav[@id='top-menu-nav']//img[@alt='EN']")
    public WebElement englishFlag;

    public WebElement mainMenuDropdown(String dropdownName) {
        String xpath = "//nav[@id='top-menu-nav']//a[contains(text(),'" + dropdownName + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement subMenu(String subMenuName){
        String xpath = "//a[contains(text(),'"+ subMenuName +"')]//following-sibling::ul";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement buttonByText(String buttonName){
        String xpathString = "//div[contains(@class,'button')]//a[text()='"+ buttonName +"']";
        return driver.findElement(By.xpath(xpathString));
    }

    public void clickMainMenuDropdownItem(String dropdownName, String dropdownItemName){
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(mainMenuDropdown(dropdownName)));
        action.moveToElement(mainMenuDropdown(dropdownName)).build().perform();
        mainMenuDropdown(dropdownItemName).click();
    }

    public void hoverOverMainMenuDropdown(String menuItem){
        Actions action = new Actions(driver);
        action.moveToElement(mainMenuDropdown(menuItem)).build().perform();
        wait.until(ExpectedConditions.visibilityOf(subMenu(menuItem)));
    }

    public void clickGermanFlag(){
        Actions action = new Actions(driver);
        action.moveToElement(languageFlag).build().perform();
        wait.until(ExpectedConditions.visibilityOf(germanFlag));
        germanFlag.click();
    }

    public void closeCookies(){
        try {
                acceptCookies.click();
        } catch (NoSuchElementException exception) {
        }
    }


}
