package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


//Assignment
//---------
//https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//
//Login
//Go to PIM
//Capture all data for first name & last name from Employee table
public class OrangeHrmTableAssignment {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"))
                .click();
        driver.findElement(By.xpath("//span[text()='PIM']")).click();

        System.out.println("First Name" + "\t" + "Surname");;

        for (int row = 2; row <= driver.findElements(By.xpath("//div[@role='row']")).size(); row++) {
            String name = driver.findElement(By.xpath("(//div[@role='row'])[" + row + "]/div[3]")).getText();
            String surname = driver.findElement(By.xpath("(//div[@role='row'])[" + row + "]/div[4]")).getText();
            System.out.println(name + "\t" + surname);
        }

        try {
            while (true) {
                driver.findElement(By.xpath("//button[contains(@class, 'oxd-pagination-page-item--previous-next')]//i[contains(@class, 'bi-chevron-right')]")).click();
                for (int row = 2; row <= driver.findElements(By.xpath("//div[@role='row']")).size(); row++) {
                    String name = driver.findElement(By.xpath("(//div[@role='row'])[" + row + "]/div[3]")).getText();
                    String surname = driver.findElement(By.xpath("(//div[@role='row'])[" + row + "]/div[4]")).getText();
                    System.out.println(name + "\t" + surname);
                }
            }
        } catch (NoSuchElementException e) {
            // Handle NoSuchElementException when reaching the last pagination page
            System.out.println("Reached the last pagination page and captured all the data.");
        }

        driver.quit();
    }
}
