package com.cybertek.tests.day_10webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ListOfElementsTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
    /*
    go to page radioButtons
    verify that none of the sports radio buttons are selected
     */

    @Test
    public void listOfRadioButtons() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //you can find them one by one or all at the same time. we will find them all at the same time.

        //  driver.findElement() -->> returns a LIST of element
        //  WebElement sports = driver.findElements(By.name("sport")); --> (.findElement and .findElements are different)
        //                                                             .findElements  will not work with WebElement because it only gib=ve you single sport here
        //so we'll use List<>
        Thread.sleep(3000);
        List<WebElement> sports = driver.findElements(By.name("sport"));
        System.out.println(sports.size());


        //  verify that none of the sports radio buttons are selected

        //   Assert.assertTrue(sports.isSelected()); // error becuase sports is a List

        for (WebElement radioButton : sports) {
            Assert.assertFalse(radioButton.isSelected());

        }
    }

    /*
    go to practice page
    get all the links present in the page
    print their text
     */

    @Test
    public void getAllLinksTest() {
        driver.get("http://practice.cybertekschool.com/");

        // get all the links in the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        //get the text of each link
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }
    /*
    go to amazon
    search for paper towels
    print the number of results
    print the second result
    print the last result

     */

    @Test
    public void amazonTest() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("paper towels" + Keys.ENTER);

        /* xpath for paper towel results
        span.a-size-base-plus
        span[class=‘a-size-base-plus a-color-base a-text-normal’]
         */

        List<WebElement> allResults = driver.findElements(By.cssSelector("span.a-size-base-plus"));

        Thread.sleep(2000);
        System.out.println("Number of results: " + allResults.size());

        System.out.println("First result : " + allResults.get(0).getText());
        System.out.println("Second result : " + allResults.get(1).getText());
        System.out.println("Last result : " + allResults.get(allResults.size() - 1).getText());

        /*
        go to http://practice.cybertekschool.com/radio_buttons
        verify the all sports checkboxes are NOT checked by default
        randomly click any sport
        verify that that sport is selected
        verify that all others are not selected
        repeat the last step for 5 times
         */

    }
    @Test

    public void radioTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        List<WebElement> list = driver.findElements(By.name("sport"));
        System.out.println(list.size());
        //checking all the sport checkboxes are not checked
        for (int i = 0; i < list.size(); i++) {
            Assert.assertFalse(list.get(i).isSelected());
        }

        Thread.sleep(2000);

        //randomly clicking and verifying
        Random ran = new Random();
        for (int q = 0; q < 5; q++) {
            Thread.sleep(2000);
            int num = ran.nextInt(4);
            list.get(num).click();
            System.out.println("Selecting button number: " + (num +1));
            for (int i = 0; i < list.size(); i++) {
                if (i == num) {
                    Assert.assertTrue(list.get(num).isSelected());
                } else {
                    Assert.assertFalse(list.get(i).isSelected());
                }
            }

        }
    }


}