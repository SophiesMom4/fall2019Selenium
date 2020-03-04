package com.cybertek.tests.day_1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURLofPracticeWeb {
    public static void main(String[] args) {
        /*
        1.go to Cybertek practice website
        2.verify the URL
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

        // for verifying title --> getTitle
        // for verifying URL   --> getCurrentURL

        String expectedURL = "http://practice.cybertekschool.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected URL: " + expectedURL);
            System.out.println("Actual URL: " + actualURL);
        }
        driver.close();

    }
}
