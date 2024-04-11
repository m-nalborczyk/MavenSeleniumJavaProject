package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitCloseBrowserCommands {
    public static void main(String[] args) throws InterruptedException {

//        browser methods
//        ---------------
//        close() - to close the current browser window or tab
//        quit() - to close all browser windows and end the WebDriver session

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        //below will only close current instance window and the rest of windows opened will remain so
        driver.close();
        Thread.sleep(2000);
        //now below will close all windows related to created WebDriver instance
        driver.quit();




    }
}
