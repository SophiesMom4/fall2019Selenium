package com.cybertek.tests.day_9_testing_intro;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @BeforeClass // method that runs once before everything in this class. it will even run
                        // before @BeforeTest. but it will run only one time even if we have many test.
    public void beforeClass(){ // it will run once and will get out..
        System.out.println("\tBefore Class");
    }

    @AfterClass // runs after everything in this class. even after @AfterMethod. runs only once
    public void afterClass(){
        System.out.println("\tAfter Class");
    }


    @BeforeMethod  // it is a method that executes  "once before for every method" in that class
                    // that has annotations
    public void beforeMethod() {
        System.out.println("\tBefore Method");
    }

    @AfterMethod // it is a method that executes  "once after for every method" in that class that
    // has annotation @Test. it is used for reporting
    public void  afterMethod(){
        System.out.println("\tAfter Method");
    }

    @Test
    public void test1() {
      //  Assert.assertEquals(1, 2); even the test fails @BeforeMethod still runs
        System.out.println("this is test 1");
     //   Assert.assertEquals(true, false);
    }

    @Test
    public void test2() {
        System.out.println("this is test 2");
    }
}