package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.VerifyAndDeleteRegisteredAccountPage;
import pageClass.VerifyForgotPasswordPage;


public class VerifyForgotPasswordUrlTest extends BeforeAfterTest{
	
	@Test
	public void VerifyForgotPasswordUrlTestMethod() {
		VerifyAndDeleteRegisteredAccountPage homePageObj = VerifyAndDeleteRegisteredAccountPage.objectReturn();
		homePageObj.clickOnUserIcon();
		VerifyForgotPasswordPage objForgorPwd = VerifyForgotPasswordPage.objectReturn();
		objForgorPwd.clickOnForgotPassword();
		
		String actualUrl = objForgorPwd.getCurrentUrlMethod();
		String expectedUrl = "https://stargems-frontend.apps.openxcell.dev/forgot-password";
		Assert.assertEquals(actualUrl, expectedUrl);
	}

}
