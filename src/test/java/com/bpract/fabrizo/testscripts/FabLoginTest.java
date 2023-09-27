package com.bpract.fabrizo.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.fabrizo.pages.FabHomePage;
import com.bpract.fabrizo.pages.FabLoginPage;
import com.bpract.fabrizo.utilities.ExcelDataProvider;

public class FabLoginTest extends FabTestHelper{
	
	FabLoginPage fabloginpage;
	FabHomePage fabhomepage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
	}
	
	@DataProvider(name="ValidLogin")
	public Object[][]getData(){
		String excelpath = "C:\\Users\\namit\\OneDrive\\Desktop\\Namita\\login data.xlsx";
		ExcelDataProvider exceldataprovider = new ExcelDataProvider();
		Object data[][] = exceldataprovider.testData(excelpath, "Sheet1");
		return data;
	}
	
	@Test(dataProvider="ValidLogin")
	public void verifyLoginWithValidDataForUser(String username, String password) {
		fabloginpage = new FabLoginPage(driver);
		fabhomepage = fabloginpage.loginUser(username, password);
		Assert.assertTrue(fabhomepage.getDashboardName().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
	}
}
