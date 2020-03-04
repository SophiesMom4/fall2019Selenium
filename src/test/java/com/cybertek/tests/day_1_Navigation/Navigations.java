package com.cybertek.tests.day_1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {
    public static void main(String[] args) throws InterruptedException {
       /*
       Navigation:
       driver.navigate().to("URL")
       driver.navigate().back()
       driver.navigate().forward()
       driver.navigate().refresh()
       */

        // go to practice --> go to google --> back to Cybertek practice page --> forward to google

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); // example for polymorphism ..listen the recording March 1st

     //   ChromeDriver driver1 = new ChromeDriver(); // use above line or this one. only 1 driver...

        String practiceWebURL = "http://practice.cybertekschool.com/";

        // go to Cybertek practice
        driver.get(practiceWebURL);
        Thread.sleep(3000);

        // I want to see the full window
        driver.manage().window().fullscreen();

        // go to google
        String gglURL = "https://www.google.com";
        driver.navigate().to(gglURL);
        Thread.sleep(3000);

        //back to Cybertek practice
        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        driver.navigate().refresh();


        //close driver
        driver.close(); //closes only current web browser

        driver.quit(); //closes window in a browser

    }
}