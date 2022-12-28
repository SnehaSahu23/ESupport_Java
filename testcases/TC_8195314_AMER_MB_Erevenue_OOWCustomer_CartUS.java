package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8195314_AMER_MB_Erevenue_OOWCustomer_CartUS extends BaseTest
{
	@Test
	public void validate_TC_8195314_AMER_MB_Erevenue_OOWCustomer_CartUS() 
	{
		try
		{
			System.out.println("Starts TC_8195314_AMER_MB_Erevenue_OOWCustomer_CartUS");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			Thread.sleep(10000);
			obj_EsupportMobileWorkflow.verifyHardwareOfferTile(driver);
			obj_EsupportMobileWorkflow.verifySoftwareOfferTile(driver);
//			obj_EsupportMobileWorkflow.enterServiceTagAndVerifyHardwareAndSoftwareOfferInCTS(driver);
			obj_EsupportMobileWorkflow.verifyContactSupportInMenu(driver);
				
	        obj_EsupportMobileWorkflow.ClickOnContactSupportInMenu(driver);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8195314_AMER_MB_Erevenue_OOWCustomer_CartUS--------->\n  "+e);
		}
	}
}
