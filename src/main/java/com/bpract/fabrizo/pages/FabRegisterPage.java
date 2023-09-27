package com.bpract.fabrizo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.fabrizo.utilities.FabWaitUtility;

public class FabRegisterPage {
	WebDriver driver;
	FabWaitUtility fabwaitutility = new FabWaitUtility();
	
	@FindBy(name="email")
	WebElement emailID;
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="repassword")
	WebElement repassword;
	@FindBy(name="referral")
	WebElement referralID;
	@FindBy(name="register")
	WebElement registerButton;
	@FindBy(xpath="//p[contains(text(), \"Email is required\")]")
	WebElement emailRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"User Name is required\")]")
	WebElement usernameRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Password must be at least 8 characters\")]")
	WebElement passwordRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Referral ID is required\")]")
	WebElement referralRequiredMsg;
	
	public FabRegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailID(String strEmailID) {
		fabwaitutility.waitForAnElement(emailID, driver);
		emailID.sendKeys(strEmailID);
	}
	public void enterUsername(String strUsername) {
		username.sendKeys(strUsername);
	}
	public void enterPassword(String strPassword) {
		password.sendKeys(strPassword);
	}
	public void enterRepassword(String strRepassword) {
		repassword.sendKeys(strRepassword);
	}
	public void enterReferralID(String strReferralID) {
		referralID.sendKeys(strReferralID);
	}
	public void clickRegisterButton() {
		registerButton.click();
	}
	public void register(String strEmailID, String strUsername, String strPassword, String strRepassword, String strReferralID) {
		this.enterEmailID(strEmailID);
		this.enterUsername(strUsername);
		this.enterPassword(strPassword);
		this.enterRepassword(strRepassword);
		this.enterReferralID(strReferralID);
		this.clickRegisterButton();
	}
	
	public String getEmailRequiredMsg() {
		fabwaitutility.waitForAnElement(emailRequiredMsg, driver);
		String emailRequiredMsgText = emailRequiredMsg.getText();
		return emailRequiredMsgText;
	}
	public String getUsernameRequiredMsg() {
		fabwaitutility.waitForAnElement(usernameRequiredMsg, driver);
		String usernameRequiredMsgText = usernameRequiredMsg.getText();
		return usernameRequiredMsgText;
	}
	public String getPasswordRequiredMsg() {
		fabwaitutility.waitForAnElement(passwordRequiredMsg, driver);
		String passwordRequiredMsgText = passwordRequiredMsg.getText();
		return passwordRequiredMsgText;
	}
	public String getReferralRequiredMsg() {
		fabwaitutility.waitForAnElement(referralRequiredMsg, driver);
		String referralRequiredMsgText = referralRequiredMsg.getText();
		return referralRequiredMsgText;
	}
}
