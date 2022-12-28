package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7056524_AMER_MB_ContactUSSPEBROWSEMYASSETS_LDELL extends MobilePage
{
	@Test
	public void validate_TC_7056524_AMER_MB_ContactUSSPEBROWSEMYASSETS_LDELL() 
	{
		try
		{
			System.out.println("Starts TC_7056524_AMER_MB_ContactUSSPEBROWSEMYASSETS_LDELL");
			
            obj_EsupportMobileWorkflow.handleCookies(driver);
            
            obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            
			
			
			obj_EsupportMobileWorkflow.validateCtsHomePage(driver);	
			obj_EsupportMobileWorkflow.clickBrowseMyAssetsButton(driver);		
			obj_EsupportMobileWorkflow.enterSignInDetails(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));		
			obj_EsupportMobileWorkflow.signOut(driver);
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while executing TC_7056524_AMER_MB_ContactUSSPEBROWSEMYASSETS_LDELL--------->\n  "+e);
		}

	}

}
