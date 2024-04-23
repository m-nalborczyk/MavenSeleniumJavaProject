package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCredentialsWindowDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //handling pop-up credentials window with input injection
        //syntax:
        //"http://<field input>:<another field input>@<URL after http://>"

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //above will handle as user would fill in username as admin and password as admin and lick continue to log in

        //validation
        String act_value = driver.findElement(By.xpath("//h3/following-sibling::*")).getText();
        String exp_value = "Congratulations! You must have the proper credentials.";

        if (act_value.equals(exp_value)){
            System.out.println("You have successfully logged in.");
        }
        driver.quit();

    }
}
