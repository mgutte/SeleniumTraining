package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import day4.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;


public class OrangeHRMDDT_TestNG_Excel extends TestData {





// Global Declaration
	ChromeDriver driver;

	@Test(dataProvider="LoginExcelData")
	public void Login_Valid_Scenario(String uname, String upass) throws InterruptedException {

		driver.findElement(By.name("txtUsername")).sendKeys(uname);
		driver.findElement(By.name("txtPassword")).sendKeys(upass);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		
	}

	@BeforeTest
	public void LaunchBrowser() {
		// Download chromedriver at run time
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	
	}

	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
	}
	
	@AfterMethod
	public void logout() throws InterruptedException
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.id("btnLogin")).isDisplayed();
	}

}
