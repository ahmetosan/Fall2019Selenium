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
        Thread.sleep(3000);
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("mister ahmet");
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sendenkimsein@gmail.com");
        Thread.sleep(3000);
        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        signUp.click();
        Thread.sleep(3000);
    String expected = "Thank you for signing up. Click the button below to return to the home page.";

    WebElement message = driver.findElement(By.className("subheader"));
    String actual = message.getText();

    if (expected.equals(actual)){
        System.out.println("pass");
    }else {
        System.out.println("fail");
    }

        driver.quit();

    }
}
