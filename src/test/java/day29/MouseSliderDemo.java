package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseSliderDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

    //handling cookies popup
        driver.findElement(By.xpath("//p[text()='Do not consent']")).click();

    // Handling slider with offsetting on x/y-axis (here horizontal so just on x-axis)
        Actions action = new Actions(driver);
        WebElement minSlider = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')])[1]"));
        action.dragAndDropBy(minSlider,150, 0).perform();
        WebElement maxSlider = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')])[2]"));
        action.dragAndDropBy(maxSlider,-200,0).perform();


    }
}
