package com.eCommStore.testCases;

import com.eCommStore.pageObj.LoginPageObj;
import com.eCommStore.pageObj.ProductsPageObj;
import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.AUTUserSteps.AUTUserSteps;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.eCommStore.pageObj.AddNewProductPageObj;
import com.eCommStore.pageObj.AddNewCustomerPageObj;
import com.eCommStore.pageObj.CustomerPageObj;
import com.eCommStore.pageObj.DashboardPageObj;
import com.eCommStore.pageObj.EditCustomerPageObj;
import com.eCommStore.pageObj.LandingPageObj;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utilities.Log;
import com.relevantcodes.extentreports.LogStatus;


public class downloadPrdCatalog_TC6 extends BaseClass
{
	LandingPageObj landingPageObj;
	LoginPageObj loginPageobj;
	DashboardPageObj dashboardPageObj;
	CustomerPageObj customerPageObj;
	AddNewCustomerPageObj addNewCustomerPageObj;
	EditCustomerPageObj editCustomerPageObj;
	ProductsPageObj productsPageObj;
	AddNewProductPageObj addNewProductPageObj;
	
	@Test(groups = {"Regression"})
	public void downloadPrdCatalog_Test() throws Throwable
	{
		landingPageObj = new LandingPageObj();
		loginPageobj = new LoginPageObj();
		dashboardPageObj = new DashboardPageObj();
		addNewCustomerPageObj = new AddNewCustomerPageObj();
		customerPageObj = new CustomerPageObj();
		editCustomerPageObj = new EditCustomerPageObj();
		productsPageObj = new  ProductsPageObj();
		addNewProductPageObj = new  AddNewProductPageObj();
		
		//ElementActions.LogIt(null, "*BEGIN test "+ElementActions.getMethodName(2)+"*", "STARTTC");

			AUTActions.cleanFolder(prop.getProperty("fileDownLoadLocation")); //delete any files in the download folder
			
			//check  welcome message has been displayed
			Assert.assertEquals(loginPageobj.isDisplayed_welcomeMsg(), true);
			AUTUserSteps.login_Steps(prop.getProperty("username"), prop.getProperty("password"));
			dashboardPageObj.click_productsMnuItm();
			productsPageObj.click_addNewPrdBtn();
			String strprdName = "zzTestPrd"+AUTActions.randomestring(4);
			addNewProductPageObj.type_prdName(strprdName);
			addNewProductPageObj.type_shortDescritpion("test product");
			addNewProductPageObj.click_saveBtn();
			
			test.log(LogStatus.INFO,test.addScreenCapture(AUTActions.capture(getDriver(), "PrdAdded"))+ "Product Added");	
			//test.log(LogStatus.INFO,test.addScreenCapture(ElementActions.capture1(getDriver()))+ "added product");	
			
			AUTActions.LogIt(null, "*Begin downloadandverifyPDF test steps*", "INFO");
			
				AUTUserSteps.downloadandverifyPDF(strprdName, prop.getProperty("expectedFile_PDF"));
	 
			AUTActions.LogIt(null, "*End downloadandverifyPDF test steps*", "INFO");
	
			//getDriver().quit();
		//ElementActions.LogIt(null, "*END test downloadPrdCatalog_Test*", "ENDTC");
		
	}
}
