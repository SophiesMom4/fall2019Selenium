package com.cybertek.tests.Practice_WithMira;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class my_practice {
    public static void main(String[] args) throws InterruptedException {
        /*
        go to gap.com
        than go to gymboree.com
        locate the search box
        search for dress in the search box
        verify that search title contains dress.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.gap.com");
        driver.navigate().to("https://www.google.com/?gws_rd=ssl");
        WebElement searchBox = driver.findElement(By.name("q"));
        Thread.sleep(3000);

        searchBox.sendKeys("dress" + Keys.ENTER);

        String expectedPartialTitle = "dress";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedPartialTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.quit();

    }
}
