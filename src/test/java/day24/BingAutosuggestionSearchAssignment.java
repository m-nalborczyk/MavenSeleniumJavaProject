package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BingAutosuggestionSearchAssignment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies(); //deletes all the cookies in your browser

        driver.get("https://www.bing.com/");
        driver.findElement(By.linkText("Odrzuć")).click();
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("java");

        //first two prompts from auto-suggest are on different DOM structure, thus creating two separate Lists and combining into one
        List<WebElement> options1 = driver.findElements(By.xpath("//div[(@class='sa_tm_mainText sa_tm_rich')]"));
        List<WebElement> options2 = driver.findElements(By.xpath("//*[@role='option']/div[contains(@class,'sa_tm')]//span"));
        List<WebElement> combinedOptions = new ArrayList<>();
        combinedOptions.addAll(options1);
        combinedOptions.addAll(options2);

        for (WebElement option : combinedOptions){
            System.out.println(option.getText());
        }

        //selecting one option
        for (WebElement option : combinedOptions){
            if (option.getText().equals("java 17")){
                option.click();
                break;
            }
        }

    }
}
