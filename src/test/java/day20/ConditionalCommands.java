package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

    public static void main(String[] args) {

//        conditional commands - access these commands through WebElement
//        ----------------------
//        Returns true/false ( boolean values)
//
//        isDisplayed()
//        isEnabled()
//        isSelected()

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        //check if logo is present
        WebElement logo = driver.findElement(By.xpath("//img[@alt='ParaBank']"));
        System.out.println("Is logo present on the webpage ? : " + logo.isDisplayed());

        //check if home icon link is present
        Boolean isHomePresent = driver.findElement(By.xpath("//a[text()='home']")).isDisplayed();
        System.out.println("Is home icon link present on the webpage ? : " + isHomePresent);

        //check if male gender radio button is enabled for interaction
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        Boolean isMaleRadioButtonEnabled = driver.findElement(By.xpath("//input[@id='gender-male']")).isEnabled();
        System.out.println("Is male gender radio button enabled for interaction? : " + isMaleRadioButtonEnabled);

        //check if female gender radio button is selected
        WebElement femaleGenderRadioButton = driver.findElement(By.xpath("//input[@id='gender-female']"));
        System.out.println("Is female gender radio button selected? : " + femaleGenderRadioButton.isSelected());

        System.out.println("Now clicking...");
        femaleGenderRadioButton.click();
        System.out.println("Clicked...");
        System.out.println("Is it selected now ? : " + femaleGenderRadioButton.isSelected());

        driver.quit();

    }
}
