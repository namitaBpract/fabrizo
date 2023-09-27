package com.bpract.fabrizo.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;

public class FabTestHelper {
	WebDriver driver;

	public WebDriver lauchBrowser(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			/*WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("start-maximised");
			driver = new FirefoxDriver(options); */
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new EdgeDriver(options);
			driver.manage().window().maximize();
		}
//		driver.get("https://fabrizo.cloudmlmdemo.com/auth/login");
		driver.get("https://fabrizo.cloudmlmdemo.com/auth/register");
		
	return driver;
	}
	
//	@AfterMethod
	public void closeBrowser() {
	driver.close();
	}
}
