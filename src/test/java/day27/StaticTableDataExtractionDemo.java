package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StaticTableDataExtractionDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        //1 Find total number of rows
        int numberOfRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("Number of rows: " + numberOfRows);

        //2 Find total number of columns
        int numberOfColumns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
        System.out.println("Number of columns: " + numberOfColumns);

        //3 Read specific row & column data - "Animesh"
        String specificDataCell = driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]/td[2]")).getText();
        System.out.println("Captured specific cell data: " + specificDataCell);

        //4 Read data from all the rows & columns
        //starting from 2nd row as in 1st row there are table headers
        for (int row = 2; row <= numberOfRows; row++) {
            for (int col = 1; col <= numberOfColumns; col++) {
                String capturedDataCell = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]/td[" + col + "]")).getText();
                System.out.print(capturedDataCell + "\t");
            }
            System.out.println();
        }

        //5 Print book names of author "Amit"
        for (int row = 2; row <= numberOfRows; row++) {
            String capturedAuthorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]/td[2]")).getText();
            if (capturedAuthorName.equals("Amit")){
                String bookTitle = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]/td[1]")).getText();
                System.out.println(bookTitle + " written by " + capturedAuthorName);
            }
        }

        //6 Find sum of prices for all the books
        int totalBooksValue = 0;
        for (int row = 2; row <= numberOfRows; row++) {
            int capturedPrice = Integer.parseInt(driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]/td[4]")).getText());
            totalBooksValue+=capturedPrice;
        }
        System.out.println("Total value of all books: " + totalBooksValue);

        driver.quit();
    }

}
