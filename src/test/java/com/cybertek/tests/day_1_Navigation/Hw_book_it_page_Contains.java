package com.cybertek.tests.day_1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hw_book_it_page_Contains {
    public static void main(String[] args) throws InterruptedException {

         /*
           1- go to book it website
           2- verify that URL contains “cybertek-reservation”
           */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        String expectedURL = "https://cybertek-reservation-qa.herokuapp.com/sign-in";
        String actualURL = driver.getCurrentUrl();

        driver.manage().window().maximize();
        if (expectedURL.contains("cybertek-reservation")) {
            System.out.println("Passed - web site contains cybertek-reservation words");
        } else {
            System.out.println("Failed");
            System.out.println("URL does not contain the word cybertek-reservation");

            driver.navigate().back();

            Thread.sleep(3000);

            driver.navigate().forward();

            driver.navigate().refresh();
        }

            driver.quit();

    }
}
