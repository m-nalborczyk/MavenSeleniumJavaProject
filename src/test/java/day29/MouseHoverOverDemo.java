package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseHoverOverDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.opencart.com/");

    // hovering over Desktops tab in order to be able to hover over Mac and click it
        Actions action = new Actions(driver);
        WebElement desktops = driver.findElement(By.xpath("//a[text()='Desktops']"));
        action.moveToElement(desktops).perform();
        WebElement mac = driver.findElement(By.xpath("//a[text()='Mac (1)']"));
        action.moveToElement(mac).perform();
        mac.click();

    }
}
