package com.cybertek.tests.day_5_more_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathDemo {
    public static void main(String[] args) {

        //get Chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //open browser
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // represents an element from page
        //   where the elements come from? --> from the fineElements methods
        // how findElement finds elements? --> using locators

        WebElement buttonOne = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        //start interacting with the element :
        String txt = buttonOne.getText();  // i want the text of buttonOne element
        System.out.println(txt);

        //lets find the second element :
        WebElement buttonTwo = driver.findElement(By.xpath("//h3/following-sibling::button[2]"));
        System.out.println(buttonTwo.getText());

        WebElement buttonThree = driver.findElement(By.xpath(""));
        System.out.println(driver.findElement(By.xpath("//button[3]")).getText()); // <--  you can do it w/o finding the element like this.. other way is better in the long term..
                                                                                   // sometimes you want to use the object and it comes handy to create an object
        WebElement buttonFour = driver.findElement(By.xpath("//div/button[4]"));
        System.out.println(buttonFour.getText());


        WebElement buttonFive = driver.findElement(By.xpath("//button[.='Button 5']"));

        WebElement buttonSix = driver.findElement(By.xpath("button[@id='disappearing_button']"));
        //elemet.getAttribute("value")  --. method to get text form element, used with
        //get text of the element
        System.out.println(buttonSix.getAttribute("innerHTML"));

        //if none of the works use outerHTML
        System.out.println(buttonSix.getAttribute("outerHTML"));



    }
}
