package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocationOfElementDemo {
    public static void main(String[] args) {

        //location of elements depends on the screen size

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));

        System.out.println("Location of logo before maximizing: " + logo.getLocation());
        driver.manage().window().maximize();
        System.out.println("Location of logo after maximizing: " + logo.getLocation());
        driver.manage().window().fullscreen();
        System.out.println("Location of logo in fullscreen mode: " + logo.getLocation());
        // Set the size of the browser window to specific dimensions
        Dimension size = new Dimension(800, 600); // Width: 800 pixels, Height: 600 pixels
        driver.manage().window().setSize(size);
        System.out.println("Location of logo in set size: " + logo.getLocation());


    }
}
