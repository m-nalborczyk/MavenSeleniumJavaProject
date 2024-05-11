package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseDoubleClickDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");

    // handle cookies pop-up
        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();


    // double-click on the element and validation for it
        Actions action = new Actions(driver);
        driver.switchTo().frame("iframeResult");
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[normalize-space()='Double-click me']"));

        action.doubleClick(doubleClickButton).build().perform();

        if (driver.findElement(By.xpath("//p[@id='demo']")).getText().equals("Hello World")){
            System.out.println("Double-click action successful and test passed");
        } else {
            System.out.println("Test failed.");
        }



    }


}
