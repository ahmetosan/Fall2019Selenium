package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutes2 {

    private WebDriver driver;



    @BeforeMethod
    public  void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyTitle(){
        String expected = "Practice";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actual = (String) js.executeScript("return document.title");

        Assert.assertEquals(actual,expected);
    }
    @Test
    public void clickTest(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        link.click();



        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",link);


    }


    @AfterMethod
    public void teardown() throws InterruptedException {
        BrowserUtils.wait(2);
        driver.quit();
    }


}
