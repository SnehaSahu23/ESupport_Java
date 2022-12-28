package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6722287_AMER_MB_Erevenue_OOWDepotFreeTextEntryBox_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6722287_AMER_MB_Erevenue_OOWDepotFreeTextEntryBox_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6722287_AMER_MB_Erevenue_OOWDepotFreeTextEntryBox_ESUPPORT");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            
            obj_EsupportMobileWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
            obj_EsupportMobileWorkflow.ClickOnStandardOrExpressService(driver);
		
            obj_EsupportMobileWorkflow.VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
            obj_EsupportMobileWorkflow.VerifyNextButtonInIssueDetailsPageOfPopup(driver);
			
            obj_EsupportMobileWorkflow.enterTextInTextboxAndClickXButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
            obj_EsupportMobileWorkflow.ClickOnStandardOrExpressService(driver);
            obj_EsupportMobileWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6722287_AMER_MB_Erevenue_OOWDepotFreeTextEntryBox_ESUPPORT--------->\n  "+e);
		}
	}
}