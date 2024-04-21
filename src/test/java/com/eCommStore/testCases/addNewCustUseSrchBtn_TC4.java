package com.eCommStore.testCases;

import com.eCommStore.pageObj.LoginPageObj;
import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.AUTUserSteps.AUTUserSteps;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eCommStore.pageObj.AddNewCustomerPageObj;
import com.eCommStore.pageObj.CustomerPageObj;
import com.eCommStore.pageObj.DashboardPageObj;
import com.eCommStore.pageObj.LandingPageObj;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utilities.Log;
import com.relevantcodes.extentreports.LogStatus;

public class addNewCustUseSrchBtn_TC4 extends BaseClass
{
	LandingPageObj landingPageObj;
	LoginPageObj loginPageobj;
	DashboardPageObj dashboardPageObj;
	CustomerPageObj customerPageObj;
	AddNewCustomerPageObj addNewCustomerPageObj;
	
	@Test(groups = {"Regression"})
	public void addNewCustUseSrchBtn_Test() throws Throwable
	{
		landingPageObj = new LandingPageObj();
		loginPageobj = new LoginPageObj();
		dashboardPageObj = new DashboardPageObj();
		addNewCustomerPageObj = new AddNewCustomerPageObj();
		customerPageObj = new CustomerPageObj();
		
		AUTActions.LogIt(null, "*BEGIN test addNewCustUseSrchBtn_TC4*", "STARTTC");
		
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
			addNewCustomerPageObj.type_dob("11/15/20"+AUTActions.randomeNum(2));
			
			String strcompanyName = "companyName"+AUTActions.randomestring(4);
			addNewCustomerPageObj.type_companyName(strcompanyName);
			addNewCustomerPageObj.type_customerRoles("Registered");
			addNewCustomerPageObj.select_ManagerOfVendor("Vendor 1");
			addNewCustomerPageObj.type_adminComment("test customer");
			addNewCustomerPageObj.click_saveBtn();
			Thread.sleep(3000);

			//String[] fname_lname = customerName.split(",");
			
			customerPageObj.type_srchFname(strFname);
			customerPageObj.click_srchBtn();

			Thread.sleep(1000);

			AUTUserSteps.srchCustomerTablebyCol(strEmail, "email", 2);
			test.log(LogStatus.PASS,test.addScreenCapture(AUTActions.capture(getDriver(), "srchCustomerTable")));							
			/*boolean btblFlag = UserFlows.srchCustomerTablebyCol(customerName, "Name", 3);
			if (btblFlag == true)
			{
                Log.info("Found new customer in customers table: "+customerName+" under column name: Name.");
			}
			else
			{
                Log.error("***Fail-Did NOT find new customer in customers table: "+customerName+" under column name: Name.", getDriver());
    			Assert.fail("***Fail-Did NOT find new customer in customers table: "+customerName+" under column name: Name.");
			}
			
			boolean btblFlag1 = UserFlows.srchCustomerTablebyCol(strcompanyName, "Company Name", 5);
			if (btblFlag1 == true)
			{
                Log.info("Found new customer company in customers table: "+strcompanyName+" under column name: Company Name.");
			}
			else
			{
                Log.error("***Fail-Did NOT find new customer company in customers table: "+strcompanyName+" under column name: Company Name.", getDriver());
    			Assert.fail("***Fail-Did NOT find new customer company in customers table: "+strcompanyName+" under column name: Company Name.");
			}	*/		
			Thread.sleep(8000);
			landingPageObj.click_logoutBtn();		

			getDriver().quit(); 	
		AUTActions.LogIt(null, "*END test addNewCustUseSrchBtn_TC4*", "ENDTC");
	}
}
