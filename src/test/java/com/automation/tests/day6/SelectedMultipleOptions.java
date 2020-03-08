package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectedMultipleOptions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languagesSelected = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languagesSelected.isMultiple();
        System.out.println("isMultiple = " + isMultiple);



        languagesSelected.selectByVisibleText("Java");
        languagesSelected.selectByVisibleText("JavaScript");
        languagesSelected.selectByVisibleText("Python");


        List<WebElement> selectedLanguage = languagesSelected.getAllSelectedOptions();
        for (WebElement eachSelectedLanguage:  selectedLanguage) {
            System.out.println(eachSelectedLanguage.getText());
        }

        BrowserUtils.wait(2);


        languagesSelected.selectByVisibleText("Java");
        languagesSelected.deselectAll();


        BrowserUtils.wait(3);
        driver.quit();
    }
}

