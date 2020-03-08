package com.cybertek.tests.day_3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogin {
    /*
    go to login page
    enter username
    enter password
    click login button
    Verify the welcome message "WEelcome to the Secure Area. When you are done click logout below..
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        driver.findElement(By.id("wooden_spoon")).click();

        WebElement welcomeMessage = driver.findElement(By.tagName("h4"));

        /*
         verify the welcome message
         expected vs actual
         */

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";

        //String web element
        String actualWelcomeMessage = welcomeMessage.getText();
        if (expectedMessage.equalsIgnoreCase(actualWelcomeMessage)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");

        }
    }
}
