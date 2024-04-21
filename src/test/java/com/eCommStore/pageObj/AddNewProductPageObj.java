package com.eCommStore.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.eCommStore.utilities.Log;
import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.base.BaseClass;

public class AddNewProductPageObj extends BaseClass 
{
	
	
    //add new product Page
	
	@FindBy(id = "Name")
	WebElement PrdNameTxt_id;

	@FindBy(id = "ShortDescription")
	WebElement ShortDescriptionTxt_id;

	
	@FindBy(name = "save")
	WebElement saveBtn_name;
	
	//initialize the page
	public AddNewProductPageObj()
	{
		PageFactory.initElements(getDriver(), this);
	}	

	
	public void type_prdName(String strPrdNme)
	{
		AUTActions.type(PrdNameTxt_id, strPrdNme);

	}	

	public void type_shortDescritpion(String strDescription)
	{
		AUTActions.type(ShortDescriptionTxt_id, strDescription);

	}	

	public void click_saveBtn()
	{
    	AUTActions.click(getDriver(), saveBtn_name, "Button");
		//return new AddNewCustomerPageObj();
	}	
	
}
