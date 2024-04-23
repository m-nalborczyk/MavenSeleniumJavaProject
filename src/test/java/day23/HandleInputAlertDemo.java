package day23;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleInputAlertDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Welcome");
        alert.accept();

        //validation
        String act_value = driver.findElement(By.id("result")).getText();
        String exp_value = "You entered: Welcome";

        if (act_value.equals(exp_value)){
            System.out.println("Test has passed");
        }
        else {
            System.out.println("Test has failed");
        }

        driver.quit();
    }
}
