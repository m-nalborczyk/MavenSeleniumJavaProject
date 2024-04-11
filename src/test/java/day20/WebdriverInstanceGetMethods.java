package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WebdriverInstanceGetMethods {

    public static void main(String[] args) throws InterruptedException {


        //WEBDRIVER INSTANCE GET METHODS (not WebElement ones):
        //        get(url)
        //        getTitle()
        //        getCurrentUrl()
        //        getPageSource()
        //        getWindowHandle()
        //        getWindowHandles()

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com");
        System.out.println("Title of the page: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("page source: " + driver.getPageSource());
        System.out.println("doest page source contains '76BC21'? : " + driver.getPageSource().contains("76BC21"));

        //providing time for DOM to be generated after loading the webpage
        Thread.sleep(2000);
        //click on link to open a new tab
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        //getting and storing open tabs ids in Set collection
        Set<String> windowsIds = driver.getWindowHandles();
        //enhanced loop to read windows ids
        for (String windowId : windowsIds){
            System.out.println(windowId);
        }
        // > windows ids are used for navigating through different windows

    }
}
