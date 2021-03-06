package com.cybertek.tests.day_14_test_base_properties_driver;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTests extends TestBase {
    /*
    go to practice website
    click on file upload link
    upload a file
    click submit
    verify file name is displayed in next page
     */

    @Test
    public void fileUploadTest(){
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);

        WebElement file_upload = driver.findElement(By.linkText("File Upload"));
        file_upload.click();

        WebElement fileInput = driver.findElement(By.id("file-upload"));

        fileInput.sendKeys("/Users/cigdemertekin/Desktop/my_file.txt");// we are sending the location of the file. we are not clicking

        WebElement submit = driver.findElement(By.id("file-submit"));
        submit.click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFile.getText(), "my_file.txt");
    }

}
