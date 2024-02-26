package pageClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utils.ReusableMethods;

public class CMSRegisterAccountpage extends TestBase {
	
	@FindBy(xpath = "//input[@placeholder='Username']")private WebElement email;
	@FindBy(xpath = "//input[@placeholder='Password']")private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")private WebElement signinBtn;
	@FindBy(xpath = "//a[@href='/admin/buyers']")private WebElement BuyerManagement;
	@FindBy(xpath = "(//tr[@class='ant-table-row ant-table-row-level-0'])[1]/td[position()=2 or position()=3]")private List<WebElement> nameAndEmail;
	@FindBy(xpath = "//p[text()='Anand Mahindra']/parent::td/preceding-sibling::td//span[4]")private WebElement deleteButton;
	@FindBy(xpath = "//button/span[text()='Yes']")private WebElement yesButton;
	
	
	
	public CMSRegisterAccountpage() {
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
	
	public void clickBuyerManagement() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(BuyerManagement)).click();
	}
	
	public List<String> getNameAndEmail(){
		List<WebElement> elements = nameAndEmail;
		List<String> actualText = new ArrayList<String>();
		for(int i = 0; i<elements.size();i++) {
			String text = elements.get(i).getText();
			actualText.add(text);
		}
		
		return actualText;
	}
	
	public void clickDeleteButton() throws InterruptedException {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
		Thread.sleep(2000);
		
		yesButton.click();
		Thread.sleep(1000);
	}
	
	public static CMSRegisterAccountpage returnObj() {
		return new CMSRegisterAccountpage();
	}

}
