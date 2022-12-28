package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6880796_AMER_MB_IPS_LDellTaggedOverviewTabQuicklinks_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6880796_AMER_MB_IPS_LDellTaggedOverviewTabQuicklinks_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6880796_AMER_MB_IPS_LDellTaggedOverviewTabQuicklinks_Esupport");			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.searchServiceTag_LDELL(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportMobileWorkflow.verifyOverviewTabDetails_QuickLinks(driver);
	
            obj_EsupportMobileWorkflow.clickViewProductsSpecsLink(driver);	
            obj_EsupportMobileWorkflow.verifyModalPopupConfiguration(driver);	
            obj_EsupportMobileWorkflow.verifyConfigurationTable(driver);	
            obj_EsupportMobileWorkflow.verifyExportOption(driver);	
            obj_EsupportMobileWorkflow.clickExportOption(driver);	
            obj_EsupportMobileWorkflow.clickCurrentConfigurationTab(driver);	
            obj_EsupportMobileWorkflow.verifyRunSupportAssistButton(driver);	
            obj_EsupportMobileWorkflow.clickModalPopupCloseButton(driver);	
            obj_EsupportMobileWorkflow.clickAddToMyProductsAndServicesLink(driver);
            obj_EsupportMobileWorkflow.clickGetSupportNotificationLink(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6880796_AMER_MB_IPS_LDellTaggedOverviewTabQuicklinks_Esupport--------->\n  "+e);
		}
	}
}



