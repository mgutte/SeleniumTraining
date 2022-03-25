package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGGroups {
 


ChromeDriver chDriver;

	@Test(groups={"sanitytest"})
	  public void printSmoke() {
		System.out.println("Sanity TC1");
	}

	@Test(groups={"sanitytest"})
	  public void printSmok2() {
		System.out.println("Sanity TC2");
	}
	  
	    
	  @Test(groups={"smoketest"})
	  public void Smoke1() {
		System.out.println("Smoke class1");
	  }


	  
}
