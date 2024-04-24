package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTextExtractionAssignment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.xpath("//*[@name='proceed']")).click();
        System.out.println("Alert info: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
