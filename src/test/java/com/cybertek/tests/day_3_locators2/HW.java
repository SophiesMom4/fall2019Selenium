package com.cybertek.tests.day_3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
        /*
        Task:
        Go to amazon  https://www.amazon.com/
        Go to Ebay   https://www.ebay.com/
        Enter a search term
        Click on search button
        Verify title contains search term
         */
    public static void main(String[] args) throws InterruptedException {
        //Locators : ID, name, classname,  ...
        /*
        **** if class attribute's value has a space or spaces, driver can not locate the element
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

    driver.get("https://www.amazon.com/");
    driver.manage().window().maximize();
    Thread.sleep(3000);

    driver.navigate().to("https://www.ebay.com/");

    WebElement searchBox = driver.findElement(By.name("_nkw"));
    Thread.sleep(4000);

    //Keyss.ENTER -> clicks the 'Enter' key..
    searchBox.sendKeys("shoes" + Keys.ENTER);

    // Verify title contains search term
    //expected vs actual
        String expectedPartialTitle = "shoes";
        String actual = driver.getTitle();
        Thread.sleep(4000);

        if (expectedPartialTitle.contains(expectedPartialTitle)){
            System.out.println("PASS");
        }else{
            System.out.println(("FAIL"));
        }
    }
}
