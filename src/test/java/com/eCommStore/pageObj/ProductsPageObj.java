package com.eCommStore.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eCommStore.utilities.Log;
import com.eCommStore.AUTActions.AUTActions;
import com.eCommStore.base.BaseClass;

public class ProductsPageObj extends BaseClass 
{
	
	
    //customers Page
	
	@FindBy(id = "SearchProductName")
	WebElement ProductNameTxt_id;

	@FindBy(id = "SearchCategoryId")
	WebElement SearchCategoryDrpdwn_id;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement addNewPrdBtn_xpath;
	
	
	@FindBy(xpath = "//button[@name='download-catalog-pdf']")
	WebElement downloadCatalogPdfBtn_xpath;
	
	//initialize the page
	public ProductsPageObj()
	{
		PageFactory.initElements(getDriver(), this);
	}	

	
	public void type_srchPrdName(String strPrdName)
	{
		AUTActions.type(ProductNameTxt_id, strPrdName);
	}	

	
	public int getNoOfRows()
	{
		int rowCnt = getDriver().findElements(By.xpath("//table[@id='products-grid']//tbody/tr")).size();
		Log.info("Total product row count: " + rowCnt);
		return rowCnt;
	}
        	
	public void click_downloadPDFBtn()
	{
    	AUTActions.click(getDriver(), downloadCatalogPdfBtn_xpath, "Button");
	}		
	
	public void click_addNewPrdBtn()
	{
    	AUTActions.click(getDriver(), addNewPrdBtn_xpath, "Button");
	}		
	
}
