package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseDragDropDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

    // Drag & drop functionality
        Actions actions = new Actions(driver);
        WebElement oslo = driver.findElement(By.xpath("(//div[@class='dragableBox'][text()='Oslo'])[2]"));
        WebElement norway = driver.findElement(By.xpath("//div[text()='Norway']"));

        actions.dragAndDrop(oslo,norway).perform();


    }
}
