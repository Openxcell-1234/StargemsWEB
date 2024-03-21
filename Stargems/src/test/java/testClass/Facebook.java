package testClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import utils.ReadExcelFile;

public class Facebook {
	
	public static WebDriver driver;
	
	@Test
	public void Signup() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
//		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		ReadExcelFile readExcell = new ReadExcelFile("./Data/Data.xlsx");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(readExcell.getData(2, 0, 0));
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(readExcell.getData(2, 1, 0));
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(readExcell.getData(2, 2, 0));
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(readExcell.getData(2, 3, 0));
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(readExcell.getData(2, 4, 0));
		
	}

}
