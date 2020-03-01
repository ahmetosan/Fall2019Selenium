package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.rmi.Remote;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String title = driver.getTitle();
        String expectedTitle = "Google";
        System.out.println("title = " + title);


        if (expectedTitle.equals(title)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test not passed");
        }

        driver.navigate().to("https://www.amazon.com");

        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }
        driver.navigate().back();
        verifyEquals(driver.getTitle(),"Google");

        driver.close();

    }

    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
    }
}
