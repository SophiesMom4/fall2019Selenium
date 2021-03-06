package com.cybertek.tests.day_10webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButonsTest {
    WebDriver driver; //driver null

    @BeforeMethod
    public void beforeMethod() {
//  WebDriver driver = WebDriverFactory.getDriver("chrome"); will give error
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    /*
        go to http://practice.cybertekschool.com/
        verify that blue is selected
        red is not selected
         */

    @Test
    public void test1(){
        WebElement blue = driver.findElement(By.id("blue"));
//     isSelected --> returns true if element is selected
        System.out.println(blue.isSelected());

        //verify taht radio button is selected
        Assert.assertTrue(blue.isSelected());

        WebElement red = driver.findElement(By.id("red"));
        //print red is not selected
        System.out.println(!red.isSelected());
        //verifies if the statement is false. if it false it passes. if true it fails
        Assert.assertFalse(red.isSelected() );
    }

    /*
    go to http://practice.cybertekschool.com/
    click on red
    verify that blue is not selected
    red is selected
     */

    @Test
    public void test2(){
        WebElement red = driver.findElement(By.id("red"));
        WebElement blue = driver.findElement(By.id("blue"));
        red.click();
        Assert.assertFalse(blue.isSelected()); //this line verifies ->blue is not selected
        Assert.assertTrue(red.isSelected()); // verifies red is selected
    }

}
