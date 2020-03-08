package com.cybertek.tests.Practice_WithMira;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class myPracticeVERIFY_LOGIN {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://idp.my.vccs.edu/authenticationendpoint/login.do?commonAuthCallerPath=%2Fpassivests&forceAuth=false&passiveAuth=false&tenantDomain=carbon.super&wa=wsignin1.0&wct=2020-03-07T03%3A56%3A29Z&wctx=rm%3D0%26id%3Dpassive%26ru%3D%252fcas%252flogin%253fservice%253dhttps%25253A%25252F%25252Fnvcc.my.vccs.edu%25252Fadmin%25252Fsecured%25252F51%25252Fapi%25252Fauth%25253Furl%25253Dhttps%25253A%25252F%25252Fnvcc.my.vccs.edu%25252Fhome%25252F51&wtrealm=https%3A%2F%2Fsignin.my.vccs.edu%2F&sessionDataKey=1edd45ab-bae8-4609-ba96-3f02d32540be&relyingParty=https%3A%2F%2Fsignin.my.vccs.edu%2F&type=passivests&sp=signin.my.vccs.edu&isSaaSApp=false&authenticators=BasicAuthenticator:LOCAL");

        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.id("username1")).sendKeys("hfe2557");
        driver.findElement(By.id("password")).sendKeys("Bluebear10#");
        Thread.sleep(3000);
        WebElement signInButton = driver.findElement(By.id("submitButton"));
        signInButton.click();



    }
}
