package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropdown = new Select(simpleDropdown);
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        selectSimpleDropdown.selectByVisibleText("Option 1");
        BrowserUtils.wait(2);

        Select  selectYear = new Select(driver.findElement(By.id("year")));
        Select  selectMonth = new Select(driver.findElement(By.id("month")));
        Select  selectDay = new Select(driver.findElement(By.id("day")));

        BrowserUtils.wait(2);



        selectYear.selectByVisibleText("1981");
        selectMonth.selectByVisibleText("February");
        selectDay.selectByVisibleText("3");


        BrowserUtils.wait(4);


        List<WebElement> months = selectMonth.getOptions();
        for (WebElement month: months) {
            selectMonth.selectByVisibleText(month.getText());
            BrowserUtils.wait(1);
        }



        driver.quit();
    }
}
