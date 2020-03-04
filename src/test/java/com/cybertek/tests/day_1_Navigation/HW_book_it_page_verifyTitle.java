package com.cybertek.tests.day_1_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_book_it_page_verifyTitle {
    public static void main(String[] args) throws InterruptedException {
        /*
        1- go to book it website
        2- verify the title
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");
        driver.manage().window().maximize();

        //expected vs actual
        String expectedTitle = "bookit";
        String actualTitle = driver.getTitle();


        Thread.sleep(3000);

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println(("FAIL"));
            System.out.println("I expected " + expectedTitle);
            System.out.println("The actual title is " + actualTitle);
        }
            /*
           1- go to book it website
           2- verify that URL contains “cybertek-reservation”
           */
            String expectedURL = "https://cybertek-reservation-qa.herokuapp.com/sign-in";
            String actualURL = driver.getCurrentUrl();

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

        driver.quit(); //closes window in a browser

    }
}