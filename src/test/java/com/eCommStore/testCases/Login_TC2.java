package com.eCommStore.testCases;

import com.eCommStore.pageObj.*;
import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.AUTUserSteps.AUTUserSteps;

import org.testng.annotations.Test;

import com.eCommStore.base.BaseClass;
import com.eCommStore.utilities.Log;
import com.relevantcodes.extentreports.LogStatus;

public class Login_TC2 extends BaseClass
{

	LandingPageObj landingPageobj;
	LoginPageObj loginPageobj;
	
	@Test(groups = {"Smoke", "Regression"})
	public void LoginPage_Test() throws Throwable
	{
				
		landingPageobj=new LandingPageObj();
		loginPageobj=new LoginPageObj();

		AUTActions.LogIt(null, "*BEGIN test Login_TC2*", "STARTTC");
			//check welcome message has been displayed
			if (loginPageobj.isDisplayed_welcomeMsg())
			{
				AUTActions.LogIt(null, "Wecome message is displayed.", "PASS");	
			}
			else
			{
				AUTActions.LogIt(null, "Wecome message is NOT displayed.", "WARNING");					
			}
			AUTUserSteps.login_Steps(prop.getProperty("username"), "tet");
			//check  login error message has been displayed
			if (loginPageobj.isDisplayed_loginMsgErrorMsg())
			{
				AUTActions.LogIt(null, "login error message is displayed.", "PASS");	
			}
			else
			{
				AUTActions.LogIt(null, "login error message is NOT displayed.", "WARNING");	
			}
			test.log(LogStatus.PASS,test.addScreenCapture(AUTActions.capture(getDriver(),"loginErMsg")));	
			getDriver().quit();
		AUTActions.LogIt(null, "*END test Login_TC2*", "ENDTC");			
			
	}

}
