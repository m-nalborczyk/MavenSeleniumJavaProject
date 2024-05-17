package day30;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollingPageDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");

        //handle checking if you are human
        WebElement frame = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        wait.until(ExpectedConditions.titleIs("Country flags of the world with images and names"));

        //scroll down page by pixels + printing offset method
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");
        System.out.println(js.executeScript("return window.pageYOffset;"));

        Thread.sleep(3000);

        //scroll down page until element is present
        WebElement flagOfCroatia = driver.findElement(By.xpath("//img[@alt='Flag of Croatia']"));
        js.executeScript("arguments[0].scrollIntoView();", flagOfCroatia);

        Thread.sleep(3000);

        //scroll down till end of page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(3000);

        //scroll back to initial position
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

    }
}
