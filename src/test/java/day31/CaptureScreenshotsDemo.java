package day31;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CaptureScreenshotsDemo {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com");

        //capture full page screenshots - selenium 3 and 4+
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File trg = new File("E:\\Projects\\Java\\MavenSeleniumJavaProject\\screenshots\\fullpage.jpg");
        FileUtils.copyFile(src,trg);

        //capture screenshot of specific area of webpage - selenium 4+
        WebElement featuredProducts = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File src2 = featuredProducts.getScreenshotAs(OutputType.FILE);
        File trg2 = new File("E:\\Projects\\Java\\MavenSeleniumJavaProject\\screenshots\\featured_products.jpg");
        FileUtils.copyFile(src2, trg2);

        //capture screenshot of specific element - selenium 4+
        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File src3 = logo.getScreenshotAs(OutputType.FILE);
        File trg3 = new File("E:\\Projects\\Java\\MavenSeleniumJavaProject\\screenshots\\logo.jpg");
        FileUtils.copyFile(src3, trg3);

    }
}
