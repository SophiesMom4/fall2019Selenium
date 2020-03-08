package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    // write a static return method which returns WebDriver
    // method name is : getDriver
    // it takes a String as a parameter --> browser type like Chrome, Firefox
    // returns ChromeDriver and FirefoxDriver

    String chrome = "Chrome";
    String firefox = "Firefox";

    public static WebDriver getDriver(String browserType) {
        //local variables
        WebDriver driver = null;

        switch (browserType.toLowerCase()){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
        return driver;
    }


}
