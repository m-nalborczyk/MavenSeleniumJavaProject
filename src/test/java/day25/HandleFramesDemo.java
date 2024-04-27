package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//frames/iframe
//
//driver.switchTo().frame(name/id)
//driver.switchTo().frame(WebElement)
//driver.switchTo().frame(index)
public class HandleFramesDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.automationtesting.in/Frames.html");

        //handling cookies popup
        driver.findElement(By.xpath("//p[text()='Do not consent']")).click();

        //switching to iframe by its name to interact with its content
        driver.switchTo().frame("SingleFrame");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Testing");
        //switching back to default content outside of frame
        driver.switchTo().defaultContent();

        //moving to page with iframe contained within other iframe
        driver.findElement(By.linkText("Iframe with in an Iframe")).click();
        //referencing iframe as WebElement and switching to it
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.switchTo().frame(frame1);
        //referencing iframe as index number (as there is only one contained it is not a problem) and switching to it
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Testing inside 2nd frame contained in 1st frame");

        driver.quit();



    }
}
