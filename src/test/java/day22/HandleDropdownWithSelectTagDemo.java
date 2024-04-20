package day22;

//Dropdowns
//----------
//1) Drop down having select tag in DOM.
//2) DropDown not having select tag in DOM ( input/div) - Bootstrap dropdown
//3) Auto Suggest drop down ( Dynamic)

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HandleDropdownWithSelectTagDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");

    //1) Drop down having select tag in DOM.
        // Locate the dropdown element by its ID
        WebElement dropdown = driver.findElement(By.id("country-list"));

        // Create a Select object to work with the dropdown
        Select select = new Select(dropdown);

        // Perform actions on the dropdown
        // Select by visible text
        select.selectByVisibleText("China");
        Thread.sleep(1500);
        // Select by value
        select.selectByValue("4");
        Thread.sleep(1500);

        // Select by index
        select.selectByIndex(5);

    //1a) Find total options in dropdown
        List<WebElement> options = select.getOptions();
        //normal for loop
        for (int i=0; i<options.size(); i++){
            System.out.println("Option " + i + ": " + options.get(i).getText());
        }
        //enhanced for each loop
        for (WebElement option:options){
            System.out.println(option.getText());
        }



    }
}
