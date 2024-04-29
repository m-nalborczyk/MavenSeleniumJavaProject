package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindowsAssignment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        //opening 5 new tabs and getting all windows handles
        for (int i=0; i<5; i++) {
            driver.findElement(By.xpath("//button[text()='New Browser Window']")).click();
        }
        Set<String> windowIds = driver.getWindowHandles();

        //iterating through all tabs and capturing titles and adding them into new list + adding conditions to wait until page is fully loaded and showing correct title
        List<String> windowTitles = new ArrayList<>();
        for (String windowId : windowIds){
            driver.switchTo().window(windowId);
            wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Cierpliwości...")));
            windowTitles.add(driver.getTitle());
        }

        System.out.println(windowTitles);
        driver.quit();


    }
}
