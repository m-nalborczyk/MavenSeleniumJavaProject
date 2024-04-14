package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommandsDemo {

    public static void main(String[] args) throws InterruptedException {

//        Navigational commands
//        -----------------
//        navigate().to(url)        same as driver.get(url) in action to navigate to url but accept different parameters
//        navigate().forward()
//        navigate().back()
//        navigate().refresh()

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();

        //        navigate().to(URL)
        //        accepts url in URL & String format
        //
        //        driver.get()
        //        accepts only String format
        //        URL myurl=new URL("https://www.google.com")
    }
}
