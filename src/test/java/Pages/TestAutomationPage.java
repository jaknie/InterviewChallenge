package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class TestAutomationPage {

    WebDriver driver;
    WebDriverWait wait;

    public TestAutomationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='et_pb_module_header']/span")
    public WebElement pageHeader;

    public List<WebElement> paragraphsText() {
        return driver.findElements(By.xpath("//div[@class='et_pb_text_inner']/p"));
    }

    public List<String> getTextList() {
        List<String> textList = new ArrayList<>();

        for (WebElement paragraph : paragraphsText()) {
            String text = paragraph.getText();
            textList.add(text);
        }
        return textList;
    }

}
