package day31;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class HeadlessTestingDemo {
    public static void main(String[] args) {

        // Create a ChromeOptions instance
        ChromeOptions options = new ChromeOptions();

        // Set headless mode using addArguments
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement((By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"))).click();

        String actLabel = null;
        try {
            actLabel = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
        }
        catch (NoSuchElementException e){
            actLabel=""; //need to specify as empty as .equals() method cannot be invoked on null String value
        }

        String expLabel = "Dashboard";
        if (actLabel.equals(expLabel)){
            System.out.println("Test has passed");
        }
        else {
            System.out.println("Test has failed");
        }

        driver.quit();




    }
}
