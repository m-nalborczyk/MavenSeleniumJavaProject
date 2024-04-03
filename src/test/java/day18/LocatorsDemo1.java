package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo1 {

    public static void main(String[] args) {
        //open browser
        WebDriver driver = new ChromeDriver();
        //maximize window
        driver.manage().window().maximize();
        //open url in the browser
        driver.get("https://tutorialsninja.com/demo/");
        //enter input into search field
        driver.findElement(By.name("search")).sendKeys("Galaxy");
        //click on search icon
        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
        //click on linktext (first is partial link which doesn't require full link text but potentially can have duplicates on DOM)
        //driver.findElement(By.partialLinkText("Galaxy")).click();
        driver.findElement(By.linkText("Samsung Galaxy Tab 10.1")).click();


    }
}
