package com.cybertek.tests.officeHourMira;

import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitPractice extends TestBase {
    /*
    http://qa3.vytrack.com
    salesmanager110
    UserUser123
     */
    /*
    implicit wait - set it one time and it will work for every findElement method
                    - NoSuchElementException
    Thread.sleep - not Selenium wait! Thread - Java class, sleep() method of Thread class
                stops the execution of java program
                - we never want to use this method in our tests
    Explicit wait - we have to declare every time before the iteraction with element
                Expected Condition we are looking for
    Singleton - it helps us to make sure we have only 1 instance of driver object at a time
     */

    @Test
    public void testWait(){
        driver.get("http://qa3.vytrack.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement user = driver.findElement(By.id("prependedInput"));

        WebElement password = driver.findElement(By.id("prependedInput2"));
        WebElement submit = driver.findElement(By.id("_submit"));
        user.sendKeys("salesmanager110");
        password.sendKeys("UserUser123");
        submit.click();

        WebElement account = driver.findElement(By.xpath("//span[.=‘Accounts’]/following-sibling::span/following-sibling::a"));
        account.click();

    }
}
