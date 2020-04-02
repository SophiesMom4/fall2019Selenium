package com.cybertek.base;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.getDriver();
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}
