package com.eCommStore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.AUTUserSteps.AUTUserSteps;
import com.eCommStore.base.BaseClass;
import com.eCommStore.pageObj.AddNewCustomerPageObj;
import com.eCommStore.pageObj.AddNewProductPageObj;
import com.eCommStore.pageObj.CustomerPageObj;
import com.eCommStore.pageObj.DashboardPageObj;
import com.eCommStore.pageObj.EditCustomerPageObj;
import com.eCommStore.pageObj.LandingPageObj;
import com.eCommStore.pageObj.LoginPageObj;
import com.eCommStore.pageObj.ProductsPageObj;
import com.relevantcodes.extentreports.LogStatus;

public class downloadCatFile_TC7 extends BaseClass
{
	LoginPageObj loginPageobj;
	DashboardPageObj dashboardPageObj;
	LandingPageObj landingPageObj;
	ProductsPageObj productsPageObj;

	
	@Test(groups = {"Regression"})
	public void downloadCatFile_test() throws Throwable
	{
		loginPageobj = new LoginPageObj();
		dashboardPageObj = new DashboardPageObj();
		landingPageObj = new LandingPageObj();
		productsPageObj = new  ProductsPageObj();
		
		AUTActions.cleanFolder(prop.getProperty("fileDownLoadLocation")); //delete any files in the download folder

		//check  welcome message has been displayed
		Assert.assertEquals(loginPageobj.isDisplayed_welcomeMsg(), true);
		AUTUserSteps.login_Steps(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPageObj.click_productsMnuItm();
		
		AUTActions.LogIt(null, "*Begin download PDF file*", "INFO");
		
			productsPageObj.click_downloadPDFBtn();

			AUTActions.checkForFileDownload(prop.getProperty("fileDownLoadLocation"), "pdfcatalog.pdf");
			
			landingPageObj.click_logoutBtn(); //log out once file has been downloaded
 
		AUTActions.LogIt(null, "*End download PDF file*", "INFO");

		getDriver().quit();

		
	}
}
