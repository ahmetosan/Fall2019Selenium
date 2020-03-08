package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);


        Select statesSalected = new Select(driver.findElement(By.id("state")));
        statesSalected.selectByValue("DC");

        String expected = "District Of Columbia";
        String actual = statesSalected.getFirstSelectedOption().getText();

        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }









        BrowserUtils.wait(3);
        driver.quit();
    }
}
