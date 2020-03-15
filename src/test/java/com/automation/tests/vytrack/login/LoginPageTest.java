package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginPageTest {
    private WebDriver driver;
    private String Url = "https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMassageBy = By.cssSelector("[class = 'alert alert-error']>div");


    @Test(description = "test description")
    public void invalidUsername() throws InterruptedException {
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMassageBy);
        assertTrue(warningElement.isDisplayed());


        String expected = "Invalid user name or password";
        String actual = warningElement.getText();
        assertEquals(actual,expected);

    }

    @Test(description = "test manager")
    public void loginAsStoreManager() throws InterruptedException {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        String expected = "Dashboard";
        String actual = driver.getTitle();
        assertEquals(actual,expected);

    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(Url);
        driver.manage().window().maximize();
    }

    public void teardown(){
        if (driver != null ){
            driver.quit();
            driver =null;
        }
    }


}
