package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTest {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("before suit");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("after suit");
    }



    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }



    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }

    @BeforeMethod // runs before everytest
    public void setup(){
        System.out.println("Before Method");


    }


    @AfterMethod // runs before everytest
    public void teardown(){
        System.out.println("After Method");


    }

    @Test
    public void test01(){
        System.out.println("Test 01");
        String expected = "apple";
        String actual ="apple";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test02(){
        System.out.println("Test 02");
        int num01 = 1;
        int num02 = 10;
        Assert.assertTrue(num01<num02);
    }

}
