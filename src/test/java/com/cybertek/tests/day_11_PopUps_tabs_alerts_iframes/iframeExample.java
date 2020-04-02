package com.cybertek.tests.day_11_PopUps_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeExample {
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
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/tinymce");

        Thread.sleep(3000);

        // we will switch to iframe.
        // TODO switch by id/name
        driver.switchTo().frame("mce_0_ifr");

        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.click();
        textBox.sendKeys("great.thanks");

        //get out of the frame
        driver.switchTo().defaultContent(); //goes back to the frame that it was using first
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //TODO switch by weeElement //--> if there is no id or name
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);

        textBox = driver.findElement(By.id("tinymce"));
        textBox.click();
        textBox.sendKeys("great.thanks one more time");

        driver.switchTo().parentFrame(); //switches to the parent of the current frame
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        // TODO switch by index --> easy. you just need to give the index. no need to find ..
        driver.switchTo().frame(0);

        textBox = driver.findElement(By.id("tinymce"));
        textBox.click();
        textBox.sendKeys("great.thanks last time");


    }
}
