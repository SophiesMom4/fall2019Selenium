package com.cybertek.tests.day_1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_Save_Verify {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/"); //go to google website
        driver.manage().window().maximize(); //full screen

        String googleExpectedTitle ="Google";

        Thread.sleep(3000);

        driver.navigate().to("https://etsy.com/");

        String etsyExpectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Thread.sleep(3000);
        driver.navigate().back();  // google.com

        String actualGoogleTitle = driver.getTitle();

        if (googleExpectedTitle.equals(actualGoogleTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected URL: " + googleExpectedTitle);
            System.out.println("Actual URL: " + actualGoogleTitle);
        }

        driver.navigate().forward();  //etsy
        String etsyActualTitile = driver.getTitle();
        if(etsyExpectedTitle.equals(etsyActualTitile)){
            System.out.println("pass");
        }else {
            System.out.println("FAIL");
            System.out.println("I expected Title" + etsyExpectedTitle);
            System.out.println("The actual URL is: " + etsyActualTitile );
        }
        driver.close();

    }
}
