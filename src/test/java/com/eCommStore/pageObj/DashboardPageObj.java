package com.eCommStore.pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.base.BaseClass;

public class DashboardPageObj extends BaseClass 
{
	 //list items	
	@FindBy(xpath = "//p[text()[normalize-space()='Catalog']]")
	WebElement catalogMnu_xpath;
	
	@FindBy(xpath = "//p[text()=' Products']")
	WebElement productsMnuItm_xpath;
	 ////p[normalize-space()='Products']
	@FindBy(xpath = "//p[text()[normalize-space()='Customers']]")
	WebElement customersMnu_xpath;
	
	@FindBy(xpath = "//p[text()=' Customers']")
	WebElement customersMnuItm_xpath;

	@FindBy(xpath = "//ul[@id='SelectedCustomerRoleIds_listbox']/li[text()='Administrators']")
	WebElement administratorsMnuItm_xpath;	
	
	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	WebElement registeredMnuItm_xpath;	

	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement guestsMnuItm_xpath;		

	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	WebElement vendorsLstitem_xpath;		

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement newBtn_xpath;	 
	 
	 
	//initialize the page
	public DashboardPageObj()
	{
		PageFactory.initElements(getDriver(), this);
	}	
	
	public void click_customersMnuItm()
	{
    	AUTActions.click(getDriver(), customersMnu_xpath, "Link");
    	AUTActions.click(getDriver(), customersMnuItm_xpath, "Link");
    	
	}	
	
	public void click_productsMnuItm() throws InterruptedException
	{
    	AUTActions.click(getDriver(), catalogMnu_xpath, "Link");
    	Thread.sleep(1000);
    	AUTActions.click(getDriver(), productsMnuItm_xpath, "Link");
    	
		//return new productsPageObj();
	}	
	
}
