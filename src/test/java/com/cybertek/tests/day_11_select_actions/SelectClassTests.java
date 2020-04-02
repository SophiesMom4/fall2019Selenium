package com.cybertek.tests.day_11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectClassTests {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
    @Test
    public void getSelectedOption(){
        //find element that has select tag
        WebElement dropdown =driver.findElement(By.id("dropdown"));
        //WebElement dropdown =driver.findElement(By.tagName("a"));
        //create a select class using the web element
        Select dropdownList = new Select(dropdown);

        // get the selected option
        WebElement selectedOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectedOption.getText());
        // verify selected option
        Assert.assertEquals(selectedOption.getText(), "Please select an option");
    }
    @Test
    public void selectFromList() throws InterruptedException {
        //get the element with select tag
        WebElement dropdown =driver.findElement(By.id("state"));
        //create select class
        Select states = new Select(dropdown);

        //TODO selectByVisibleText() --> selects by the text of the option
        states.selectByVisibleText("Iowa");
        Thread.sleep(1000);
        states.selectByVisibleText("Vermont");
        Thread.sleep(1000);
        states.selectByVisibleText("Kentucky");
        Thread.sleep(1000);

        // TODO selectByIndex --> selects based on the index of the option, on based account
        // this is the easiest way Marufjon said
        states.selectByIndex(0);
        Thread.sleep(2000);
        states.selectByIndex(10);
        Thread.sleep(2000);
        states.selectByIndex(20);
        Thread.sleep(2000);

        //TODO selectByValue --> selects based on the value of the attribute of the option
        //TODO selectByValue --> it is not select text
        //we use it if there is 'value' in the node
        states.selectByValue("VA"); // node --> <option value="VA">Virginia</option>
        Thread.sleep(2000);
        states.selectByValue("SC");
        Thread.sleep(2000);
        states.selectByValue("IL");
        Thread.sleep(2000);

    }
    @Test
    public void getAllAvaibleOptions(){
        Select monthList = new Select(driver.findElement(By.id("month")));
        // print the current selection
        System.out.println(monthList.getFirstSelectedOption().getText());

        //TODO
        List<WebElement> allOptions = monthList.getOptions();
        System.out.println("Number of months: "+ allOptions.size());
// iter and hit enter.. gives you for each..
        for (WebElement month : allOptions) {
            System.out.println(month.getText());
        }

        // verify that months list always shows the current month
        //get current month using Java -->  System.out.println(LocalDateTime.now().getMonth().name());

        String expected = LocalDateTime.now().getMonth().name();
        String actual = monthList.getFirstSelectedOption().getText();
        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());

        // verify that months has following values: January...December
        List<String> expectedMonths = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        // get options gives me list WebElements, so allOptions is a list of web elements
        // but my expected is a list strings. I have to make sure the both list of strings
        // I need to get list string from list of we element

        List<String> actualMonths = new ArrayList<>();
        for (WebElement option : allOptions) {
            actualMonths.add(option.getText());

        }
        Assert.assertEquals(actualMonths, expectedMonths);

    }

    @Test
    public void VerifyOptions(){
        Select list = new Select(driver.findElement(By.id("dropdown")));
        // verify that list has 3 options

        int expectedSize = 3;
        int actualSize = list.getOptions().size();

        List<String> expectedValues = Arrays.asList("Please select an option", "Option 1", "Option 2");
        List<String> actualValues = new ArrayList<>();
        for (WebElement option : list.getOptions()) {
            actualValues.add(option.getText());
        }

        Assert.assertEquals(actualValues, expectedValues);


    }
}
