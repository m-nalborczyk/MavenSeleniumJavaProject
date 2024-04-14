package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckboxesDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //implicit wait for synchronization issues
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.ironspider.ca/forms/checkradio.htm");

        //select 1 checkbox (yellow)
        driver.findElement(By.xpath("//input[@value='yellow']")).click();
        //unclick
        driver.findElement(By.xpath("//input[@value='yellow']")).click();

        //select all color checkboxes
        List<WebElement> colorCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox' and @name='color']"));
        System.out.println("Total number of color checkboxes: " + colorCheckboxes.size());
        //2 loops for selection of all
        //1st loop with index
        for (int i=0; i<colorCheckboxes.size(); i++){
            colorCheckboxes.get(i).click();
        }
        //unclick with 2nd enhanced loop
        for (WebElement checkbox : colorCheckboxes){
            checkbox.click();
        }

        //select last 2 of color checkboxes
        //formula: total number of checkboxes - how many last checkboxes to be selected = starting index
        for (int i = colorCheckboxes.size() - 2; i < colorCheckboxes.size(); i++){
            colorCheckboxes.get(i).click();
        }

        //select first 2 color checkboxes
        //formula: i < how many first checkboxes to be selected
        for (int i=0; i<2; i++){
            colorCheckboxes.get(i).click();
        }
        Thread.sleep(1500);

        //unselect all selected at current time
        for (WebElement checkbox : colorCheckboxes){
            if (checkbox.isSelected()){
                checkbox.click();
            }
        }
    }
}
