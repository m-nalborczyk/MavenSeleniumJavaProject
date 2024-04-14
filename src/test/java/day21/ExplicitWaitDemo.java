package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Explicit wait

//1) conditionally based
//2) finding element is inclusive
//3) it will wait for condition to be true for a set time
//4) we need to write multiple statements for multiple elements

public class ExplicitWaitDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //declaring explicit wait
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com");

        //using explicit wait for a specific element. If the condition is met (true) then it will return that element it is waiting for. If not it will wait max time set and throw NoSuchElementException
        WebElement element = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        element.sendKeys("admin");


        //Below the steps to situation where the element is outside the viewport and in order to interact with it user would have to scroll down the page

        //        WebDriver driver = new ChromeDriver();
        //        driver.get("https://example.com");
        //
        // Create a WebDriverWait instance with a timeout
        //        WebDriverWait wait = new WebDriverWait(driver, 10);
        //
        // Wait for the element to be present in the DOM
        //        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("elementId")));
        //
        // Scroll the element into view (if needed)
        //        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        //
        // Wait for the element to be visible within the viewport
        //        element = wait.until(ExpectedConditions.visibilityOf(element));
        //
        // Now, you can interact with the element
        //        element.click();




    }
}
