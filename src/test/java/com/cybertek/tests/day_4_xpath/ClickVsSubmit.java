package com.cybertek.tests.day_4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickVsSubmit {

    public static void main(String[] args) throws InterruptedException {
        /*
        click()  VS  submit()

        task:
        go to forgaot password page
        enter any email
        click on 'retrive password' button

        verify the URL --> http://practice.cybertekschool.com/email_sent
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //enter any email
        //locate email box first
        WebElement emailBox = driver.findElement(By.name("email"));
        //enter any email <-- sendKeys()
        emailBox.sendKeys("abc@gmail.com");

        //click 'retrive password' button
        // locate the button first
        WebElement submitButton = driver.findElement(By.id("form_submit"));

        //submit email by clicking the "retrive password" button
        submitButton.submit();

        // Verify --> expected result VS actual result

        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }





    }
}
