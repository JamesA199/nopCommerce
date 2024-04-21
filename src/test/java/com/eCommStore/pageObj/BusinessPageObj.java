/**
 * 
 */
package com.eCommStore.pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.base.BaseClass;

/**
 * 
 */
public class BusinessPageObj extends BaseClass 
{
	@FindBy(xpath = "//div[@class='d-none d-md-block']//a[@aria-label='Get pre-approved financing!'][normalize-space()='Get pre-approved financing!']")
	WebElement preapprovedfinancingLnk;
	
	//initialize the page
	public BusinessPageObj()
	{
		PageFactory.initElements(getDriver(), this);
	}	
	
	
	public boolean isDisplayedpreapprovedfinancing()
	{
		return AUTActions.isDisplayed(getDriver(), preapprovedfinancingLnk);


	}
}
