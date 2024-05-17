package day30;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InteractWithElementsWithJavaScriptDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //ChromeDriver driver = new ChromeDriver();                             >> if written like that then..

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //JavascriptExecutor js = driver;                                       >> ..this don't require casting for JavascriptExecutor

        //first name - input box
        WebElement firstName = driver.findElement(By.xpath("//input[@id='name']"));
        js.executeScript("arguments[0].setAttribute('value','James')",firstName);

        //radio button
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='male']"));
        js.executeScript("arguments[0].click()", radioButton);

        //checkbox
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='friday']"));
        js.executeScript("arguments[0].click()", checkbox);







    }
}
