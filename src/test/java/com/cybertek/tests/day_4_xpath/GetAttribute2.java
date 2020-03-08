package com.cybertek.tests.day_4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute2 {
    public static void main(String[] args) throws InterruptedException {

        /*
        go to http://practice.cybertekschool.com/dynamic_loading
        locate Example 1: Element on page that is hidden and become visible after trigger

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("");
        driver.manage().window().maximize();
        Thread.sleep(3000);
       // go to URL
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        WebElement retrievePasswordButton =driver.findElement(By.id("http://practice.cybertekschool.com/dynamic_loading"));

        //locate Example 1:
        WebElement example1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        System.out.println(retrievePasswordButton.getAttribute("href"));







    }
}
