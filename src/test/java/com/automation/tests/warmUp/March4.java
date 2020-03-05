package com.automation.tests.warmUp;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        ebayTest();
        amazonTest();
        wikiTest();
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
    public static void amazonTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book");
        String title = driver.getTitle();
        if (title.contains("java book")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        Thread.sleep(2000);
        driver.quit();
    }
    public static void wikiTest() throws Exception{
        driver = DriverFactory.createDriver("chrome");
        //Go to wikipedia.org
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        //enter search term `selenium webdriver` & click on search button
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.RETURN);
        Thread.sleep(3000);
        //click on search result `Selenium (software)`
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2000);
        String link = driver.getCurrentUrl(); // to get link as a String
        //verify url ends with `Selenium_(software)`
        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }
}


