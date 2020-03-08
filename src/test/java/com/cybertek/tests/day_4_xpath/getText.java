package com.cybertek.tests.day_4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getText {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        /*
        Task:
        go to the 'forgot password' page
        enter any email
        click 'retrieve password' button
        verify that confirmation text is "Your email's been sent!"
         */

        WebElement emailbox = driver.findElement(By.name("email"));
        //enter email --< sendKeys()
        emailbox.sendKeys("abc@gamil.com");

        // click "retrieve password" bttb
        //locate the bttn first
        WebElement submitButton = driver.findElement(By.id("form_submit"));
        //submit email by clicking the "retrive password"
        submitButton.submit();

        // verify that the confirmation text "Your e-mail's been sent!"
        String expectedText = "Your e-mail's been sent!";

        WebElement message = driver.findElement(By.name("confirmation_message"));

        //getText() -->
        String ActualText = message.getText(); //

        if (expectedText.equals(ActualText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
    }
}
