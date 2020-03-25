package com.cybertek.tests.PracticeANDOfficeHours;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_practice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //finding element by id using Css..  # means Id
        WebElement disappearButton = driver.findElement(By.cssSelector("#disappearing_button"));
        System.out.println(disappearButton.getText());

        //finding element by class using Css..  . means class in Css
        WebElement homeButton = driver.findElement(By.cssSelector(".nav-link"));
        System.out.println(homeButton.getText());

        //finding element by class using Css..
        WebElement resultButton = driver.findElement(By.cssSelector(".col-4.col-md-4"));
        System.out.println(resultButton.getText());

        //finding element by tag using Css..
        WebElement resultButton2 = driver.findElement(By.cssSelector("h4")); // if you do not put anything else like 'dot' it will take it as a tag..
        System.out.println(resultButton2.getText());

        //finding element by child using Css..  '>' means child in Css
        WebElement homeButton2 = driver.findElement(By.cssSelector("html>body>nav>ul>li>a"));
                                        // --> /html/body/nav/ul/li/a
    //    WebElement homeButton2 = driver.findElement(By.cssSelector("html>body>nav>ul a")); check class notes Css locators

        System.out.println(homeButton2.getText());

        //finding element by attributes and values using Css.
        WebElement button1 = driver.findElement(By.cssSelector("button[onclick='button1()']"));
        System.out.println(button1.getText());

        driver.quit();
    }
}
