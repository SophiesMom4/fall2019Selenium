package com.cybertek.tests.day_8_review_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackTests {

    public static void main(String[] args) throws InterruptedException {
        //titleTest();
        shortcutTest();
    }
    private static void shortcutTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");// what kind of environment, ask about it.
        //SalesManager110
        //UserUser123 cred entials for VY truck, should be provided
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("SalesManager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();
        Thread.sleep(3000);
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (actualTitle.startsWith(expectedTitle)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }
        WebElement shortCut = driver.findElement(By.cssSelector("a[title='Shortcuts']"));
        shortCut.click();
        Thread.sleep(3000);
        WebElement allLinks = driver.findElement(By.linkText("See full list"));
        allLinks.click();
        Thread.sleep(3000);
        WebElement opportunities = driver.findElement(By.linkText("Opportunities"));
        opportunities.click();
        Thread.sleep(3000);
        verifyStartWith("Open Opportunities", driver.getTitle());
        shortCut.click();
        Thread.sleep(3000);
        allLinks.click();
        Thread.sleep(3000);
        WebElement vehicleServiceLog = driver.findElement(By.linkText("Vehicle Services Logs"));
        vehicleServiceLog.click();
        WebElement errorMessage = driver.findElement(By.cssSelector(".message"));//or by.classname("message");
        verifyStartWith("You do not have permission to perform this action.", driver.getTitle());
    }
    private static void titleTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa3.vytrack.com/user/login");// what kind of environment, ask about it.
        //SalesManager110
        //UserUser123 cred entials for VY truck, should be provided
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("SalesManager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();
        WebElement profileName = driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));
        Thread.sleep(3000);
        profileName.click();
        Thread.sleep(3000);
        WebElement myConfiguration = driver.findElement(By.cssSelector("ul.dropdown-menu>li>a[href='/config/user/profile']"));
        //text is better once u see in "a" text
        myConfiguration.click();
        Thread.sleep(3000);
        String expected = profileName.getText();
        String actual = driver.getTitle();
        verifyStartWith(expected, actual);
        driver.quit();
    }
    private static void verifyStartWith(String expectedTitle, String actualTitle) {
        if (actualTitle.startsWith(expectedTitle)) {
            System.out.println("Pass");
        } else {
            System.out.println("fail");
            System.out.println("actual = " + actualTitle);
            System.out.println("expected = " + expectedTitle);
        }
    }
}
