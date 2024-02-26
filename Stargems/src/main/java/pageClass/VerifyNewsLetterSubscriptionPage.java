package pageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
import utils.ReusableMethods;

public class VerifyNewsLetterSubscriptionPage extends TestBase{
	
	@FindBy(xpath = "//input[@placeholder='Your Email*']")private WebElement yourEmail;
	@FindBy(xpath = "//button[@type='submit' or @data-nimg='1']")private WebElement submitButton;
	@FindBy(xpath = "//div[text()='Newsletter Subscribed Successfully']")private WebElement toastMessage;
	@FindBy(xpath = "")private WebElement aaaa;
	@FindBy(xpath = "")private WebElement aaaaa;

	public VerifyNewsLetterSubscriptionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterMail() throws InterruptedException {
		ReusableMethods.scrollDown(yourEmail);
		yourEmail.sendKeys("Mukesh.Ambani@gmail.com");
		Thread.sleep(2000);
		
		submitButton.click();
	}
	
	public String verifyToastMsg() {
		return toastMessage.getText();
	}
	
	public static VerifyNewsLetterSubscriptionPage returnObj() {
		return new VerifyNewsLetterSubscriptionPage();
	}
	
}
