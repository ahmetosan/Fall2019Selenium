package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTest {

    private WebDriver driver;

    @Test
    public void loginTest() throws InterruptedException {

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        BrowserUtils.wait(2);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(2);


//        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
//        for (WebElement searchItem : searchItems ){
            String actual = driver.findElement(By.className("subheader")).getText();
            String expected = "Welcome to the Secure Area. When you are done click logout below.";
                Assert.assertEquals(actual,expected);
            }



    @BeforeMethod
    public  void setup() throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(2);
    }


    @AfterMethod
    public void teardown(){
        driver.quit();

    }




}
