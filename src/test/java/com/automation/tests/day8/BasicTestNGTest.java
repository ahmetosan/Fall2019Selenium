package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTestNGTest {



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
        Assert.assertTrue(num01>num02);
    }

}
