package com.bpract.fabrizo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FabLoginPage {
	WebDriver driver;
	
	@FindBy(name="email")
	WebElement emailidLogin;
	@FindBy(name="password")
	WebElement passwordLogin;
	@FindBy(name="remember")
	WebElement rememberme;
	@FindBy(name="login")
	WebElement loginButton;
	@FindBy(xpath="/html/head/title")
	WebElement titleOfPage;
	
	public FabLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailId(String strEid) {
		emailidLogin.sendKeys(strEid);
	}
	public void enterPassword(String strPwd) {
		passwordLogin.sendKeys(strPwd);
	}
	public void checkRememberMe() {
		rememberme.click();
	}
	
	public String pageTitle() {
		return titleOfPage.getText();
	}
	public FabHomePage loginUser(String strEid, String strPwd) {
		this.enterEmailId(strEid);
		this.enterPassword(strPwd);
		this.loginButton.click();
		return new FabHomePage(driver);
	}
	
}
