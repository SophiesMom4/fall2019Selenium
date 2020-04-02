package com.cybertek.tests.day_14_test_base_properties_driver;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Properties;

public class PropertiesExamples {
    @Test
    public void test() {

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));

        //url browser
        // Properties --> class from java that saves key value combinations
// go check configuration.properties class when you review this.
        Properties properties = new Properties();
        properties.setProperty("browser", "chrome");
        properties.setProperty("url", "http://practice.cybertekschool.com");

        String browser = properties.getProperty("browser");
        System.out.println("browser name= " + browser);

        // I need the browser/url from properties file

        String pBrowser = ConfigurationReader.getProperty("browser");
        System.out.println("pBrowser = " + pBrowser);

        String pUrl = ConfigurationReader.getProperty("url");

        System.out.println("pUrl = " + pUrl);

    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // get the from props file
        String url = ConfigurationReader.getProperty("url");
        driver.getCurrentUrl();
        driver.close();
        String str = Singleton.getInstance().toUpperCase();
        System.out.println(str);
    }
    @Test
    public void test3(){
        String str = Singleton.getInstance();
        System.out.println(str);
    }
}
