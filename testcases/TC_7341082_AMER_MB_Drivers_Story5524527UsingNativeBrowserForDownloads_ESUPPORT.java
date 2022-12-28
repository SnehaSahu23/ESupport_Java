package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7341082_AMER_MB_Drivers_Story5524527UsingNativeBrowserForDownloads_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_7341082_AMER_MB_Drivers_Story5524527UsingNativeBrowserForDownloads_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7341082_AMER_MB_Drivers_Story5524527UsingNativeBrowserForDownloads_ESUPPORT");
				
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            
            obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.Emaillogin(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));

            obj_EsupportMobileWorkflow.ClickSearchServiceTag(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
            obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
			
            obj_EsupportMobileWorkflow.ClickDownloadButtonForLEMCProduct(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7341082_AMER_MB_Drivers_Story5524527UsingNativeBrowserForDownloads_ESUPPORT--------->\n  "+e);
		}
	}
}
