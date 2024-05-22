package day33;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//ASSIGNMENT - pass data from excel file to online deposit calculator, validate expected results vs actual and write the result back to the same file
//remark - last row with incorrect data expectation to invoke fail test status

public class DataDrivenTestingExcelAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator/");

		WebElement initialDepositElement = driver.findElement(By.xpath("//input[@id='mat-input-0']"));		
		WebElement durationOfDepositElement = driver.findElement(By.xpath("//input[@id='mat-input-1']"));	
		WebElement interestRateElement = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		WebElement runCalculationElement = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")); // 'Lets run the numbers' button
		

		String filePath=System.getProperty("user.dir")+"\\testdata\\caldata2.xlsx";   	// set path to input file to read data from
		int lastRowIndex= ExcelUtils.getLastRowIndex(filePath, "Sheet1");		// get a last row index for data from file and Sheet1
		
		for(int rowIndex=1;rowIndex<=lastRowIndex;rowIndex++)
		{			
			//Reading data from excel
			String initialDepositData= ExcelUtils.getCellData(filePath,"Sheet1",rowIndex,0);
			String interestRateData=ExcelUtils.getCellData(filePath,"Sheet1",rowIndex, 1);
			String durationOfDepositData=ExcelUtils.getCellData(filePath,"Sheet1",rowIndex, 2);
			String compoundingData=ExcelUtils.getCellData(filePath,"Sheet1",rowIndex, 3);
			String expectedTotal=ExcelUtils.getCellData(filePath,"Sheet1",rowIndex, 4);

			//passing the data into the application
			initialDepositElement.clear();
			durationOfDepositElement.clear();
			interestRateElement.clear();

			initialDepositElement.sendKeys(initialDepositData);
			durationOfDepositElement.sendKeys(durationOfDepositData);
			interestRateElement.sendKeys(interestRateData);
						
			//Compounding Dropdown - not having select tag
			WebElement compoundingDropDownElement = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));
			compoundingDropDownElement.click();
			List<WebElement> compoundingDropDownOptions=driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
			
			for(WebElement option:compoundingDropDownOptions)
			{
				if(option.getText().equals(compoundingData))
					option.click();
			}
								
			runCalculationElement.click();
			String actualTotal = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			System.out.println("Actual Total calculate: " + actualTotal);
			System.out.println("Expected total: " + expectedTotal);

			//writing test results into excel data
			if(expectedTotal.equals(actualTotal)) {
				
				ExcelUtils.setCellData(filePath, "Sheet1",rowIndex, 6,"Test Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1",rowIndex, 6);
			}
			else
			{
				ExcelUtils.setCellData(filePath, "Sheet1",rowIndex, 6,"Test Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1",rowIndex, 6);
			}
		}
			System.out.println("All tests have been performed and results saved in the file.");
			driver.close();
		}
}
