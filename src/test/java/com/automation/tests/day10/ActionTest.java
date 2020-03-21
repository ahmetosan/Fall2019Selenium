package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTest {
    private WebDriver driver;
    private Actions action;


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        action = new Actions(driver);

    }
    @Test
    public void hoverOnImage() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));



        action.moveToElement(img1)
                .pause(1000)
                .moveToElement(img2)
                .pause(1000)
                .moveToElement(img3)
                .pause(1000)
                .build().perform();

                action.moveToElement(img1).perform();
                WebElement imgtxt1 = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
                Assert.assertTrue(imgtxt1.isDisplayed());
    }
                @Test
                public void jqueryTest(){
                driver.get("http://practice.cybertekschool.com/jqueryui/menu");

                WebElement enabled = driver.findElement(By.id("ui-id-3"));
                WebElement download  = driver.findElement(By.id("ui-id-4"));
                WebElement pdf  = driver.findElement(By.id("ui-id-5"));

                action.moveToElement(enabled).pause(2000).
                        moveToElement(download).pause(2000).
                        click(pdf).build().perform();

    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        WebElement smallTop = driver.findElement(By.id("draggable"));
        WebElement bigTop = driver.findElement(By.id("droptarget"));


        action.dragAndDrop(smallTop,bigTop).perform();


        String expected ="You did great!";
        String actual = bigTop.getText();

        Assert.assertEquals(expected,actual);


    }

    @AfterMethod
    public void teardown() throws InterruptedException {
       BrowserUtils.wait(2);
        driver.quit();



    }
}




