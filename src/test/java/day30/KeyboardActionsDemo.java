package day30;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class KeyboardActionsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://text-compare.com");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.xpath("//textarea[@name='text1']")).sendKeys("Welcome to AUTOMATION");

        Actions action = new Actions(driver);

        //ctrl + a
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        //ctrl + c
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

        //tab
        action.sendKeys(Keys.TAB).perform();

        //ctrl + v
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

        driver.findElement(By.className("compareButtonText")).click();

    }
}
