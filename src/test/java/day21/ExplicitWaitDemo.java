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




    }
}
