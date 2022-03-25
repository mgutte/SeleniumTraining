package day4;

import org.testng.annotations.DataProvider;

import day6.ReadExcel;

public class TestData {

	@DataProvider(name = "Login")
	public Object[][] getDataforLogin() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Admin", "admin123" },
				{"dixit", "admin123" },
				{"sanket", "admin123" },
				{"Admin", "admin123" }
				};

	}
	
	
	@DataProvider(name = "LoginScenario")
	public Object[][] getDataforLoginDifferentScenarios() {
		return new Object[][] { 
				{ "admin", "", "Password cannot be empty"},
				{ "", "admin123", "Username cannot be empty" }, 
				{ "AdminWrong", "admin123", "Invalid credentials" },
				{ "admin", "admin", "Invalid credentials" }, 
				{ "admin", "admin123", "Dashboard" } };

	}
	
	
	//-------------------------------------------- This is to read Excel Data------------

	@DataProvider(name = "LoginExcelData")
	public Object[][] ReadDataFromExcel() throws Exception{
		ReadExcel excel = new ReadExcel();
		String RelativePath = System.getProperty("user.dir");
		//Object[][] testObjArray = excel.getExcelData("D:\\Selenium_Training\\SeleniumTraining\\TestData\\OrangeHRM_TestData.xls","Login");
		Object[][] testObjArray = excel.getExcelData(RelativePath+"\\TestData\\OrangeHRM_TestData.xls","Login");
		System.out.println(testObjArray);
		return testObjArray;

	}
	
}
