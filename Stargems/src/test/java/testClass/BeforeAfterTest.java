package testClass;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import report.ExtentManager;
import testBase.TestBase;

public class BeforeAfterTest extends TestBase{
	
	@BeforeSuite
	public void beforeSuite() {
		ExtentManager.onStart();
	}
	
	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		ExtentManager.onTestSuccess(result.getMethod().getMethodName());
		prerequisite();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			ExtentManager.onTestFailure(result.getMethod().getMethodName());
			Assert.fail(result.getThrowable().getMessage());
		}else if(result.getStatus() == ITestResult.SKIP) {
			ExtentManager.onTestSkipped(result.getMethod().getMethodName());
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			
		}
		
		driver.close();
	}
	
	@AfterSuite
	public void  afterSuite() {
		ExtentManager.onFlush();
	}

}
