package com.eCommStore.testCases;

import com.eCommStore.pageObj.*;
import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.AUTUserSteps.AUTUserSteps;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eCommStore.base.BaseClass;
import com.eCommStore.utilities.Log;
import com.relevantcodes.extentreports.LogStatus;

public class addNewCustNotUseSrchBtn_TC3 extends BaseClass
{
	LandingPageObj landingPageObj;
	LoginPageObj loginPageobj;
	DashboardPageObj dashboardPageObj;
	CustomerPageObj customerPageObj;
	AddNewCustomerPageObj addNewCustomerPageObj;
	
	@Test(groups = {"Regression"})
	public void addNewCustNotUseSrchBtn_Test() throws Throwable
	{
		landingPageObj = new LandingPageObj();
		loginPageobj = new LoginPageObj();
		dashboardPageObj = new DashboardPageObj();
		addNewCustomerPageObj = new AddNewCustomerPageObj();
		customerPageObj = new CustomerPageObj();
		
		AUTActions.LogIt(null, "************BEGIN test addNewCustNotUseSrchBtn_TC3************", "STARTTC");
			boolean bFlag = loginPageobj.isDisplayed_welcomeMsg(); //check  welcome message has been displayed
			
			if (bFlag == true)
			{
				Log.info("Wecome message is displayed.");  
			}
			else
			{
				Log.warn("Wecome message is NOT displayed.");  
			}
			
			AUTUserSteps.login_Steps(prop.getProperty("username"), prop.getProperty("password"));
			dashboardPageObj.click_customersMnuItm();
			customerPageObj.click_newBtn();
			String strEmail = AUTActions.randomestring(8)+"@gmail.com";
			addNewCustomerPageObj.type_email(strEmail);
			addNewCustomerPageObj.type_password("pword");
			String strFname = "fname"+AUTActions.randomestring(4);
			String strLname = "lname"+AUTActions.randomestring(4);
			String customerName = strFname+" "+strLname;
			addNewCustomerPageObj.type_fname(strFname);
			addNewCustomerPageObj.type_lname(strLname);
			
			addNewCustomerPageObj.click_genderType("Female");
			addNewCustomerPageObj.type_dob("11/15/2010");
			
			String strcompanyName = "companyName"+AUTActions.randomestring(4);
			addNewCustomerPageObj.type_companyName(strcompanyName);
			addNewCustomerPageObj.type_customerRoles("Registered");
			addNewCustomerPageObj.select_ManagerOfVendor("Vendor 1");
			addNewCustomerPageObj.type_adminComment("test customer");
			addNewCustomerPageObj.click_saveBtn();
			Thread.sleep(3000);
			//String[] fname_lname = customerName.split(",");
	
			AUTUserSteps.srchCustomerTablebyCol(strcompanyName, "Company Name", 5);
			test.log(LogStatus.PASS,test.addScreenCapture(AUTActions.capture(getDriver(), "CustTable")));			
			Thread.sleep(5000);
			landingPageObj.click_logoutBtn();			
			getDriver().quit(); 
		AUTActions.LogIt(null, "************END test addNewCustNotUseSrchBtn_TC3************", "ENDTC");

	}
}
