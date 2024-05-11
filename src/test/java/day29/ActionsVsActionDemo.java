package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsVsActionDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement rightClickMeButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));


        Actions action = new Actions(driver);
        //action.contextClick(rightClickMeButton).perform(); //creating and performing action at the same step

        Action myAction = action.contextClick(rightClickMeButton).build(); //creating action and storing it in variable that implements Action interface for future execution
        myAction.perform(); //completing the action


        driver.findElement(By.xpath("//span[text()='Copy']")).click();






    }
}
