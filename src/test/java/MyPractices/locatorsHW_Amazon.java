package MyPractices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class locatorsHW_Amazon {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        String expectedURL = "https://www.amazon.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("expected URL is correct");
        }else {
            System.out.println("expected URL is NOT correct");
        }

         WebElement searchButton = driver.findElement(By.id("twotabsearchtextbox"));
         searchButton.sendKeys("phone" + Keys.ENTER);



    }
}
