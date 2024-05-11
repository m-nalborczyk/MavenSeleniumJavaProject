package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseRightClickDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

    //right-clicking on button and choosing copy from it
        Actions action = new Actions(driver);
        WebElement rightClickMeButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        action.contextClick(rightClickMeButton).perform();
        driver.findElement(By.xpath("//span[text()='Copy']")).click();

        Thread.sleep(2000);

    //handling alert confirming the click on copy option
        driver.switchTo().alert().accept();


    }
}
