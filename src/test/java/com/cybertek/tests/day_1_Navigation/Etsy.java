package com.cybertek.tests.day_1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Etsy {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to Etsy --> data URL : https://www.etsy.com/
        driver.get("https://www.etsy.com/");

        driver.manage().window().maximize();

        //verify title --> expected vs actual
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        //try below to see the test FAIL -- misspelled
        //String expectedTitle = "Ety - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Thread.sleep(2000); // seconds before closing the browser

        String actualTitle = driver.getTitle();

        if (expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("The test has PASSED");
        }else{
            System.out.println(("The test has FAILED"));
            System.out.println("I expected " + expectedTitle);
            System.out.println("The actual title is " + actualTitle);
        }

        driver.close(); // closes the browser
       // driver.quit(); same as -> driver.close()

    }
}
