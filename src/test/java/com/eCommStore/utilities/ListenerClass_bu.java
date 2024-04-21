package com.eCommStore.utilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.eCommStore.AUTActions.AUTActions;
//import com.WebShopDemo.base.BaseClass;
import com.eCommStore.base.BaseClass;


public class ListenerClass_bu extends ExtentManager implements ITestListener {

	AUTActions action= new AUTActions();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		System.out.println("onTestStart");
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is: " + result.getName());
		}
		System.out.println("onTestSuccess");
	}

	/*public void onTestFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			System.out.println("extent fail");
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String imgPath = ElementActions.screenShot(BaseClass.getDriver(), result.getName());
			System.out.println(imgPath);
			//ActionDriver.screenShot(BaseClass.getDriver(), "Failed-"+result.getName());
			try {
				test.fail("ScreenShot is attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
}
