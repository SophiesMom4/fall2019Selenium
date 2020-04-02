package com.cybertek.tests.day_11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassDemo {

    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        actions = new Actions(driver);
        //  Actions actions = new Actions(driver); //this is a local object so we will declare it in the class
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(2000);
        WebElement target = driver.findElement(By.tagName("img"));

        //moveToElement() --> moves the mouse on top of given we element
        actions.moveToElement(target).perform(); // by saying perform() --> that means "do it now"
        Thread.sleep(3000);
    }

    @Test
    public void hoverOver2() {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));
        // move the mouse to enabled
        // wait
        // move the mouse to downloads
        // wait
        // click on  PDF

        // actions are not working %100 at all the time..
        actions.
                moveToElement(enabled).
                pause(4000).// almost same as Thread.sleep()
                moveToElement(downloads).
                pause(4000).
                click(pdf).
                build().perform(); // when we have multipe action we use build()
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().fullscreen();

        WebElement money = driver.findElement(By.id("draggable"));
        WebElement bank = driver.findElement(By.id("droptarget"));
        Thread.sleep(3000);

        //scroll
        actions.sendKeys(Keys.PAGE_DOWN).perform();
      //  actions.sendKeys(Keys.ARROW_DOWN).perform();

        actions.dragAndDrop(money, bank).perform();
        Thread.sleep(3000);
    }

    /*
    TASK
    do the drag and drop by chaining actions
    move mouse to source/money
    mouse down
    move mouse to target/bank
    mouse up
     */

    @Test
    public void dragAndDropAgain() throws InterruptedException {
            driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

            WebElement money = driver.findElement(By.id("draggable"));
            WebElement bank = driver.findElement(By.id("droptarget"));
            Thread.sleep(2000);
            actions.moveToElement(money).clickAndHold().moveToElement(bank).release().build().perform();
            Thread.sleep(2000);
    }

}