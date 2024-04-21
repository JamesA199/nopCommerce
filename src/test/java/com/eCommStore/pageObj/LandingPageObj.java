/**
 * 
 */
package com.eCommStore.pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.base.BaseClass;
import com.eCommStore.utilities.Log;

/**
 * 
 */
public class LandingPageObj extends BaseClass
{
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutLnk_xpath;
	
	@FindBy(xpath = "//a[normalize-space()='Personal']")
	WebElement personalLnk;

	@FindBy(xpath = "//a[normalize-space()='Business']")
	WebElement businessLnk;
	
	@FindBy(xpath = "//a[normalize-space()='Wealth']")
	WebElement wealthLnk;

	@FindBy(xpath = "//span[contains(text(),'Log in')]")
	WebElement loginLnk;
	//a[@cla ss='cmp-loginandsearch__login']//span[contains(text(),'Log in')]

	//accounts dropdown menu link and items
	@FindBy(xpath = "//a[@data-title='Accounts']")
	WebElement accountsLnk;
	
	@FindBy(xpath = "//a[@href='/personal/accounts/no-fee-chequing.html'][normalize-space()='']")
	WebElement nofeechequingLnk;
	
	//initialize the page
	public LandingPageObj()
	{
		PageFactory.initElements(getDriver(), this);
	}	
	
	public LoginPageObj click_LoginBtn()
	{
		AUTActions.click(getDriver(), loginLnk, "Button");
		return new LoginPageObj();
	}	

	public LoginPageObj click_logoutBtn()
	{
		AUTActions.click(getDriver(), logoutLnk_xpath, "Button");
		return new LoginPageObj();
	}	
	
	public LoginPageObj click_PersonalLnk()
	{
		AUTActions.click(getDriver(), personalLnk, "Link");
		return new LoginPageObj();

	}	
	
	public BusinessPageObj clickBusinessLnk()
	{
		AUTActions.click(getDriver(), businessLnk, "Link");
		return new BusinessPageObj();

	}
	
}
