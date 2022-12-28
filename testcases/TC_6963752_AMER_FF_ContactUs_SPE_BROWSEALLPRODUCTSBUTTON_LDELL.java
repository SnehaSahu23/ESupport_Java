package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6963752_AMER_FF_ContactUs_SPE_BROWSEALLPRODUCTSBUTTON_LDELL extends BaseTest 
{
	@Test
	public void validate_TC_6963752_AMER_FF_ContactUs_SPE_BROWSEALLPRODUCTSBUTTON_LDELL() 
	{
		try
		{
			System.out.println("Starts TC_6963752_AMER_FF_ContactUs_SPE_BROWSEALLPRODUCTSBUTTON_LDELL");
			obj_EsupportIncidentsWorkflow.validateCtsHomePage(driver);	
			obj_EsupportIncidentsWorkflow.clickBrowseAllProductsLink(driver);
//			obj_EsupportIncidentsWorkflow.clickChooseMyModel(driver);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
//			obj_EsupportIncidentsWorkflow.clickNextProvideWarrantyInfo(driver);   
//			obj_EsupportIncidentsWorkflow.clickiDontHaveItButton(driver);	
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[2]);
//			obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
			Thread.sleep(20000);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.ClickGSeriesLink(driver);
//   		obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
//			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[2]);
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			
			// validations after sign in 
//			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIncidentsWorkflow.validateCtsHomePage(driver);	
			obj_EsupportIncidentsWorkflow.clickBrowseAllProductsLink(driver);
//			obj_EsupportIncidentsWorkflow.clickChooseMyModel(driver);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
			Thread.sleep(20000);
//			obj_EsupportIncidentsWorkflow.clickNextProvideWarrantyInfo(driver);
//			obj_EsupportIncidentsWorkflow.clickiDontHaveItButton(driver);	
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[2]);
//			obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.ClickGSeriesLink(driver);
////			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
//			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[2]);
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while executing TC_6963752_AMER_FF_ContactUs_SPE_BROWSEALLPRODUCTSBUTTON_LDELL--------->\n  "+e);
		}

	}
}
