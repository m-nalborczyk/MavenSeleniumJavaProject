package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");


        //absolute/full xpath - not recommended due to page structure changes
        String productName1 = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")).getText();
        System.out.println(productName1);

        //relative/partial xpath
        String productName2 = driver.findElement(By.xpath("//div[@class='description']/h4/a[@href='https://demo.opencart.com/index.php?route=product/product&language=en-gb&product_id=40']")).getText();
        System.out.println(productName2);

        //relative xpath with function for inner tag text
        String productName3= driver.findElement(By.xpath("//*[text()='MacBook']")).getText();
        System.out.println(productName3);

        driver.quit();
    }
}
