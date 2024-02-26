package testClass;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.CMSRegisterAccountpage;
import pageClass.VerifyAndDeleteRegisteredAccountPage;
import report.ExtentManager;

public class VerifyAndDeleteRegisteredAccountTest extends BeforeAfterTest{
	
	@Test
	public void verifyAndDeleteRegisteredAccountMethod() throws Exception {
		VerifyAndDeleteRegisteredAccountPage verAndDelRegAcc = VerifyAndDeleteRegisteredAccountPage.objectReturn();
		Thread.sleep(1000);
		Thread.sleep(1000);
		
		verAndDelRegAcc.clickOnUserIcon();
		ExtentManager.onTestPass("User icon clicked successfully");
		Thread.sleep(1000);
		
		verAndDelRegAcc.clickOnSignup();
		ExtentManager.onTestPass("Signup button clicked successfully");
		Thread.sleep(10000);
		
		verAndDelRegAcc.enterFields();
		ExtentManager.onTestPass("Create Account clicked successfully");
		Thread.sleep(20000);
		
		String expectedUrl = "https://stargems-frontend.apps.openxcell.dev/login";
		String actualUrl = verAndDelRegAcc.getCurrntUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		ExtentManager.onTestPass("Account created successfully");
		
		if(expectedUrl.equals(actualUrl)) {
			driver.get("https://stargems-cms.openxcell.dev/signin");
			driver.manage().window().maximize();
			ExtentManager.onTestPass("Stargems-CMS launched successfully");
			
			Thread.sleep(1000);
			CMSRegisterAccountpage cmspage= CMSRegisterAccountpage.returnObj();
			cmspage.loggedIn();
			ExtentManager.onTestPass("Entered valid credentials and logged in CMS successfully");
			
//			Thread.sleep(20000);
			
			cmspage.clickBuyerManagement();
			ExtentManager.onTestPass("Buyer Management clicked successfully");
			
			Thread.sleep(10000);
			
			List<String> expectedText = expectedNameAndEmail();
			List<String> actualText = cmspage.getNameAndEmail();
			Assert.assertEquals(expectedText, actualText);
			ExtentManager.onTestPass("Verified created account successfully");
			
			if(expectedText.equals(actualText)) {
				cmspage.clickDeleteButton();
				ExtentManager.onTestPass("Created account deleted successfully");
			}
		}
	}
	
	private List<String> expectedNameAndEmail(){
		List<String> expectedText = new ArrayList<String>();
		expectedText.add("Anand Mahindra");
		expectedText.add("mahindra@gmail.com");
		
		return expectedText;
	}


}
