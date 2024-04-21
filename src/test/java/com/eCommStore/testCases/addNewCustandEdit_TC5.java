package com.eCommStore.testCases;

import com.eCommStore.pageObj.*;
import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.AUTUserSteps.AUTUserSteps;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eCommStore.pageObj.AddNewCustomerPageObj;
import com.eCommStore.pageObj.CustomerPageObj;
import com.eCommStore.pageObj.DashboardPageObj;
import com.eCommStore.pageObj.EditCustomerPageObj;
import com.eCommStore.pageObj.LandingPageObj;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utilities.Log;
import com.relevantcodes.extentreports.LogStatus;

public class addNewCustandEdit_TC5 extends BaseClass
{
	LandingPageObj landingPageObj;
	LoginPageObj loginPageobj;
	DashboardPageObj dashboardPageObj;
	CustomerPageObj customerPageObj;
	AddNewCustomerPageObj addNewCustomerPageObj;
	EditCustomerPageObj editCustomerPageObj;
	
	@Test(groups = {"Regression"})
	public void addNewCustandEdit_Test() throws Throwable
	{
		landingPageObj = new LandingPageObj();
		loginPageobj = new LoginPageObj();
		dashboardPageObj = new DashboardPageObj();
		addNewCustomerPageObj = new AddNewCustomerPageObj();
		customerPageObj = new CustomerPageObj();
		editCustomerPageObj = new EditCustomerPageObj();
		
		AUTActions.LogIt(null, "*BEGIN test addNewCustandEdit_TC5*", "STARTTC");
			boolean bFlag = loginPageobj.isDisplayed_welcomeMsg(); //check  welcome message has been displayed
			
			if (bFlag == true)
			{
				AUTActions.LogIt(null, "Wecome message is displayed.", "PASS");	
			}
			else
			{
				AUTActions.LogIt(null, "Wecome message is NOT displayed.", "WARNING");	
			}
			
			AUTUserSteps.login_Steps(prop.getProperty("username"), prop.getProperty("password"));
			dashboardPageObj.click_customersMnuItm();
			
			Log.info("add a new customer email");  
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
			Log.info("edit the customer's email");  
				AUTUserSteps.srchandEditCustomerbyCol(strEmail, "email", 2);
				String currPageTitle = getDriver().getTitle();
				
				if (currPageTitle.equals(prop.getProperty("EditcustomerPageTitle")))
				{
					AUTActions.LogIt(null, "Page title: "+prop.getProperty("EditcustomerPageTitle")+" is displayed.", "PASS");					
				}
				else
				{
					AUTActions.LogIt(null, "Page title: "+prop.getProperty("EditcustomerPageTitle")+" is NOT displayed.", "WARNING");
				}
				
				String strEmailedit = AUTActions.randomestring(8)+"@gmail.com";
				editCustomerPageObj.type_email(strEmailedit);
				editCustomerPageObj.click_saveBtn();
				AUTUserSteps.srchCustomerTablebyCol(strEmailedit, "email", 2);
				test.log(LogStatus.PASS,test.addScreenCapture(AUTActions.capture(getDriver(), "customerUpdateinfo")));				
				Thread.sleep(5000);
				landingPageObj.click_logoutBtn();

				getDriver().quit();
			AUTActions.LogIt(null, "*END test addNewCustandEdit_TC5*", "ENDTC");
		
	}
}
