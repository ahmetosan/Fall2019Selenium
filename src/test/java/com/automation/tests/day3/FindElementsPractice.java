package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
    WebDriver driver = DriverFactory.createDriver("chrome");
    driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("mister ahmet");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sendenkimsein@gmail.com");

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        signUp.click();

        Thread.sleep(3000);
    driver.quit();

    }
}
