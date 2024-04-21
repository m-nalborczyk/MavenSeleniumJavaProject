package day22;

//Dropdowns
//----------
//1) Drop down having select tag in DOM.
//2) DropDown not having select tag in DOM ( input/div) - Bootstrap dropdown
//3) Auto Suggest drop down ( Dynamic)

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HandleDropdownWithoutSelectTagDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://demoqa.com/select-menu");

        //2) DropDown not having select tag in DOM ( input/div) - Bootstrap dropdown
        //clicking on the dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='withOptGroup']/div/div[1]"))).click();

        //capturing elements after dropdown is clicked
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='withOptGroup']/div/div[1]/div"));

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        //selecting option from dropdown
        for (WebElement option : options) {
            if (option.getText().contains("Group 2, option 1")) {
                option.click();
                break;
            }
        }


        driver.quit();
    }


}
