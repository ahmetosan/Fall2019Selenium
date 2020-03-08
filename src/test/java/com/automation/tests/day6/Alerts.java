package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click();
        BrowserUtils.wait(2);

        driver.switchTo().alert().accept();


        BrowserUtils.wait(2);
        driver.quit();





    }
}
