package TestClasses;

import Hook.Hook;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import org.testng.Assert;


public class Test3 extends Hook {

    @Test
    public void step1(){
        driver.get("https://qualityminds.com/de/karriere/stellenangebote/");
        mainPage.closeCookies();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qualityminds.com/de/karriere/stellenangebote/");
    }

    @Test
    public void step2(){
        Assert.assertFalse(stellenangebotePage.jobOffersAvailable().isEmpty());
    }

    @Test
    public void step3(){
        stellenangebotePage.ErfahreMehrLink.click();
        Assert.assertTrue(stellenangebotePage.jobOfferBox.isDisplayed());
    }

    @Test
    public void step4(){
        stellenangebotePage.sendenButton.click();
        Assert.assertTrue(stellenangebotePage.applicantNameError.isDisplayed());
        Assert.assertTrue(stellenangebotePage.applicantEmailError.isDisplayed());
        Assert.assertTrue(stellenangebotePage.applicantPhoneError.isDisplayed());
        Assert.assertTrue(stellenangebotePage.coverLetterError.isDisplayed());
    }

    @Test
    public void step5(){
        stellenangebotePage.inputField("Vorname und Nachname").sendKeys("Jakub Niechaj");
        Assert.assertFalse(stellenangebotePage.applicantNameError.isDisplayed());
    }

    @Test
    public void step6(){
        stellenangebotePage.putEmojiIntoField("Email");
        stellenangebotePage.inputField("Email").sendKeys(Keys.TAB);
        Assert.assertEquals(stellenangebotePage.applicantEmailError.getText(), "Bitte gebe eine gültige E-Mail-Adresse ein.");
    }

    @Test
    public void step7(){
        stellenangebotePage.putFirstTenWordsIntoField("Bewerbungsschreiben");
        Assert.assertFalse(stellenangebotePage.coverLetterError.isDisplayed());
    }

    @Test
    public void step8(){
        stellenangebotePage.fileAttachmentButton.sendKeys("C:\\Users\\Kuba\\Desktop\\FakeCV.docx");
        Assert.assertEquals(stellenangebotePage.attachedFileName.getText(), "FakeCV.docx");
    }

    @Test
    public void step9(){
        stellenangebotePage.privacyPolicyCheckbox.click();
        Assert.assertTrue(stellenangebotePage.privacyPolicyCheckboxTicked.isDisplayed());
    }

}