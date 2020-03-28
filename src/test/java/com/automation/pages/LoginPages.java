package com.automation.pages;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {

    @FindBy(id = "prependedInput")
    public WebElement username;



    @FindBy(id = "prependedInput2")
    public WebElement password;

    public WebElement login;



    public LoginPages(){

        PageFactory.initElements(Driver.getDriver(), this);

    }
    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
    }


    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
    }

}
