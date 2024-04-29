package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleIframeAssignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://the-internet.herokuapp.com/iframe");

        //assigning frame as WebElement and switching to it
        WebElement frame = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
        driver.switchTo().frame(frame);

        //clearing default content and inputting required one
        driver.findElement(By.xpath("//body[@id='tinymce']/p")).clear();
        driver.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys("Testing my input.");

        driver.quit();

    }
}
