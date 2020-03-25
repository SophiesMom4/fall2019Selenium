package com.cybertek.tests.day_9_testing_intro;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstNGTest {
    @Test
    public void test1(){
        System.out.println("Test One");
    }

//  @Ignore // ignores a method
    @Test // it means we have a method to run the test
    public void test2(){
        System.out.println("Test Two");
    }
    @Test
    public void test3(){
        System.out.println("Test Three");
    }

}
