package com.cybertek.tests.day_1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {

    public static void main(String[] args) throws InterruptedException {

        //binary the driver and browsers
        WebDriverManager.chromedriver().setup();
        //WebDriver object --> Interface
        WebDriver driver = new ChromeDriver(); //    --> I have a driver now..

        //I want to open Google home page

        //how do you launch / open a web page?(interview Q) --> by using get() method --> url as String
        driver.get("https://www.google.com");

        /*
        Navigations

        driver.navigate().to("URL")  --> open a web page
        driver.navigate().back()
        driver.navigate().forward()
        driver.navigate().refresh()
        */
        driver.navigate().to("https//www.google.com");

        //get() vs Navigate().to()
        //   get()           --> waits to load the page
        //   navigate().to() --> does not wait

        // navigate().back() -->
        // 1. go to google 2. go to cybertek practice website <-- this is a test case

        driver.get("https//www.google.com");
        Thread.sleep(3000);
        driver.navigate().to("http://practice.cybertekschool.com/");
        Thread.sleep(3000);
        driver.navigate().back();

        //navigate().forward
        // go to cybertek practice website --> go to google --> back to practice wesite --> forward to google webpage

    }
}
