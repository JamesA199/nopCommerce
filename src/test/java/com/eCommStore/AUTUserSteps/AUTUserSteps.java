package com.eCommStore.AUTUserSteps;

import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utilities.Log;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.eCommStore.pageObj.*;
//import com.eCommStore.UserFlows.UserFlows;



public class AUTUserSteps extends BaseClass
{
	static LoginPageObj loginPageobj;
	static CustomerPageObj customerPageObj;
	static LandingPageObj landingPageObj;
	static DashboardPageObj dashboardPageObj;
	static AddNewCustomerPageObj addNewCustomerPageObj;
	static EditCustomerPageObj editCustomerPageObj;
	static ProductsPageObj productsPageObj;
	static AddNewProductPageObj addNewProductPageObj;	
	
	
	public static void tab_UserMethods(Boolean bcloseTabFlag, int itabIndex, String strtabTitle)
	{
		
		AUTActions.switchTabs(itabIndex, strtabTitle); //switch to the page and give it focus.	
	
		if (bcloseTabFlag == true)
		{
			AUTActions.closeBrsTab(1, prop.getProperty("LoginPageTitle"));
		}
	}
	
	public static void login_Steps(String uname, String pword) throws Throwable
	{
		loginPageobj=new LoginPageObj();
		
		loginPageobj.type_userName(uname);
		loginPageobj.type_pWord(pword);
		loginPageobj.click_LoginBtn();
	
	}
	
	public static boolean srchCustomerByName(String strName)
	{
		customerPageObj=new CustomerPageObj();
		
        boolean bflag = false;
        System.out.println("rows "+customerPageObj.getNoOfRows());
        for(int i=1;i<customerPageObj.getNoOfRows() + 1;i++)
        {
            System.out.println("start");
            WebElement table = getDriver().findElement(By.xpath ("//table[@id='customers-grid']"));
            System.out.println("WebElement" +table);
            String nameId = table.findElement(By.xpath ("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]")).getText();
            if (strName.equals(nameId))
            {
     			AUTActions.LogIt(null, "Found email in customers table in row " + i + ": " + nameId, "PASS");
                bflag = true;
                break;
            }

        }
		if (bflag == false)
		{
 			AUTActions.LogIt(null, "***Fail-Did NOT find name: "+strName+" in customer table.", "FAIL");
		}
        return bflag;		

	}
	public static boolean srchCustomerByEmail(String strEmail)
	{
		customerPageObj=new CustomerPageObj();
		
        boolean bflag = false;
    			
        for(int i=1;i<customerPageObj.getNoOfRows();i++)
        {
        	
            WebElement table = getDriver().findElement(By.xpath ("//*[@id='customers-grid']"));
            String emailId = table.findElement(By.xpath ("//*[@id='customers-grid']/tbody/tr['" + i + "']/td[2]")).getText();
            if (strEmail.equals(emailId))
            {
     			AUTActions.LogIt(null, "Found email in customers table in row " + i + ": " + emailId, "PASS");
                bflag = true;
                break;
            }

        }
		if (bflag == false)
		{
 			AUTActions.LogIt(null, "***Fail-Did NOT find email: "+strEmail+" in customer table.", "FAIL");
		}
        return bflag;		

	}

	public static boolean srchCustomerTablebyCol(String strSrchData, String strcolName, int icolIndex)
	{
		customerPageObj=new CustomerPageObj();
		
        boolean bflag = false;
        AUTActions.LogIt(null, "Looking for customer data: "+strSrchData+" under column name: "+strcolName, "INFO");
        for(int irow=1;irow < customerPageObj.getNoOfRows() + 1;irow++)
        {
            WebElement table = getDriver().findElement(By.xpath ("//table[@id='customers-grid']"));
            String strSrchResults = table.findElement(By.xpath ("//table[@id='customers-grid']/tbody/tr[" + irow + "]/td[" + icolIndex + "]")).getText();
            //Log.info("Found this..."+strSrchResults+" under column name: "+strcolName+" in row: " + irow);
            if (strSrchData.equals(strSrchResults))
            {
                //Log.info("Found "+strSrchData+" under column name: "+strcolName+" in row: " + irow);
     			AUTActions.LogIt(null, "Found "+strSrchData+" under column name: "+strcolName+" in row: " + irow, "PASS");
                bflag = true;
                break;
            }
        }

		if (bflag == false)
		{
 			AUTActions.LogIt(null, "***Fail-Did NOT find "+strSrchData+" under column name.: "+strcolName+" in the customers table.", "FAIL");
		}
        
        
        return bflag;		

	}	
	
	public static boolean srchandEditCustomerbyCol(String strSrchData, String strcolName, int icolIndex)
	{
		customerPageObj=new CustomerPageObj();
		
        boolean bflag = false;
        Log.info("Looking for customer data: "+strSrchData+" under column name: "+strcolName);		
        for(int irow=1;irow < customerPageObj.getNoOfRows() + 1;irow++)
        {
            WebElement table = getDriver().findElement(By.xpath ("//table[@id='customers-grid']"));
            String strSrchResults = table.findElement(By.xpath ("//table[@id='customers-grid']/tbody/tr[" + irow + "]/td[" + icolIndex + "]")).getText();
            //Log.info("Found this..."+strSrchResults+" under column name: "+strcolName+" in row: " + irow);
            if (strSrchData.equals(strSrchResults))
            {
                Log.info("Found "+strSrchData+" under column name: "+strcolName+" in row: " + irow);
                table.findElement(By.xpath ("//table[@id='customers-grid']/tbody/tr[" + irow + "]/td[7]")).click();
                Log.info("Clicked edit button for: "+strSrchData);
                bflag = true;
                break;
            }
        }

		if (bflag == false)
		{
            Log.info("***Fail-Did NOT find "+strSrchData+" under column name.: "+strcolName+" in the customers table.");
 			Assert.fail("***Fail-Did NOT find "+strSrchData+" under column name: "+strcolName+" in the customers table.");

		}
       
        return bflag;		

	}	

	public static void downloadandverifyPDF(String strdata, String strpdfile) throws Throwable
	{
		landingPageObj = new LandingPageObj();
		productsPageObj = new  ProductsPageObj();
		
		AUTActions.cleanFolder(prop.getProperty("fileDownLoadLocation")); //delete any files in the download folder
	
		productsPageObj.click_downloadPDFBtn();

		AUTActions.checkForFileDownload(prop.getProperty("fileDownLoadLocation"), strpdfile);
		landingPageObj.click_logoutBtn(); //log out once file has been downloaded
		
		String url = prop.getProperty("chromefileFormat")+strpdfile;
		AUTActions.LogIt(null, "Converted PDF file to chrome URL format: "+ url, "INFO");
		//open the pdf file in chrome
		getDriver().get(url);
		try 
		{
			String pdfContent = AUTActions.readPdfContent(url, false); //true = log output PDF content
			boolean bFlag = pdfContent.contains(strdata);
			if (bFlag) {
				AUTActions.LogIt(null, "Found product "+strdata+" in pdf file: "+strpdfile, "PASS");
					
			} else {
				AUTActions.LogIt(null, "Did NOT find product "+strdata+" in pdf file: "+strpdfile, "WARNING");
			}		
		} catch (MalformedURLException e) {
			AUTActions.LogIt(null, "An issue reading | loading pdf file: "+strpdfile, "INFO");
			e.printStackTrace();
		} catch (IOException e) {
			AUTActions.LogIt(null, "An issue reading | loading pdf file: "+strpdfile, "INFO");
			e.printStackTrace();
		}
	}

	
}
