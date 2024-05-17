package day30;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TabsAndWindowsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.opencart.com");

        driver.switchTo().newWindow(WindowType.WINDOW); //opens new window
        driver.switchTo().newWindow(WindowType.TAB); //opens new tab

        driver.get("https://opensource-demo.orangehrmlive.com");

    }
}
