package com.qa.TestPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="uid")
	WebElement userId;
	public WebElement getuserId() {
		return userId;
	}
	
	@FindBy(name="password")
	WebElement Password;
	public WebElement getPassword() {
		return Password;
	}
	
	@FindBy(name="btnLogin")
	WebElement LoginBtn;
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
	WebElement loginStatus;
	public WebElement getloginStatus() {
		return loginStatus;
	}
	public LoginPage(WebDriver rdriver) {
		this.driver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

}
