package com.automation.tests.warmUp;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {
    static WebDriver driver;

    public static void main(String[] args) {

        ebayTest();
    //    amazonTest();
    //    wikiTest();
    }
    public static void ebayTest(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResult = driver.findElement(By.tagName("h1"));
        System.out.println(searchResult.getText());
        driver.quit();
    }
    public static void amazonTest(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com/");

        driver.quit();
    }
    public static void wikiTest(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.ebay.com/");

        driver.quit();
    }

}
