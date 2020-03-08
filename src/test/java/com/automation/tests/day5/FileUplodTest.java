package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUplodTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(3);

        WebElement upload = driver.findElement(By.id("file-upload"));
        String filePath =  System.getProperty("user.dir") + "/pom.xml";
        System.out.println(filePath);
        upload.sendKeys(filePath);

        BrowserUtils.wait(3);
        driver.quit();


    }
}
