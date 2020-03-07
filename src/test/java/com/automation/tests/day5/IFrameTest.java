package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("97").setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(2);







        driver.quit();


    }
}
