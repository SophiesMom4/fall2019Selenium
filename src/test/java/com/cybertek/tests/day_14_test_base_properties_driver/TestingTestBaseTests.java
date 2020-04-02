package com.cybertek.tests.day_14_test_base_properties_driver;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingTestBaseTests extends TestBase {

    @Test
    public void testTitle(){
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);


        Assert.assertEquals(driver.getTitle(), "Practice");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
}
