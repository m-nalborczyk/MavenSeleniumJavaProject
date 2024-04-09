package day19;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class XPathAxesExamples {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		Thread.sleep(2000);


        //Selecting Following Siblings
        List<WebElement> followingSiblings = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td[2]/following-sibling::*"));
        for (WebElement sibling : followingSiblings) {
            System.out.println("Following Sibling: " + sibling.getText());
        }

		//Selecting Preceding Siblings
		List<WebElement> precedingSiblings = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td[5]/preceding-sibling::*"));
		for (WebElement sibling : precedingSiblings) {
			System.out.println("Preceding Sibling: " + sibling.getText());
		}

          // Other options for xpath axes:

//        // Selecting Ancestors
//        WebElement ancestor = driver.findElement(By.xpath("//div[@id='example']/ancestor::*"));
//        System.out.println("Ancestor: " + ancestor.getText());
//
//        // Selecting Descendants
//        List<WebElement> descendants = driver.findElements(By.xpath("//div[@id='example']/descendant::*"));
//        for (WebElement descendant : descendants) {
//            System.out.println("Descendant: " + descendant.getText());
//        }
//
//        // Selecting Parent
//        WebElement parent = driver.findElement(By.xpath("//div[@id='example']/parent::*"));
//        System.out.println("Parent: " + parent.getText());
//
//        // Selecting Children
//        List<WebElement> children = driver.findElements(By.xpath("//div[@id='example']/child::*"));
//        for (WebElement child : children) {
//            System.out.println("Child: " + child.getText());
//        }
//
//        // Selecting Self
//        WebElement self = driver.findElement(By.xpath("//div[@id='example']/self::*"));
//        System.out.println("Self: " + self.getText());


        driver.quit();
    }
}

		


