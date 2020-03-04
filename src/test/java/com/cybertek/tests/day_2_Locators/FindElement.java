package com.cybertek.tests.day_2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.CropImageFilter;

public class FindElement {
    public static void main(String[] args) throws InterruptedException {

        // Locator 1. ID
        /*
   TASK : go to cybertek okta login page
          write email to the text box
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://cybertekschool.okta.com/");

        //write email to the text box
        /*
        1. find the text box first --> findElement() from the WebDriver
         */
        Thread.sleep(3000);
        WebElement emailBox = driver.findElement(By.id("okta-signin-username"));

        emailBox.sendKeys("cigdemertekin@gmail.com");

        //write password text box

       // WebElement passwordBox = driver.findElement(By.id("okta-signin-password"));
        //passwordBox.sendKeys("Delimavi1");

       driver.findElement(By.id("okta-signin-password")).sendKeys("dddddd"); // same as lines 35,36 shorter



    }
}
