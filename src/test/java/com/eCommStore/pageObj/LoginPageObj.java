/**
 * 
 */
package com.eCommStore.pageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eCommStore.utilities.Log;
import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.base.BaseClass;
/**
 * 
 */
public class LoginPageObj extends BaseClass
{
	@FindBy(id = "Email") 
	WebElement email_InputTxbox;

	@FindBy(id = "Password") 
	WebElement password_InputTxbox;	
	
	@FindBy(xpath = "//button[@class='button-1 login-button']") 
	WebElement loginBtn;

	@FindBy(xpath = "//strong[text()='Welcome, please sign in!']") //Welcome, please sign in!
	WebElement welcomeMsg;

	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']") 
	WebElement loginMessageErrorMsg;	
	////div[text()='Login was unsuccessful. Please correct the errors and try again.']
	
	//initialize the page
	public LoginPageObj()
	{
		PageFactory.initElements(getDriver(), this);
	}	

	public void type_userName(String uname)
	{
		AUTActions.type(email_InputTxbox, uname);

	}

	public void type_pWord(String pword)
	{

		AUTActions.type(password_InputTxbox, pword);
	}	
	
	
	public DashboardPageObj click_LoginBtn()
	{
    	AUTActions.click(getDriver(), loginBtn, "Button");
    	
		return new DashboardPageObj();
	}	
	
	public boolean isDisplayed_welcomeMsg()
	{
		return AUTActions.isDisplayed(getDriver(), welcomeMsg);


	}	

	public boolean isDisplayed_loginMsgErrorMsg()
	{
		return AUTActions.isDisplayed(getDriver(), loginMessageErrorMsg);


	}	
	
	
}
