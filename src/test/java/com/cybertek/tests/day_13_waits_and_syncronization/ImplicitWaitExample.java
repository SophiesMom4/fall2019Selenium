package com.cybertek.tests.day_13_waits_and_syncronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    //    driver.manage().timeouts().implicitlyWait(77, TimeUnit.DAYS); --> you can put it here too.
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS); // implicit wait.
                                // When we set implicit wait to certain time, driver will not
                                // imidietly throw exception when it can not find the element.
                            //implicit wait works only for finding element. it usually
                            // doesn't matter where you put it except needs to be before finding element.

        WebElement message = driver.findElement(By.cssSelector("#finish>h4"));

        Assert.assertTrue(message.isDisplayed());
        System.out.println(message.getText());

        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        WebElement button = driver.findElement(By.id("button"));
        button.click();

        message = driver.findElement(By.cssSelector("#finish>h4"));

        Assert.assertTrue(message.isDisplayed());
        System.out.println(message.getText());

    }
}