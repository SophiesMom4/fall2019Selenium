package com.cybertek.tests.OfficeHours3;

import com.cybertek.base.TestBase;
import com.cybertek.tests.OfficeHours2.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EtsyTests extends TestBase {
    /*
     search for wooden spoon on etsy
    verify title contains the searchterm
    verify that default shipt to location is United States
    verify Ship to countries include Australia
     */

    @Test
    public void verifyCountryList() throws InterruptedException {

        driver.get("https://etsy.com");
        WebElement input = driver.findElement(By.id("global-enhancements-search-query"));

        //for chrome users, wait until page loads


        input.sendKeys("wooden spoon" + Keys.ENTER);

        // VERIFY TITLE
        String expectedTitle = "Wooden spoon | Etsy";
        //wait a little until title changes to right one // below line worked for me but it did not for Marufjon so he tried explicit wait
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); was not good enough
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //using explicit wait to wait until title contains Wooden spoon | Etsy
        wait.until(ExpectedConditions.titleIs(expectedTitle));

        Assert.assertEquals(driver.getTitle(), expectedTitle);

        //verify 'ship to' location

        //we needed to add implicit wait
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Select shipToList = new Select(driver.findElement(By.name("ship_to")));

        String expectedDefaultCountry = "United States";
        //get the selected element and its text
        String actualDefaultCountry = shipToList.getFirstSelectedOption().getText().trim();
        Assert.assertEquals(actualDefaultCountry,expectedDefaultCountry);

        //    verify 'ship to' countries include Australia

        // get all the options that is a list of strings
        List<String> options = BrowserUtils.getElementsText(shipToList.getOptions());
        Assert.assertTrue(options.contains("Australia")); //   #shop-location-input

        //verify free shipping is not clicked
        WebElement freeShipping = driver.findElement(By.name("free_shipping"));
        Assert.assertTrue(freeShipping.isSelected());

        //verify URL changes when free shipping is clicked
        WebElement freeShippingLabel = driver.findElement(By.xpath("//label[.='FREE shipping']"));
        freeShippingLabel.click();

        String expectedUrl = "free_shipping=true";
        Assert.assertTrue(driver.getCurrentUrl().endsWith(expectedUrl));

    }

}
