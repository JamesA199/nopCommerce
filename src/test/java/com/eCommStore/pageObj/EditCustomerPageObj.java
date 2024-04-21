package com.eCommStore.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utilities.Log;
public class EditCustomerPageObj extends BaseClass 
{
	   // text boxes

	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailTxt_xpath;	
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordTxt_xpath;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstNameTxt_xpath;	

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastNameTxt_xpath;
	
	@FindBy(xpath = "//*[@id='customer-info']/div[2]/div[10]/div[2]/div/div[1]/div/div")
	WebElement customerRolesTxt_xpath;
	
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement dobTxt_xpath;	
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyNameTxt_xpath;	

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement adminCommentTxt_xpath;

	//buttons
	@FindBy(xpath = "//button[@name='save']")
	WebElement saveBtn_xpath;	

    //dropddown combo
	@FindBy(xpath = "//*[@id='VendorId']")
	WebElement mgrOfVendorDrplst_xpath;
	
    //radio options
	@FindBy(id = "Gender_Male")
	WebElement maleGenderRd_id;

	@FindBy(id = "Gender_Female")
	WebElement femaleGenderRd_id;
	
	@FindBy(xpath = "//span[@title='delete']")
	WebElement registerDeletex_xpath;
	
	//initialize the page
	public EditCustomerPageObj()
	{
		PageFactory.initElements(getDriver(), this);
	}	

	
	public void type_email(String strEmail)
	{
		AUTActions.type(emailTxt_xpath, strEmail);

	}	
	
	public void type_password(String strPword)
	{
		AUTActions.type(passwordTxt_xpath, strPword);
	}	

	public void type_fname(String strFname)
	{
		AUTActions.type(firstNameTxt_xpath, strFname);
	}		

	public void type_lname(String strLname)
	{
		AUTActions.type(lastNameTxt_xpath, strLname);
	}	

	public void click_genderType(String strGender)
	{

    	if (strGender.equals("Male"))
    	{
        	AUTActions.click(getDriver(), maleGenderRd_id, "OptionBtn");
    	}
    	else if (strGender.equals("Female"))
    	{
        	AUTActions.click(getDriver(), femaleGenderRd_id, "OptionBtn");    		
   		
    	}
    	else
    	{
        	AUTActions.click(getDriver(), maleGenderRd_id, "OptionBtn"); 
    	}
	}
	public void type_dob(String strDOB)
	{
		AUTActions.type(dobTxt_xpath, strDOB);
	}		

	public void type_companyName(String strcompanyName)
	{
		AUTActions.type(companyNameTxt_xpath, strcompanyName);
	}		


	public void type_customerRoles(String strcustomerRoles) throws Throwable
	{
		//remove any roles already selected
		boolean bflag = AUTActions.findElement(getDriver(), registerDeletex_xpath);
		
    	if (bflag == true)
    	{
    		AUTActions.click(getDriver(), registerDeletex_xpath, "Button"); 
    	}
        //click in the textbox to activate the item list
		AUTActions.click(getDriver(), customerRolesTxt_xpath, "TxtBox");
		Thread.sleep(2000);
		getDriver().findElement(By.xpath ("//ul[@id='SelectedCustomerRoleIds_listbox']/li[text()='"+strcustomerRoles+"']")).click();
		Log.info("Selected customer role: "+strcustomerRoles);

	}
    
	public void select_ManagerOfVendor(String strVendor)
	{
		AUTActions.selectByVisibleText(mgrOfVendorDrplst_xpath, strVendor, "DropDown");
	}


	public void type_adminComment(String strAdminComment)
	{
		AUTActions.type(adminCommentTxt_xpath, strAdminComment);
	}		
	

	public void click_saveBtn()
	{
    	AUTActions.click(getDriver(), saveBtn_xpath, "Button");    
		//return new CustomerPageObj();
		
	}	
	

}
