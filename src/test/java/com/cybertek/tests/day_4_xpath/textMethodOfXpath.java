package com.cybertek.tests.day_4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class textMethodOfXpath {
    public static void main(String[] args) {
        /*
        go to http://practice.cybertekschool.com/context_menu
        verify Context Menu is on the page
        // if there is no attribute like this example this is the formula :
                                          -->  tagName[text()='exact Text']
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //locate the element Context Menu
        WebElement text = driver.findElement(By.xpath("http://practice.cybertekschool.com/context_menu"));
        driver.findElement(By.xpath(""));
        WebElement contextMenu = driver.findElement(By.xpath("//h3[text()='Context Menu']"));


        //verify --> expected vs actual

        String expectedText = "Context Menu";
        String actualText = text.getText();
        if(expectedText.equals(actualText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
    }
}
