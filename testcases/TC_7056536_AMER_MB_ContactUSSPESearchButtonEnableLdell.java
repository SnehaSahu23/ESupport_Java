package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7056536_AMER_MB_ContactUSSPESearchButtonEnableLdell extends MobilePage 
{
	@Test
	public void validate_TC_7056536_AMER_MB_ContactUSSPESearchButtonEnableLdell() 
	{
		try
		{
			System.out.println("Starts TC_7056536_AMER_MB_ContactUSSPESearchButtonEnableLdell");
			
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            
            obj_EsupportMobileWorkflow.handleCookies(driver);
            obj_EsupportMobileWorkflow.validateCtsHomePage(driver);	
            obj_EsupportMobileWorkflow.validateSearchButtonDisabled(driver);		
            obj_EsupportMobileWorkflow.enterDataSearchTextbox(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));			
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while executing TC_7056536_AMER_MB_ContactUSSPESearchButtonEnableLdell--------->\n  "+e);
		}

	}
}
