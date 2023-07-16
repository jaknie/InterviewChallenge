package testClasses;

import Hook.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.testng.Assert;


public class Test2 extends Hook {

    @Test
    public void step1() {
        driver.get("https://www.qualityminds.com");
        mainPage.closeCookies();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qualityminds.com/");
    }

    @Test
    public void step2(){
        Assert.assertTrue(mainPage.englishFlag.isDisplayed());
    }

    @Test
    public void step3(){
        mainPage.hoverOverMainMenuDropdown("ABOUT US");
        Assert.assertTrue(mainPage.subMenu("ABOUT US").isDisplayed());
    }

    @Test
    public void step4(){
        mainPage.mainMenuDropdown("Events").click();
        Assert.assertEquals(eventsPage.pageTitle.getText(), "Events");
    }

    @Test
    public void step5(){
        eventsPage.searchField.sendKeys("2021");
        eventsPage.submitBar.click();
        wait.until(ExpectedConditions.visibilityOf(eventsPage.emptyList));
        Assert.assertTrue(eventsPage.getEventsList().isEmpty());
    }

    @Test
    public void step6(){
        eventsPage.calendarOpenCloseArrow.click();
        Assert.assertTrue(eventsPage.datePicker.isDisplayed());
    }

    @Test
    public void step7(){
        String dateText = eventsPage.date.getText();
        while (!dateText.equals("December 2021")){
            eventsPage.previousMonth.click();
            dateText = eventsPage.date.getText();

        }
        wait.until(ExpectedConditions.elementToBeClickable(eventsPage.dateDay("31")));
        eventsPage.dateDay("31").click();
    }

    @Test
    public void step8(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'ICSTTP 2021')]")));
        Assert.assertTrue(eventsPage.getHeader("ICSTTP 2021").isDisplayed());
        Assert.assertEquals(eventsPage.getEventsList().size(), 1);
        Assert.assertEquals(eventsPage.eventStartDate.getText(), "January 4, 2022");
    }

}