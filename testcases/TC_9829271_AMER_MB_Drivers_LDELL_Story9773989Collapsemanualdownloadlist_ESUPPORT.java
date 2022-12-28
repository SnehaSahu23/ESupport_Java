package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9829271_AMER_MB_Drivers_LDELL_Story9773989Collapsemanualdownloadlist_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9829271_AMER_MB_Drivers_LDELL_Story9773989Collapsemanualdownloadlist_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9829271_AMER_MB_Drivers_LDELL_Story9773989Collapsemanualdownloadlist_ESUPPORT");

			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            
            obj_EsupportMobileWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
            obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
            obj_EsupportMobileWorkflow.VerifyDriversListIsCollapsed(driver);
            obj_EsupportMobileWorkflow.VerifyAdditionalResourcesSections(driver);
						
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9829271_AMER_MB_Drivers_LDELL_Story9773989Collapsemanualdownloadlist_ESUPPORT--------->\n  "+e);
		}
	}
}

