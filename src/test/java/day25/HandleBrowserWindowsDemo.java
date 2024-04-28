package day25;

//handle browser windows

//getWindowHandle() - return id of single window( in which driver focused)
//getWindowHandles()- returns id's of multiple windows
//driver.switchTo().window(window id)
//driver.switchTo().window(window id).getTitle()

//many browser windows opened:
//close() - close single browser window which is focused by driver
//quit() - close all the browser windows which are currently opened

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//3 types of switching commands
//1) driver.switchTo().alert()
//2)  driver.switchTo().frame()
//3) driver.switcho().window()
public class HandleBrowserWindowsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();

        //capture ids of windows open
        Set<String> windowIds = driver.getWindowHandles();


        //Approach 1
        //converting Set to List to be able to use .get() method
        List<String> listOfWindowIds = new ArrayList<>(windowIds);
        //getting and storing variables to be used in switchTo().window() to change tabs
        String parentWindowId = listOfWindowIds.get(0);
        String childWindowId = listOfWindowIds.get(1);
        //switching to child tab and doing action
        driver.switchTo().window(childWindowId);
        driver.findElement(By.xpath("(//button[text()='Contact Sales'])[2]")).click();
        //switching to parent tab and doing another action
        driver.switchTo().window(parentWindowId);
        driver.findElement(By.name("username")).sendKeys("admin");



        /*
        //Approach 2
        //using for loops for ids of windows with titles of pages
        for (String windowId : windowIds){
            String windowTitle = driver.switchTo().window(windowId).getTitle();
            if (windowTitle.equals("Human Resources Management Software | OrangeHRM")){
                driver.findElement(By.xpath("(//button[text()='Contact Sales'])[2]")).click();
            }
        }
        for (String windowId : windowIds){
            String windowTitle = driver.switchTo().window(windowId).getTitle();
            if (windowTitle.equals("OrangeHRM")){
                driver.findElement(By.name("username")).sendKeys("admin");
            }
        }
        */


        //closing parent window as the driver focus is there
        driver.close();


    }
}
