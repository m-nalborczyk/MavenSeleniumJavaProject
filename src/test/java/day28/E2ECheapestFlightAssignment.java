package day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E2ECheapestFlightAssignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://blazedemo.com/");

        //selecting departure and destination cities
        Select departureCity = new Select(driver.findElement(By.name("fromPort")));
        departureCity.selectByVisibleText("Philadelphia");
        Select destinationCity = new Select(driver.findElement(By.name("toPort")));
        destinationCity.selectByVisibleText("Rome");
        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

        //capturing all elements with flights prices
        List<WebElement> flightsPrices = driver.findElements(By.xpath("//tbody/tr/td[6]"));

        //creating new list and adding prices with removed $
        List<Double> prices = new ArrayList<>();
        for (WebElement flightPrice : flightsPrices){
            Double removed$price = Double.parseDouble(flightPrice.getText().replace("$",""));
            prices.add(removed$price);
        }

        //sorting list with prices to find the cheapest flight
        Collections.sort(prices);
        Double cheapestPrice = prices.getFirst();

        //picking the flight with the cheapest flight
        String cheapestPriceIn$ = "$"+cheapestPrice;
        for (int row=1; row<=driver.findElements(By.xpath("//tbody/tr")).size(); row++){
            if (driver.findElement(By.xpath("//tbody/tr["+row+"]/td[6]")).getText().equals(cheapestPriceIn$)){
                driver.findElement(By.xpath("//tbody/tr["+row+"]/td[1]")).click();
                break;
            }
        }


        driver.quit();

    }

}
