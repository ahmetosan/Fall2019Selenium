package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckedBoxes {
    public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().version("79.0").setup();
            WebDriver driver = new ChromeDriver();
            driver.get("http://practice.cybertekschool.com/checkboxes");
            BrowserUtils.wait(2);


            List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

            checkBoxes.get(0).click();
            BrowserUtils.wait(3);
         if(checkBoxes.get(1).isDisplayed() && checkBoxes.get(1).isEnabled()&& (!checkBoxes.get(1).isSelected())){
             checkBoxes.get(1).click();
         }
            //   if (!checkBoxes.get(1).isSelected()){ checkBoxes.get(1).click(); }

            checkBoxes.get(1).click();
            BrowserUtils.wait(3);

            driver.quit();




        }
    }






