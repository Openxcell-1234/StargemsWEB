package pageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class VerifyForgotPasswordPage extends TestBase{
	
	@FindBy(xpath = "//a[@href= '/forgot-password']") private WebElement forgotPassword;
	
	public VerifyForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnForgotPassword() {
		forgotPassword.click();
	}
	
	public String getCurrentUrlMethod() {
		return driver.getCurrentUrl();
	}
	
	public static VerifyForgotPasswordPage objectReturn() {
		return new VerifyForgotPasswordPage();
	}

}
