package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//CSS selectors

//tags below are optional (but can increase search accuracy)

//1
//tag#id                            > # to be used before id
//Ex:       input#small-searchterms
//		    #small-searchterms

//2
//tag.class                         > . to be used before class
//Ex:       input.search-box-text
//          .search-box-text

//3
//tag[attribute='value']            > []to be used and inside the attribute='value' for any attribute
//Ex:       input[name='q']
//          [name='q']

//4
//tag.class[attribute='value']      > . to be used before class + [attribute='value'] it is used to further increase search accuracy
//
//Ex:       input.search-box-text[name='q']
//          .search-box-text[name='q']
public class CssSelectorsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

        //UNCOMMENT TO TEST

        //1 tag#id
        //driver.findElement(By.cssSelector("input#search")).sendKeys("TEST");
        //driver.findElement(By.cssSelector("#search")).sendKeys("TEST");

        //2 tag.class
        //driver.findElement(By.cssSelector("input.input-text")).sendKeys("TEST");
        //driver.findElement(By.cssSelector(".input-text")).sendKeys("TEST");

        //3 tag[attribute='value']
        //driver.findElement(By.cssSelector("input[placeholder=\"Search entire store here...\"]")).sendKeys("TEST");    // \" can allow using " inside other " section; also ' can be used for value as below
        //driver.findElement(By.cssSelector("[placeholder='Search entire store here...']")).sendKeys("TEST");

        //4 tag.class[attribute='value']
        //driver.findElement(By.cssSelector("input.input-text[type='text']")).sendKeys("TEST");
        //driver.findElement(By.cssSelector(".input-text[id='search']")).sendKeys("TEST");


    }
}
