package E2Eproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;

public class Listener extends base implements ITestListener {
	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest test;

	// making thread safe
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		

		test = extent.createTest(result.getMethod().getMethodName());
		// setting the test to local thread to avoid overidding withe other test case
		// class
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {

		// TODO Auto-generated method stub
		// test.log(Status.PASS, "test passed");
		// replacing above test object with extentest.get
		extentTest.get().log(Status.PASS, "test passed");
	}

	public void onTestFailure(ITestResult result) {

		// test.fail(result.getThrowable());
		extentTest.get().fail(result.getThrowable());

		// takeScreenshot();

		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		try {
			//pulling screenshot to report 
			extentTest.get().addScreenCaptureFromPath(takeScreenshot(testMethodName, driver),
					result.getMethod().getMethodName());
			//takeScreenshot(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		extent.flush();
		

		// TODO Auto-generated method stub

	}

}