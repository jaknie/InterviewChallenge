package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class EventsPage {

    WebDriver driver;
    public EventsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tribe-events-events-bar-keyword")
    public WebElement searchField;

    @FindBy(name = "submit-bar")
    public WebElement submitBar;

    @FindBy(xpath = "//div[@class='tribe-events-c-top-bar__datepicker']//*[local-name()='svg']")
    public WebElement calendarOpenCloseArrow;

    @FindBy(className = "prev")
    public WebElement previousMonth;

    @FindBy(xpath = "//div[@class='datepicker-days']//th[@class='datepicker-switch']")
    public WebElement date;

    @FindBy(className = "entry-title")
    public WebElement pageTitle;

    @FindBy(xpath = "//div[contains(@class,'datepicker-dropdown')]")
    public WebElement datePicker;

    @FindBy(className = "tribe-event-date-start")
    public WebElement eventStartDate;

    @FindBy(className = "tribe-events-c-messages__message-list-item")
    public WebElement emptyList;

    public List<WebElement> getEventsList(){
        return driver.findElements(By.className("tribe-events-calendar-list__event-header"));
    }

    public WebElement getHeader(String headerName) {
        String xpath = "//div[@class='tribe-events-calendar-list']//a[contains(text(),'"+ headerName +"')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement dateDay(String userDay){
        String xpath = "//td[text()='"+ userDay +"']";
        return driver.findElement(By.xpath(xpath));
    }

}