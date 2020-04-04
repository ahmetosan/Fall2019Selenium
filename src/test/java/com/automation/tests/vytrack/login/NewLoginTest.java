package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPages;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLoginTest extends AbstractTestBase {
    @Test
    public void verifyPageTitle() throws InterruptedException {
        test = report.createTest("verify page title");
        LoginPages loginPage = new LoginPages();
        loginPage.login();
        test.info("login as store manager");
        BrowserUtils.wait(2);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("page title was verified");
    }
    @Test(dataProvider = "credentials")
    public void loginWithDDT(String userName, String password) throws InterruptedException {
        test = report.createTest("Verify page title");
        LoginPages loginPage = new LoginPages();
        loginPage.login(userName, password);
        test.info("Login as " + userName);//log some steps
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboards");
        test.pass("Page title Dashboard was verified");
    }
    //Object[][] or Object[] or Iterator<Object[]>
//Object[] - 1 column with a data
//Object[][] 2+
    @DataProvider
    public Object[][] credentials() {
        return new Object[][]{
                {"storemanager85", "UserUser123"},
                {"salesmanager110", "UserUser123"},
                {"user16", "UserUser123"},
        };
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
        BrowserUtils.getScreenshoot("loginPage");
    }
}