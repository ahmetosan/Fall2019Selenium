package com.automation.tests.vytrack.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.pages.LoginPages;
import com.automation.pages.activities.CalendarEventPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DateTimeUtilities;
import com.automation.utilities.DriverFactory;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

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








