package com.cybertek.tests.day_11_PopUps_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsAndWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        //how can we direct/switch Selenium to the listed tabs? you may use this to find the right tab
        //  --> get all the avaible tabs --> selenium doesnt know the title of the page
        Set<String> windowHandles = driver.getWindowHandles(); // -->returns the windows handles of all avaible
        // tabs/windows. you can get the id's like this..
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText()); // get the text for current page

        for (String windowHandle : windowHandles) {
            System.out.println(windowHandle);
        }
        // get the id of current window/tab
        String currentWindow = driver.getWindowHandle();
        System.out.println("currentWindow = " + currentWindow);
        System.out.println("BEFORE SWITCHING");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        // this for down below, eveytime you want to switch tab/window you need to write it. just change the ".."
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("New Window")) {
                break;
            }
        }

        System.out.println("AFTER SWITCHING");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //write a utility that takes a String title,
        // changes to tab with given title,
        // if such title is not found, go back to original window

        //write a utility that takes a String erl,
        // changes to tab with given url,
        // if such title is not found, go back to original window


    }

}
