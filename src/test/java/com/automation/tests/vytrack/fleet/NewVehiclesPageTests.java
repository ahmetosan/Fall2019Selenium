package com.automation.tests.vytrack.fleet;

import com.automation.pages.LoginPages;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclesPageTests extends AbstractTestBase {

@Test
    public void verifyTitle() throws InterruptedException {
    LoginPages loginPages = new LoginPages();
    VehiclesPage vehiclesPage = new VehiclesPage();

    loginPages.login();
    vehiclesPage.navigateTo("Fleet", "Vehicles");

    String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
    String actualTitle = Driver.getDriver().getTitle();


    Assert.assertEquals(expectedTitle,actualTitle);
}



}
