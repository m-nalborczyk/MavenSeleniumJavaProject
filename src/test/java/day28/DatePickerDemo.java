package day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickerDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("datepicker")).click();

        String targetYear = "2027";
        String targetMonth = "December";
        String targetDay = "12";


        //select target month and year
        while (true){

            String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (month.equals(targetMonth) && year.equals(targetYear)) {
                break;
            }

            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // for future date
            //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // for past date

        }

        //select target day
        List <WebElement> dayFields = driver.findElements(By.xpath("//td"));
        for (WebElement day:dayFields){
            if (day.getText().equals(targetDay)){
                day.click();
                break;
            }
        }



    }
}
