package com.cybertek.tests.day_4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class PracticeFactory {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://google.com");




    }
}
