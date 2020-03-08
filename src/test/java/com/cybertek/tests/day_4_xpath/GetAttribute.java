package com.cybertek.tests.day_4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {

        /*
        go to forgot password page
        locate retrieve password button
        print out 'submit' value
                        type='submit'
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement retrievePasswordButton =driver.findElement(By.id("form_submit"));


        System.out.println(retrievePasswordButton.getAttribute("type")); // will print 'submit'
        System.out.println(retrievePasswordButton.getAttribute("class")); // will print 'radius'
        System.out.println(retrievePasswordButton.getAttribute("id")); // for_submit



    }
}
