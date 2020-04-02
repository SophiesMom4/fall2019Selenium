package com.cybertek.tests.day_10webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTest { //check boxes allows you to click/select multiple times
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void test(){
        WebElement checkBox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));

        // by deafault one is not checked, two is checked.. this is important. you need to have that data if there is any..
        System.out.println("is checkBox1 selected : "+ checkBox1.isSelected());
        System.out.println("is checkBox2 selected : "+ checkBox2.isSelected());

        Assert.assertFalse(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());

        //check the first checkbox
        //verify checkBox1 is selected
        //verify checkBox2 is selected
        System.out.println("---after check the first checkbox---");
        checkBox1.click();
        System.out.println("is checkBox1 selected : "+ checkBox1.isSelected());
        System.out.println("is checkBox2 selected : "+ checkBox2.isSelected());

        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());


    }

}

