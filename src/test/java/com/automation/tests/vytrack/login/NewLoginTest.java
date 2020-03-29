package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPages;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTest extends AbstractTestBase {
    @Test
    public void verifyPageTitle() throws InterruptedException {
        LoginPages loginPage = new LoginPages();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
    }

    /**
     * Enter wrong credentials and verify warning message
     *
     */

    @Test
    public void verifyWarningMessage() throws InterruptedException {
        LoginPages loginPages = new LoginPages();
        loginPages.login("wrong", "wrong");
        Assert.assertEquals(loginPages.getWarningMessageText(), "Invalid user name or password.");
    }
}