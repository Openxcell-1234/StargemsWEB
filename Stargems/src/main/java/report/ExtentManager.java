package report;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.ReusableMethods;

public class ExtentManager {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void onStart() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String repName = "Test-Report " + timeStamp + ".html";
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./Reports/" + repName);
		sparkReporter.config().setDocumentTitle("WebAutomation");
		sparkReporter.config().setReportName("OpenXcell Technolabs");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Stargems");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Amar");
		
	}
	
	public static void onTestSuccess(String methodName) {
		test = extent.createTest(methodName).createNode(methodName);
		
	}
	
	public static void onTestPass(String msg) {
		Markup m = MarkupHelper.createLabel(msg , ExtentColor.GREEN);
		test.log(Status.PASS, m);
		
	}
	
	public static void onTestFailure(String msg) {
		test.addScreenCaptureFromBase64String(ReusableMethods.screenShot());
		Markup m = MarkupHelper.createLabel(msg + " is failed due to below reason", ExtentColor.RED);
		test.log(Status.FAIL, m);
	}
	
	public static void onTestSkipped(String msg) {
		Markup m = MarkupHelper.createLabel(msg + " is skipped", ExtentColor.ORANGE);
		test.log(Status.SKIP, m);
	}
	
	public static void onFlush() {
		extent.flush();
	}

}
