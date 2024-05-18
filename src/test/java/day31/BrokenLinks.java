package day31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.deadlinkcity.com");

        List<WebElement> linkElements = driver.findElements(By.xpath("//a"));

        int quantityBrokenLinks = 0;

        for (WebElement linkElement : linkElements) {

            String hrefAttribute = linkElement.getAttribute("href");

            if (hrefAttribute == null || hrefAttribute.equals("")) {
                System.out.println("href attribute empty");
                continue;
            }

            try {
                URL linkUrl = new URL(hrefAttribute);
                //send request to server - open connect
                HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
                connection.connect();

                if (connection.getResponseCode() >= 400) {
                    System.out.println(hrefAttribute + " >>> Broken link with response: " + connection.getResponseCode());
                    quantityBrokenLinks++;
                } else {
                    System.out.println(hrefAttribute + " >>> Working link with response: " + connection.getResponseCode());
                }
            } catch (UnknownHostException e) {
                System.out.println(hrefAttribute + " >>> Domain does not exist");
                quantityBrokenLinks++;
            }
            catch (ClassCastException e){
                System.out.println(hrefAttribute + " >>> MailToURLConnection cannot be cast to an HttpURLConnection ");
            }
        }
        System.out.println("There are " + quantityBrokenLinks + " broken links on this page.");
        driver.quit();
    }
}
