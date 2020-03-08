package com.cybertek.tests.day_3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {
    public static void main(String[] args) {
        //Locator --> LinkText
   WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        driver.manage().window().maximize();

        WebElement example3 = driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));

        String textVersionOfExample3 = example3.getText();

        System.out.println(textVersionOfExample3);

        //linkText vs Partial LinkTest
        // I want to locate Example3 with only a part of it
        WebElement example3_2 = driver.findElement(By.partialLinkText("Example 3:"));
        String text = example3_2.getText();
        System.out.println(text);

        /*Task:
        1. go to http://practice.cybertekschool.com/dynamic_loading
        2. Locate Cybertek_School element by using linkText and/or PartialLinkText
        */
        WebElement cybertekSchool = driver.findElement(By.linkText("Cybertek School")); // I write the text itself-> Cybertek School

        // I can not print the above variable 'cybertekschool' because it is a webElement.
        // to print I need getText()
        String textVersion = cybertekSchool.getText(); // get me the text version of 'cybertekSchool'
        System.out.println(textVersion);

        //HW :  locate the element : HOME

        WebElement home = driver.findElement(By.linkText("Home"));
        String HometextVersion = home.getText();
        System.out.println(HometextVersion);



    }

}
