package testClass;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.CMSNewsLetSubPage;
import pageClass.VerifyNewsLetterSubscriptionPage;
import report.ExtentManager;

public class VerifyNewsLetterSubscriptionTest extends BeforeAfterTest{
	
	@Test
	public void verifyNewsLetterSubscriptionMethod() throws InterruptedException {
		VerifyNewsLetterSubscriptionPage NewsLetSub = VerifyNewsLetterSubscriptionPage.returnObj();
		NewsLetSub.enterMail();
		ExtentManager.onTestPass("Entered email and clicked on Submit button successfully");
		Thread.sleep(3000);
		
		String expectedMsg = "Newsletter Subscribed Successfully";
		String actualMsg = NewsLetSub.verifyToastMsg();
		AssertJUnit.assertEquals(expectedMsg, actualMsg);
		ExtentManager.onTestPass("Verified toast message successfully");
		
		if(expectedMsg.equals(actualMsg)) {
			driver.get("https://stargems-cms.openxcell.dev/signin");
			driver.manage().window().maximize();
			ExtentManager.onTestPass("Stargems-CMS launched successfully");
			Thread.sleep(1000);
			Thread.sleep(1000);
			
			
			CMSNewsLetSubPage cmsNewLetSub = CMSNewsLetSubPage.returnObj();
			cmsNewLetSub.loggedIn();
			ExtentManager.onTestPass("Entered valid credentials and logged in CMS successfully");
			
			cmsNewLetSub.clickNewsLetterManagement();
			Thread.sleep(5000);
			ExtentManager.onTestPass("Clicked on 'News Letter Management' successfully");
			
			cmsNewLetSub.verifyAndDeleteNewMail();
			ExtentManager.onTestPass("Verified and deleted New email successfully");
		}
		
		
		
		
	}

}
