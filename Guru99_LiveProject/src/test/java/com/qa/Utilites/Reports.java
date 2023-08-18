package com.qa.Utilites;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports extends TestListenerAdapter{

	public ExtentSparkReporter htmlReport;
	public ExtentReports xReport;
	public ExtentTest xTest;
	
	@BeforeTest
	public void onStart(ITestContext testContext) {
		String dateStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Automation-Report-"+dateStamp+".html";
		
		htmlReport= new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+repName);
		htmlReport.config().setDocumentTitle("Test automation Report");
		htmlReport.config().setReportName("Guru banking live project");
		htmlReport.config().setTheme(Theme.DARK);
		
		xReport=new ExtentReports();
		xReport.attachReporter(htmlReport);
		xReport.setSystemInfo("QA name ","Sachit M");
		xReport.setSystemInfo("OS", "Windows10");
		xReport.setSystemInfo("hostName", "localHost");
		
	}
	
	@AfterTest
	public void onFinish(ITestContext testContext) {
		xReport.flush();
	}
	
	@AfterSuite
	public void onTestSuccess(ITestResult tr) {
		xTest= xReport.createTest(tr.getName());
		xTest.log(Status.PASS,"Test is passed");
		xTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	@AfterSuite
	public void onTestFailure(ITestResult tr) {
		xTest= xReport.createTest(tr.getName());
		xTest.log(Status.PASS,"Test is failed");
		xTest.log(Status.FAIL, tr.getThrowable());
		xTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		//code for screenshot
		
		String ssPath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		File file = new File(ssPath);
		if (file.exists()) {
			xTest.fail("Screen shot of the test failed is : "+ xTest.addScreenCaptureFromPath(ssPath));
						
		}
}
	
	@AfterSuite
	public void onTestSkipped(ITestResult tr) {
		xTest= xReport.createTest(tr.getName());
		xTest.log(Status.PASS,"Test is skipped");
		xTest.log(Status.FAIL, tr.getThrowable());
		xTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
	}
	
}