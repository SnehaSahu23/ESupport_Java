package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6881229_AMER_MB_IPS_LDellMnAdocumentationtabinterlock_Esupport extends MobilePage
{
	@Test
	public void validate_TC_6881229_AMER_MB_IPS_LDellMnAdocumentationtabinterlock_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6881229_AMER_MB_IPS_LDellMnAdocumentationtabinterlock_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.searchServiceTag_LDELL(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
            obj_EsupportMobileWorkflow.verifyDocumentationTab(driver);	
            obj_EsupportMobileWorkflow.clickDocumentationTab(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6881229_AMER_MB_IPS_LDellMnAdocumentationtabinterlock_Esupport--------->\n  "+e);
		}
	}
}