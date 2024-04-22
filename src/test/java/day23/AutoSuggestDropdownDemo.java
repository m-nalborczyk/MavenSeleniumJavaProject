package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropdownDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[text()='Odrzuć wszystko']")).click();
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");


        // Handling potential StaleElementReferenceException
        boolean retry = true;

        // Repeating actions until exception does not occur
        while (retry) {
            try {
                // Wait for the search results container to become visible
                WebElement searchResultsContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mkHrUc']")));

                // Capture the search results
                List<WebElement> searchResults = searchResultsContainer.findElements(By.xpath("//div[contains(@class,'wM6W7d')][@role='presentation']//span"));
                for (WebElement result : searchResults) {
                    System.out.println(result.getText());
                }

                // Select desired option
                for (WebElement result: searchResults){
                    String text = result.getText();
                    if (text.equals("selenium grid")){
                        result.click();
                        break;
                    }
                }

                // Set retry to false if no exception occurs to leave while loop
                retry=false;


            } catch (StaleElementReferenceException e) {
                // Handle StaleElementReferenceException by retrying the action
                System.out.println("StaleElementReferenceException occurred. Retrying the action...");
            }
        }


    }
}
