package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FieldValidation {
	ChromeDriver driver;
	@BeforeTest
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	@Test(priority=1)
	// This is for Sign On Functionality
	public void Sign_On() throws InterruptedException

	{
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String Element = driver.findElement(By.linkText("Dashboard")).getText();
		System.out.println(Element);
		
	}
	
	@Test(priority=2)
	public void AddUsers_Page()
	{
		//WebElement admin = driver.findElementById("menu_admin_viewAdminModule");
		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		Actions action = new Actions(driver);
		action.moveToElement(admin).build().perform();
		//WebElement usermanagement = driver.findElementByLinkText("User Management");
		WebElement usermanagement = driver.findElement(By.linkText("menu_admin_viewAdminModule"));
		action.moveToElement(usermanagement).build().perform();
		//driver.findElementByLinkText("Users").click();
		driver.findElement(By.linkText("Users"));
		//User Click on Add Button to add users
		//driver.findElementById("searchBtn").click();
		driver.findElement(By.id("searchBtn"));
		//driver.findElementById("btnAdd").isDisplayed();
		driver.findElement(By.id("btnAdd")).isDisplayed();
		
	}
	@Test(priority=3,enabled=true)
	public void VerifyAddedUser() throws InterruptedException
	{
		//driver.findElementById("btnAdd").click();
		driver.findElement(By.id("btnAdd")).click();
		
		//Enter all the mandatory Fields
		Select SelectPass = new Select(driver.findElement(By.id("systemUser_userType")));
		//SelectPass.selectByValue("1");
		SelectPass.selectByVisibleText("Admin");
		//SelectPass.selectByIndex(0);
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");
		//Random randomGenerator = new Random();  
		//int randomInt = randomGenerator.nextInt(500); 
		WebElement UserNameInputbox=driver.findElement(By.id("systemUser_userName"));
		UserNameInputbox.sendKeys("abhidixitabhidixitabhidixitabhidixitabh"+System.currentTimeMillis());
		//Verify the MaxLength of UserName Field
		String EnteredValue = UserNameInputbox.getAttribute("value");
		int EnteredValueSize=EnteredValue.length();
		System.out.println("User Name Value entered size ="+EnteredValueSize);
		// Assert with expected
		if (EnteredValueSize == 40) {
			System.out.println("Maxlength character functionality is 40 and its working fine.");
			Assert.assertTrue(true);
		}
 
		else {
			System.out.println("It allow more than 40");
			Assert.assertFalse(false);
		}
 	//----------------------------------------
		driver.findElement(By.id("systemUser_password")).sendKeys("Pass@2212");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Pass@2212");
		Thread.sleep(5000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(5000);
		String ExpUserName=EnteredValue;
		System.out.println(ExpUserName);
	    //WebElement cellIneed = driver.findElementByXPath("//*[@id='resultTable']/tbody/tr[1]/td[2]/a");
		WebElement cellIneed = driver.findElement(By.xpath("//a[contains(text(),'"+EnteredValue+"')]"));
		//a[contains(text(),'abhidixit699')]
		//---//a[text()='"+ExpUserName+"']
	    String valueIneed = cellIneed.getText();
	    System.out.println("Cell value is : " + valueIneed); 
	    Assert.assertEquals(ExpUserName, valueIneed);
	    //Delete User from Search List

	    //driver.findElementByXPath("//a[text()='"+EnteredValue+"']/parent::td/preceding-sibling::td/input").click();
	    driver.findElement(By.xpath("//a[text()='"+EnteredValue+"']//parent::td/../td[contains(text(), 'Admin')]//parent::td/preceding-sibling::td/input")).click();
	    //driver.findElementByXPath("//td/a[text()='"+EnteredValue+"']//parent::td/../td[text()='Admin']").isDisplayed();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		
	}

	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
	
	
}
