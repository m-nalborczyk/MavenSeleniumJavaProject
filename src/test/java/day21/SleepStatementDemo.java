package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Thread.sleep()
// provided by Java itself(not by Selenium libraries)

//Advantages:
//1) easy to use

//DisAdvantage:
//1) if the time is not sufficient then you will get exception
//2) it will wait for maximum tim. This will reduce the performance of the script.
//3) needed multiple usage at different steps

public class SleepStatementDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("admin");

    }
}
