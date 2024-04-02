package day17;

//Assignement
//----------------
//        1) Launch browser
//        2) open url
//        URL: https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
//        3) Provide username  - admin@yourstore.com
//        4) Provide password  - admin
//        5) Click on Login button
//        6) Verify the title of dashboard page
//        Exp title : Dashboard / nopCommerce administration

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentLoginTest {
    public static void main(String[] args) throws InterruptedException {
        //        1) Launch browser
        WebDriver driver = new ChromeDriver();

        //        2) open url
        //        URL: https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();
        Thread.sleep(1500);

        //        3) Provide username  - admin@yourstore.com
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.clear();
        emailField.sendKeys("admin@yourstore.com");

        //        4) Provide password  - admin
        WebElement passField = driver.findElement(By.id("Password"));
        passField.clear();
        passField.sendKeys("admin");

        //        5) Click on Login button
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
        Thread.sleep(1500);

        //        6) Verify the title of dashboard page after logging in
        String actLabel = null;
        try {
            actLabel = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText();
        }
        catch (NoSuchElementException e){
            actLabel="";
        }
        String expLabel = "Dashboard";

        if (actLabel.equals(expLabel)){
            System.out.println("The user has successfully logged in");
        }
        else {
            System.out.println("The user has failed to log in.");
        }

        driver.quit();

    }

}
