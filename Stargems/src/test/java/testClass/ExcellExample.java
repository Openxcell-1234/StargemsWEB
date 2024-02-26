package testClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelFile;

public class ExcellExample {
	
	WebDriver driver;

	@Test (dataProvider="testdata")
	public void demoClass(String username, String password) throws InterruptedException {
//	System.setProperty("webdriver.chrome.driver", "Path of Chrome Driver");
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	option.addArguments("--disable-notifications");
//	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(option);
	driver.get("<a href='https://www.browserstack.com/users/sign_in</a>'");
	driver.findElement(By.name("user[login]")).sendKeys(username);
	driver.findElement(By.name("user[password]")).sendKeys(password);
	driver.findElement(By.name("commit")).click();
	Thread.sleep(5000);
	//AssertJUnit.assertTrue(driver.getTitle().matches("BrowserStack Login | Sign Into The Best Mobile & Browser Testing Tool"), "Invalid credentials");
	System.out.println("Login successful");
	}

//	@AfterMethod
//	void ProgramTermination() {
//		driver.quit();
//	}
//
	@DataProvider(name = "testdata")
	public Object[][] testDataExample() {
		ReadExcelFile configuration = new ReadExcelFile("./Data/Data.xlsx");
		int rows = configuration.getRowCount(0);
		Object[][] signin_credentials = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			signin_credentials[i][0] = configuration.getData(0, i, 0);
			signin_credentials[i][1] = configuration.getData(0, i, 1);
		}
		return signin_credentials;
	}

}
