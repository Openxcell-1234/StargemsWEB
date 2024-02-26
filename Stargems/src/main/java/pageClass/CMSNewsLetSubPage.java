package pageClass;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utils.ReusableMethods;

public class CMSNewsLetSubPage extends TestBase{
	
	@FindBy(xpath = "//input[@placeholder='Username']")private WebElement email;
	@FindBy(xpath = "//input[@placeholder='Password']")private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")private WebElement signinBtn;
	@FindBy(xpath = "//a[@href='/admin/newsLetter']")private WebElement newLetter;
	@FindBy(xpath = "//tbody//tr[@class='ant-table-row ant-table-row-level-0'][1]/td[2]")private WebElement newEmail;
	@FindBy(xpath = "//tr[@class='ant-table-row ant-table-row-level-0'][1]/td[1]//span[2]/*")private WebElement deleteIcon;
	@FindBy(xpath = "//button/span[text()='Yes']")private WebElement yesButton;
	
	public CMSNewsLetSubPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void loggedIn() {
		email.click();
		email.sendKeys("nisharg.shah@openxcell.com");
		
//		ReusableMethods.alertPopupMethod();
		ReusableMethods.coordinatesClick(0, 0);
		
		password.click();
		password.sendKeys("nisharg");
		
		signinBtn.click();
	}
	
	public void verifyAndDeleteNewMail() throws InterruptedException {
		newEmail.getText();
		Thread.sleep(1000);
		
		deleteIcon.click();
		Thread.sleep(2000);
		
		yesButton.click();
		Thread.sleep(1000);
	}
	
	public void clickNewsLetterManagement() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(newLetter)).click();
	}
	
	public static CMSNewsLetSubPage returnObj() {
		return new CMSNewsLetSubPage();
	}

}
