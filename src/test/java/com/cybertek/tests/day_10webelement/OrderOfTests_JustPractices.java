package com.cybertek.tests.day_10webelement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderOfTests_JustPractices {
    // we'll print some stuff java . this is not Selenium project

    String title;

    @Test(priority = 0) // this will run first - this is about order not about which one is important.
                                // smallest will run first
    public void  login(){
        System.out.println("opening the browser");
        System.out.println("capturing title");
        title = "cbt";

        //I will make this test fail. Assert.fail() --> is a ready method that makes test fail
        Assert.fail();
    }
    @Test(priority = 1, dependsOnMethods = "login") //dependsOnMethods = "login" means --> if you can not login it will fail
    public void  assertTitle(){
        System.out.println("verifying the title");
        Assert.assertEquals(title, "cbt");
    }
    @Test(priority = 2)
    public void  verifyOtherThings(){
        System.out.println("verifying something else");

    }
}
