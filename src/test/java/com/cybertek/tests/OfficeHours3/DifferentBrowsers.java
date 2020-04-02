package com.cybertek.tests.OfficeHours3;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.util.Properties;

public class DifferentBrowsers {


    @Test
    public void test() {
        //which browsers am i using right now

        System.out.println("OPTION 1");
        System.out.println(ConfigurationReader.getProperty("browser"));
        System.out.println("OPTION 2");
    }
}