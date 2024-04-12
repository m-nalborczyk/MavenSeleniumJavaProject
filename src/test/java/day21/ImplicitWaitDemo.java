package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//  Implicit wait

//Advantages:
//1) single time/one statement for driver instance
//2) it will not wait till maximum time if the element is found faster
//3) applicable for all the elements
//4) easy to use

//Disadvantages:
//1) if the time is not sufficient then we will get exception


public class ImplicitWaitDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //implicit wait statement
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.findElement(By.name("username")).sendKeys("admin");



    }
}
