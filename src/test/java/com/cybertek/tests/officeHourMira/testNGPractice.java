package com.cybertek.tests.officeHourMira;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class testNGPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        Thread.sleep(2000);
        // we are landed to red webdocument - dafault content -see Mira's schema
        driver.switchTo().frame("frame-top");
        //we are landed to blue web doc.

      List<WebElement> frameList = driver.findElements(By.xpath("//frame"));

      /*
      we have stored all frames webelements inside the List
      1. Loop through list
      2. switch to each frame
            a. get text from body
            b. switch to parent
       */

        for (int i = 0; i<frameList.size(); i++){
            driver.switchTo().frame(i);
            String bodyText = driver.findElement(By.xpath("//body")).getText();
            System.out.println("Body text: " + bodyText);
            driver.switchTo().parentFrame();

        }
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");

        String bodyText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Body text: " + bodyText);

        driver.switchTo().defaultContent(); // its better to add this at the end because someone else can use it.

    }
}
