package pageClass;

import java.io.IOException;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
import utils.ReusableMethods;

public class VerifyAndDeleteRegisteredAccountPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='MuiBox-root css-ob8obk']//a[@href='/login']") private WebElement userIcon;
	@FindBy(xpath = "//a[@href='/register']")private WebElement signup;
	@FindBy(xpath = "//input[@placeholder='Company Name*']")private WebElement companyName;
	@FindBy(xpath = "//input[@placeholder='Contact Person Name*']")private WebElement personName;
	@FindBy(xpath = "//input[@placeholder='Registered Address Line1*']")private WebElement addressLine1;
	@FindBy(xpath = "//input[@placeholder='Registered Address Line2*']")private WebElement addressLine2;
	@FindBy(xpath = "(//div[@role='combobox'])[1]")private WebElement country;
	@FindBy(xpath = "//li[@data-value='IN']")private WebElement countryEle;
	@FindBy(xpath = "(//div[@role='combobox'])[2]")private WebElement state;
	@FindBy(xpath = "//li[@data-value='MH']")private WebElement stateEle;
	@FindBy(xpath = "(//div[@role='combobox'])[3]")private WebElement city;
	@FindBy(xpath = "//li[@data-value='Mumbai']")private WebElement cityEle;
	@FindBy(xpath = "//input[@placeholder='Zipcode*']")private WebElement zipcode;
	@FindBy(xpath = "//input[@placeholder='Phone Number*']")private WebElement phoneNumber;
	@FindBy(xpath = "//input[@placeholder='Mobile Number*']")private WebElement mobileNumber;
	@FindBy(xpath = "//input[@placeholder='Email*']")private WebElement emailId;
	@FindBy(xpath = "//input[@placeholder='Password*']")private WebElement password;
	@FindBy(xpath = "//input[@placeholder='Website*']")private WebElement website;
	@FindBy(xpath = "//button[@type='submit']")private WebElement createAccount;
	
	
	public VerifyAndDeleteRegisteredAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnUserIcon() {
		userIcon.click();
	}
	
	public void clickOnSignup() {
		signup.click();
	}
	
	public void enterFields() throws Exception, Exception {
//		Thread.sleep(2000);
//		companyName.click();
		Thread.sleep(2000);
		companyName.sendKeys(ReusableMethods.ReadExcell("Sheet2", 0, 0));//"Mahindra And Mahindra"
		personName.sendKeys(ReusableMethods.ReadExcell("Sheet2", 1, 0));//"Anand Mahindra"
		addressLine1.sendKeys(ReusableMethods.ReadExcell("Sheet2", 2, 0));//"5, Samarth Banglow"
		addressLine2.sendKeys(ReusableMethods.ReadExcell("Sheet2", 3, 0));//"Mumbai"
		
		Thread.sleep(2000);
		country.click();
		ReusableMethods.scrollDown(countryEle);
		Thread.sleep(1000);
		countryEle.click();
		
		Thread.sleep(2000);
		state.click();
		ReusableMethods.scrollDown(stateEle);
		Thread.sleep(1000);
		stateEle.click();
		
		Thread.sleep(2000);
		city.click();
		ReusableMethods.scrollDown(cityEle);
		Thread.sleep(1000);
		cityEle.click();
		
		Thread.sleep(2000);
		zipcode.sendKeys(ReusableMethods.ReadExcell("Sheet2", 4, 0));//"422000"
		phoneNumber.sendKeys(ReusableMethods.ReadExcell("Sheet2", 5, 0));//"1234567890"
		mobileNumber.sendKeys(ReusableMethods.ReadExcell("Sheet2", 6, 0));//"1232654500"
		emailId.sendKeys(ReusableMethods.ReadExcell("Sheet2", 7, 0));//"mahindra@gmail.com"
		password.sendKeys(ReusableMethods.ReadExcell("Sheet2", 8, 0));//"mahindra@123"
		website.sendKeys(ReusableMethods.ReadExcell("Sheet2", 9, 0));//"https://www.amazon.com/"
		createAccount.click();
	}
	
	public String getCurrntUrl() {
		return driver.getCurrentUrl();
	}
	
	public static VerifyAndDeleteRegisteredAccountPage objectReturn() {
		return new VerifyAndDeleteRegisteredAccountPage();
	}

}
