package com.automation.tests.vytrack.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.pages.LoginPages;
import com.automation.pages.activities.CalendarEventPage;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class NewCalendarEventPageTest extends AbstractPageBase {
    LoginPages loginPages = new LoginPages();
    CalendarEventPage calendarEventPage =new CalendarEventPage();



    @Test
    public void defaultOptionsTest(){
        loginPages.login();
        calendarEventPage.navigateTo("Activities","Calender Event");
        calendarEventPage.clickToCreateCalendarEvent();
        String actualStartDate = calendarEventPage.getStartDate();
        Assert.assertEquals(calendarEventPage.getOwnerName(),calendarEventPage.getCurrentUserName());
        String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM dd, yyyy");
        Assert.assertEquals(calendarEventPage.getStartDate(), DateTimeUtilities.getCurrentDate("MMM dd, yyyyy"));

        Assert.assertEquals(actualStartDate,expectedStartDate);
    }



//    @Test(dataProvider = "calendarEvents")
//    public void createCalendarEventTest(String title, String description) {
//        test = report.createTest("Create calendar event");
//        loginPage.login();
//        calendarEventPage.navigateTo("Activities", "Calendar Events");
//        calendarEventsPage.clickToCreateCalendarEvent();
//        calendarEventsPage.enterCalendarEventTitle(title);
//        calendarEventsPage.enterCalendarEventDescription(description);
//        calendarEventsPage.clickOnSaveAndClose();
//        //verify that calendar event info is correct
//        Assert.assertEquals(calendarEventsPage.getGeneralInfoDescriptionText(), description);
//        Assert.assertEquals(calendarEventsPage.getGeneralInfoTitleText(), title);
//        test.pass("Calendar event was created successfully!");
//    }
    @DataProvider
    public Object[][] calendarEvents() {
        return new Object[][]{
                {"Daily stand-up", "Scrum meeting to provide updates"}
        };
    }
@Test
    public void timeDifferenceTest(){
        loginPages.login();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.clickToCreateCalendarEvent();

        String startTime = calendarEventPage.getStartDate();
        String endTime = calendarEventPage.getEndTime();

//        String format = "h:mm a";//format 5:15 AM for example
//        long actual = DateTimeUtilities.getTimeDifference(startTime, endTime, format);
//        Assert.assertEquals(actual, 1, "Time difference is not correct");
}
}








