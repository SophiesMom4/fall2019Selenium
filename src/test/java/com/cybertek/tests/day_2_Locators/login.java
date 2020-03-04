package com.cybertek.tests.day_2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    /* test case1: login succesfuly
    1. go to VyTrack login page (positive: user should be able to login test case)
    2. write username data: storeManager52
    3. write password       UserUser123
    4. click login button
        test case2: login invalid credential
    1. go to login page
    2. write invalid user name
    3. write invalid password
    4. click login button
    5. verify that user see error message "invalid user name or password"

     */
    public static void main(String[] args) throws InterruptedException {



    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("https://app.vytrack.com/user/login");
    driver.manage().window().maximize();
    Thread.sleep(3000);

    driver.findElement(By.id("prependedInput")).sendKeys("storeManager52");
    driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

    WebElement loginButton = driver.findElement(By.id("_submit"));
    loginButton.click();

    //login can be found and clicked directly
        // driver.findElement(By.id(" - submit")).click();


    // Verify that you are in the homepage

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        //or
        String expectedURL = "https://app.vytrack.com/user/login";
        String actualURL = driver.getCurrentUrl();


        Thread.sleep(3000);

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println(("FAIL"));
            System.out.println("I expected " + expectedTitle);
            System.out.println("The actual title is " + actualTitle);
        }



    }

}
