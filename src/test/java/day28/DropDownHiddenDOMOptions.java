package day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DropDownHiddenDOMOptions {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[text()='PIM']")).click();

        //interact with dropdown with hidden option in DOM after removing blur option in event listeners tab
        driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[4]")).click();
        Thread.sleep(2000);
        List<WebElement> hiddenOptions = driver.findElements(By.xpath("//div[@role='listbox']/div/span"));
        for (WebElement option:hiddenOptions){
            System.out.println(option.getText());
        }
        for (WebElement option:hiddenOptions){
            if (option.getText().equals("Finance")){
                option.click();
                break;
            }
        }

        driver.quit();



    }
}
