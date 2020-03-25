package com.cybertek.tests.day_7_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTestWithText {
        /**
         * open browser
         * go to amazon
         * search for 'selenium cookbook'
         * verify that there is result with text 'Selenium Testing Tools Textbook - Second Edition
         */
        public static void main(String[] args) throws InterruptedException {
            // inspecting with Xpath -->  //tag[.='text']   ( . means text )
           // <span class="a-size-medium a-color-base a-text-normal" dir="auto">Selenium Testing Tools Cookbook - Second Edition</span>
    //           //span[.='Selenium Testing Tools Cookbook - Second Edition'] :
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.get("https://amazon.com");
            Thread.sleep(2000);

            //amazon search box input XPath  --> html/body/div/header/div/div/div/div/form/div/div/input
            WebElement searchInput = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/form/div[3]/div/input"));
            searchInput.sendKeys("selenium cookbook edition" + Keys.ENTER);

            Thread.sleep(2000);
            WebElement result = driver.findElement(By.xpath("//span[.='Selenium Testing Tools Cookbook - Second Edition']"));
            System.out.println(result.getText());

            driver.close();

        }
}
