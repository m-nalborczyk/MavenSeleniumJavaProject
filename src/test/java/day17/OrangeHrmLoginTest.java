package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//1) Launch browser
//2) open url
//        https://opensource-demo.orangehrmlive.com/
//        3) Provide username  - Admin
//        4) Provide password  - admin123
//        5) Click on Login button
//        6) Verify the title of dashboard page
//        Exp title : OrangeHRM
//        7) close browser
public class OrangeHrmLoginTest {
    public static void main(String[] args) throws InterruptedException {

        //Setup Driver
        //1st way of setup for driver:
        //System.setProperty("webdriver.chrome.driver", "\"C:\\Users\\nalbo\\OneDrive\\Pulpit\\nauka\\Drivers and resources\\chromedriver-win64\\chromedriver.exe\"");

        //2nd way with WebDriver dependency added to pom.xml
        //WebDriverManager.chromiumdriver().setup();

        //after selenium version 4.6+ above are no longer required and below is enough for the setup
        //WebDriverManager is included in 4.6+ selenium version so no need to put it as dependency
        //also for 4.6+ no need to setup driver with System.setProperty(...)

        //1) Launch browser
        //ChromeDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();

        //2) open url
        //https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize(); //maximazing window
        Thread.sleep(2000); //this allows for the webpage to load before proceeding with script steps and prevent synchronization issue and throwing NoSuchElementException

        //3) Provide username  - Admin
        //WebElement usernameField = driver.findElement(By.name("username"));
        //usernameField.sendKeys("Admin");
        driver.findElement(By.name("username")).sendKeys("Admin");

        //4) Provide password  - admin123
        driver.findElement(By.name("password")).sendKeys("admin123");

        // 5) Click on Login button
        driver.findElement((By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"))).click();
        Thread.sleep(2000);

        // 6) Verify the title of dashboard page
        // Exp title : OrangeHRM
        //Title validation:
//        String act_title = driver.getTitle();
//        String exp_title = "OrangeHRM";
//        if (act_title.equals(exp_title)){
//            System.out.println("Test has passed.");
//        }
//        else {
//            System.out.println("Test has failed");
//        }
        //Label validation expected after logging in
        String actLabel = null;
        try {
            actLabel = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
        }
        catch (NoSuchElementException e){
            actLabel=""; //need to specify as empty as .equals() method cannot be invoked on null String value
        }

        String expLabel = "Dashboard";
        if (actLabel.equals(expLabel)){
            System.out.println("Test has passed");
        }
        else {
            System.out.println("Test has failed");
        }

        // 7) close browser
        driver.quit();




    }
}
