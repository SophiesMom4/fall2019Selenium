package com.cybertek.tests.day_9_testing_intro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGassertationsTest {
    @Test
    public void test1() {
        String expected = "one";
        String actual = "one";


        Assert.assertEquals(actual, expected);    // compares two given values
        Assert.assertEquals(1,1);    // a method that does verification like comparing actual and expected
        Assert.assertEquals(true, true);

        System.out.println("test 1 complete");
    }

    @Test
    public void test2() {
        String expected = "one";
        String actual = "two";

        System.out.println("starting to compare");

        Assert.assertEquals(actual, expected);

        System.out.println("test 2 complete");

    }

    @Test  // assertNotEquals
    public void test3() {
        String expected = "one";
        String actual = "two";
        Assert.assertNotEquals(actual, expected);
        Assert.assertNotEquals(1, 2);

    }
    @Test
    public void test4() {
        String expected = "one";
        String actual = "one";

        Assert.assertTrue(expected.equals(actual));

        int e = 100;
        int a = 200;
        Assert.assertTrue(a>e); // assertTrue takes a condition/expression = one value but still comparing
    }

    @Test
    public void test5() {  // this is supposed to pass. check github
        //verify that url is equal to https://www.google.com/

        String expected = "https://www.google.com/";
        String actual = "https://www.google.com/";
        Assert.assertEquals(expected, actual);

        //verify that title starts with java
        String expected1 = "java";
        String actual1 = "java - Google Search";

        Assert.assertTrue(actual1.startsWith(expected1));


    }
    }