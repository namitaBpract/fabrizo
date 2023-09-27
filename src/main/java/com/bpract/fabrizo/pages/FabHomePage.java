package com.bpract.fabrizo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.fabrizo.utilities.FabWaitUtility;

public class FabHomePage {
	WebDriver driver;
	FabWaitUtility waitutility = new FabWaitUtility();
	
	@FindBy(xpath="//div[contains(text(),\"Dashboard\")]")
	WebElement titleOfDashboard;
	
	public FabHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getDashboardName() {
		waitutility.waitForAnElement(titleOfDashboard, driver);
		String tle = titleOfDashboard.getText();
		return tle;
	}

}
