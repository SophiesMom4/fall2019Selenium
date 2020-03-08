package com.cybertek.tests.day_3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        // I want to get the value of type attribute
        // type="text" --> getAttribute("attribute name")

        // locate user name text box first
        WebElement username = driver.findElement(By.name("username"));

        //  <input type="text" name="username">
        String valueOfType = username.getAttribute("type");
        System.out.println("Value of the type is: "+valueOfType);

    //  LOGIN BUTTON attributes -->  <button class="btn btn-primary" type="submit" id="wooden_spoon">Login</button>

        // locate the login button
        WebElement loginButton = driver.findElement(By.id("wooden_spoon"));
        // I want to print class attributes value
        System.out.println(loginButton.getAttribute("class"));

        // getText gives you the black text inside the double coates.




    }
}
