package com.qa.TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import com.qa.TestPages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	WebDriver driver;
	LoginPage LogPg;
	String baseURL="https://clicks.aweber.com/y/ct/?l=DTNayn&m=mqr21DGG7WFEjy9&b=ftyRAGqn86J.zqoUqwX_JA";
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		LogPg =new LoginPage(driver);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	
	@AfterSuite
	public void finish() {
		driver.close();
	}

}
