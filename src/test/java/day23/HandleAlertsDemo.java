package day23;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleAlertsDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        //Alert alertWindow = driver.switchTo().alert();
        Alert alertWindow = wait.until(ExpectedConditions.alertIsPresent()); //returns "driver.switchTo().alert();"

        //get text from alert window
        System.out.println(alertWindow.getText());

        //confirm/click ok or cancel on alert window
        //alertWindow.accept();
        alertWindow.dismiss();

        //we can also perform actions on alert without creating Alert object, simply using eg. "driver.switchTo().alert().accept();"

    }
}

