package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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


        //counting number of different elements

//        Scenario1:    locator is matching with single web element.
//        findElement(loc)      >return single web element as WebElement
//        findElements(loc)     >return single web element as List<WebElement>
//
//        Scenario2:    locator is matching with multiple web elements
//        findElement(loc)      >return single web element(first found) as WebElement
//        findElements(loc)     >return multiple web elements(all found) as List<WebElement>
//
//        Scenario3:    locator is incorrect (elements are not matching with locator)
//        findElement(loc)      >return NoSuchElementException
//        findElements(loc)     >return single WebElement as List<WebElement>


        //count sliders on different webpage
        driver.get("https://www.demoblaze.com/");
        List<WebElement> sliders = driver.findElements(By.className("carousel-item"));
        System.out.println("Number of sliders: "+sliders.size());
        //count links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links: "+links.size());
        //count images
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Number of images: "+images.size());
        //close browser
        driver.quit();


    }
}
