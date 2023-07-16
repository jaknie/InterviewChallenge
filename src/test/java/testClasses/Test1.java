package testClasses;

import Hook.Hook;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.testng.Assert;

import java.util.List;


public class Test1 extends Hook {
    String getPageURLStep3;
    String getPageURLStep9;
    String getPageHeaderStep3;
    String getPageHeaderStep9;
    List<String> getTextListStep3;
    List<String> getGetTextListStep9;


    @Test
    public void step1() {
        driver.get("https://www.qualityminds.com");
        mainPage.closeCookies();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qualityminds.com/");
    }

    @Test
    public void step2() {
        mainPage.clickGermanFlag();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qualityminds.com/de/");
    }

    @Test
    public void step3() {
        wait.until(ExpectedConditions.visibilityOf(mainPage.mainMenuDropdown("PORTFOLIO")));
        mainPage.clickMainMenuDropdownItem("PORTFOLIO", "Automatisiertes Testen");
        wait.until(ExpectedConditions.visibilityOf(testAutomationPage.pageHeader));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qualityminds.com/de/portfolio/qa-kernkompetenzen/automatisiertes-testen/");

        getPageURLStep3 = driver.getCurrentUrl();
        getPageHeaderStep3 = testAutomationPage.pageHeader.getText();
        getTextListStep3 = testAutomationPage.getTextList();
    }

    @Test
    public void step4() {
        wait.until(ExpectedConditions.visibilityOf(mainPage.buttonByText("KONTAKTIERE UNS")));
        Assert.assertTrue(mainPage.buttonByText("KONTAKTIERE UNS").isDisplayed());
        Assert.assertTrue(mainPage.buttonByText("KONTAKTIERE UNS")
                .getAttribute("href").startsWith("mailto:testing@qualityminds.de"));
    }

    @Test
    public void step5() {
        driver.get("https://www.qualityminds.com");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qualityminds.com/");
    }

    @Test
    public void step6() {
        Assert.assertTrue(mainPage.englishFlag.isDisplayed());
        //dopisać
    }

    @Test
    public void step7() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException reallyIgnored) {}

        mainPage.clickMainMenuDropdownItem("SERVICES", "Test Automation");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qualityminds.com/services/core-qa-services/test-automation/");
    }

    @Test
    public void step8() {
        mainPage.clickGermanFlag();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qualityminds.com/de/portfolio/qa-kernkompetenzen/automatisiertes-testen/");
    }

    @Test
    public void step9() {
        getPageURLStep9 = driver.getCurrentUrl();
        getPageHeaderStep9 = testAutomationPage.pageHeader.getText();
        getGetTextListStep9 = testAutomationPage.getTextList();

        Assert.assertEquals(getPageHeaderStep3, getPageHeaderStep9);
        Assert.assertEquals(getPageURLStep3, getPageURLStep9);
        Assert.assertEquals(getTextListStep3, getGetTextListStep9);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}