package com.eCommStore.testCases;

import com.eCommStore.pageObj.*;
import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.AUTUserSteps.AUTUserSteps;

import org.testng.annotations.Test;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utilities.Log;
import com.relevantcodes.extentreports.LogStatus;

public class Login_TC1 extends BaseClass
{

	LandingPageObj landingPageobj;
	LoginPageObj loginPageobj;
	
	@Test(groups = {"Smoke", "Regression"})
	public void LoginPage_Test() throws Throwable
	{
				
		landingPageobj=new LandingPageObj();
		loginPageobj=new LoginPageObj();

		AUTActions.LogIt(null, "*BEGIN test Login_TC1*", "STARTTC");
    		loginPageobj.isDisplayed_welcomeMsg(); //check welcome message has been displayed
			AUTUserSteps.login_Steps(prop.getProperty("username"), prop.getProperty("password"));
			test.log(LogStatus.PASS,test.addScreenCapture(AUTActions.capture(getDriver(), "Screenshot Login")));		
			landingPageobj.click_logoutBtn();
		AUTActions.LogIt(null, "*END test Login_TC1*", "ENDTC");  
	}

}
