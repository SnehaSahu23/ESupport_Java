package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6963752_AMER_MB_ContactUs_SPE_BROWSEALLPRODUCTSBUTTON_LDELL extends MobilePage
{
	@Test
	public void validate_TC_6963752_AMER_MB_ContactUs_SPE_BROWSEALLPRODUCTSBUTTON_LDELL() 
	{
		try
		{
			System.out.println("Starts TC_6963752_AMER_MB_ContactUs_SPE_BROWSEALLPRODUCTSBUTTON_LDELL");
			
            obj_EsupportMobileWorkflow.handleCookies(driver);
            
            obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
//			obj_EsupportMobileWorkflow.validateCtsHomePage(driver);	
//			obj_EsupportMobileWorkflow.clickBrowseAllProductsLink(driver);
//			obj_EsupportMobileWorkflow.SelectProductFromBrowseAll(driver);
			obj_EsupportMobileWorkflow.clickChooseMyModel(driver);
			obj_EsupportMobileWorkflow.SelectProductFromBrowseAll(driver);
//			obj_EsupportMobileWorkflow.clickNextProvideWarrantyInfo(driver);
//			obj_EsupportMobileWorkflow.clickiDontHaveItButton(driver);	
			obj_EsupportMobileWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[2]);
//			obj_EsupportMobileWorkflow.clickOnNextButton(driver);
//			
//			obj_EsupportMobileWorkflow.clickLaptopsLink(driver);
//			obj_EsupportMobileWorkflow.ClickGSeriesLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportMobileWorkflow.clickLatitudeLink(driver);
//			obj_EsupportMobileWorkflow.clickLatitudeSubProduct(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
//			obj_EsupportMobileWorkflow.SelectProductFromBrowseAll(driver);
//			obj_EsupportMobileWorkflow.SelectIssueFromDropDown(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[4]);
			obj_EsupportMobileWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			
			// validations after sign in 
			//driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/dynamic");
			obj_EsupportMobileWorkflow.clickSignIn(driver);
			//obj_EsupportMobileWorkflow.clickOnSignInButton(driver);
			obj_EsupportMobileWorkflow.ToLogin_ValidCredentials(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
//			obj_EsupportMobileWorkflow.validateCtsHomePage(driver);	
			obj_EsupportMobileWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportMobileWorkflow.SelectProductFromBrowseAll(driver);
			Thread.sleep(10000);
//			obj_EsupportMobileWorkflow.clickLaptopsLink(driver);
//			obj_EsupportMobileWorkflow.ClickGSeriesLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			//obj_EsupportMobileWorkflow.clickLatitudeLink(driver);
//			obj_EsupportMobileWorkflow.clickLatitudeSubProduct(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportMobileWorkflow.SelectIssueFromDropDown(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[5]);
			obj_EsupportMobileWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			
			//obj_EsupportIPSWorkflow.signOut(driver);
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while executing TC_6963752_AMER_MB_ContactUs_SPE_BROWSEALLPRODUCTSBUTTON_LDELL--------->\n  "+e);
		}

	}
}
