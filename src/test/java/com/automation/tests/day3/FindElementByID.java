package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByID {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(3000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);


        String expected ="Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();
        if (expected.equals(actual)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        Thread.sleep(3000);

        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();

        Thread.sleep(3000);
        driver.quit();

    }
}
