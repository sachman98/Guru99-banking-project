package com.qa.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.TestPages.LoginPage;
import com.qa.Utilites.Excel2D;

public class TC_GuruWeb_001 extends Baseclass {
	
	//User ID :	mngr519482
	//Password :	AjEvumE
	@Test(dataProvider = "loginData", dataProviderClass = Excel2D.class)
	public void Login(String username, String password) throws InterruptedException {
		
		LogPg =new LoginPage(driver);
		LogPg.getuserId().sendKeys(username);
		LogPg.getPassword().sendKeys(password);
		LogPg.getLoginBtn().click();
		try {
			String alert = driver.switchTo().alert().getText();
			System.out.println(alert);		
			Assert.assertNotEquals(alert, "User or Password is not valid");
		} catch (Exception e) {			
			String ManagerId=LogPg.getloginStatus().getText();
			Assert.assertEquals(ManagerId, "Manger Id : mngr519482");
		}	
		
		}
	
//	@DataProvider(name = "GuruTest")
//	public Object[][] testData() {
//
//		Object[][] data = new Object[4][2];
//
//		// 1st row
//		data[0][0] = "mngr519482";
//		data[0][1] = "AjEvumE";
//		
//		//2nd row
//		data[1][0] = "invalid";
//		data[1][1] = "AjEvumE";
//		//3rd row
//		data[2][0] = "mngr519482";
//		data[2][1] = "invalid";
//		//4th row
//		data[3][0] = "gshfhas";
//		data[3][1] = "sachpoas";
//		return data;
//	}

	

}
