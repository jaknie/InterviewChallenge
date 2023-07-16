package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StellenangebotePage {
    WebDriver driver;
    public StellenangebotePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='awsm-job-listing-item awsm-grid-item']//span[contains(text(),'Erfahre mehr')])[1]")
    public WebElement ErfahreMehrLink;

    @FindBy(id = "awsm-application-submit-btn")
    public WebElement sendenButton;

    @FindBy(id = "awsm-applicant-name-error")
    public WebElement applicantNameError;

    @FindBy(id = "awsm-applicant-email-error")
    public WebElement applicantEmailError;

    @FindBy(id = "awsm-applicant-phone-error")
    public WebElement applicantPhoneError;

    @FindBy(id = "awsm-cover-letter-error")
    public WebElement coverLetterError;

    @FindBy(xpath = "(//div[@class='awsm-job-entry-content entry-content']/p)[1]")
    public WebElement jobDescriptionText;

    @FindBy(id = "awsm-application-file")
    public WebElement fileAttachmentButton;

    @FindBy(className = "custom-input")
    public WebElement attachedFileName;

    @FindBy(id = "awsm_form_privacy_policy")
    public WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//input[@class='awsm-job-form-field valid']")
    public WebElement privacyPolicyCheckboxTicked;

    @FindBy(xpath = "//div[@class='awsm-job-entry-content entry-content']")
    public WebElement jobOfferBox;

    public List<WebElement> jobOffersAvailable(){
        return driver.findElements(By.xpath("//div[@class='awsm-job-listing-item awsm-grid-item']"));
    }

    public WebElement inputField(String input){
        String xpath = "(//label[contains(text(),'"+ input +"')]//../following-sibling::*)[1]";
        return driver.findElement(By.xpath(xpath));
    }

    public void putEmojiIntoField(String field){
        String emoji = "\uD83D\uDE0A";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1]", inputField(field), emoji);
    }

    public void putFirstTenWordsIntoField(String field){
        String[] wordsFromSentence = jobDescriptionText.getText().split(" ");
        StringBuilder firstTenWords = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            firstTenWords.append(wordsFromSentence[i]).append(" ");
        }
        inputField(field).sendKeys(firstTenWords.toString());
    }

}
