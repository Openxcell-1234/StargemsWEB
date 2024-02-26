package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class ReusableMethods extends TestBase{
	
	public static void dropDown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void alertPopupMethod() {
		driver.switchTo().alert();
		driver.close();
	}
	
	public static void coordinatesClick(int x, int y) {
		new Actions(driver).moveByOffset(x , y).click().build().perform(); 
	}
	
	public static String screenShot() {
		
		String screenShotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return screenShotBase64;
	}
	
	public static String ReadExcell(String name, int row, int col) throws Exception, IOException {
		
		FileInputStream file = new FileInputStream("./Data/Data.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet(name);
		
		return excel.getRow(row).getCell(col).getStringCellValue();
		
	}

}
