package com.bpract.fabrizo.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.fabrizo.pages.FabHomePage;
import com.bpract.fabrizo.pages.FabRegisterPage;
import com.bpract.fabrizo.utilities.ExcelDataProvider;

public class FabRegisterTest extends FabTestHelper{
	FabRegisterPage fabregisterpage;
	FabHomePage fabhomepage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
		
	}
	
	@DataProvider(name="ValidRegister")
	public Object[][]getData(){
		String excelpath = "C:\\Users\\namit\\OneDrive\\Desktop\\Namita\\register data.xlsx";
		ExcelDataProvider exceldataprovider = new ExcelDataProvider();
		Object data[][] = exceldataprovider.testData(excelpath, "Sheet1");
		return data;
	}
	
//	@Test(dataProvider="ValidRegister")
	public void verifyRegisterWithValidData(String email, String username, String password, String repassword, String referral) {
		fabregisterpage = new FabRegisterPage(driver);
		fabregisterpage.register(email, username, password, repassword, referral);
		fabhomepage = new FabHomePage(driver);
		Assert.assertTrue(fabhomepage.getDashboardName().contains("Dashboard"));
		Reporter.log("Register Successfull!", true);
	}
	
	@Test
	public void verifyRegisterWithBlankData() {
		fabregisterpage = new FabRegisterPage(driver);
		fabregisterpage.register("", "", "", "", "");
		Assert.assertTrue(fabregisterpage.getEmailRequiredMsg().contains("Email is required"));
		Reporter.log("Email Required Msg found!", true);
		Assert.assertTrue(fabregisterpage.getUsernameRequiredMsg().contains("User Name is required"));
		Reporter.log("Username Required Msg found!", true);
		Assert.assertTrue(fabregisterpage.getPasswordRequiredMsg().contains("Password must be at least 8 characters"));
		Reporter.log("Password Required Msg found!", true);
		Assert.assertTrue(fabregisterpage.getReferralRequiredMsg().contains("Referral ID is required"));
		Reporter.log("Referral ID Required Msg found!", true);
	}

}
