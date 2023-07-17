/**
 * 
 */
package UtilityFile;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

/**This class is use to generates the extent reports on failures and attached a screenshot to the report
 * @author kpkmt942
 *
 */
public class ExtentReportManager implements ITestListener {
	


	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods
	
	String repName;

	public void onStart(ITestContext context) 
	{
		
	String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"). format (new Date());
	
	repName = "Test-Report-" + timestamp + ".html";
		

			
		sparkReporter=new ExtentSparkReporter(".\\Reports\\" +  repName);//specify location of the report
		
		sparkReporter.config().setDocumentTitle("Automation Test Report"); // TiTle of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","Kiran");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");
					
	}


	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); // create a new entry in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		
	}

	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
		
	
		
		try {
			String	imgpath = new BaseClass().CapctureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
					
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		test.log(Status.SKIP, "Test Case SKIPPED cause is: " + result.getThrowable()); 
		
	}

	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
		



}
