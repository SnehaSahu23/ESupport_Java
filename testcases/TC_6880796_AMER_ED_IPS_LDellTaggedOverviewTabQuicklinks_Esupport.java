package com.dell.delta_uat_automation.esupport.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6880796_AMER_ED_IPS_LDellTaggedOverviewTabQuicklinks_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6880796_AMER_ED_IPS_LDellTaggedOverviewTabQuicklinks_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6880796_AMER_ED_IPS_LDellTaggedOverviewTabQuicklinks_Esupport");			

			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_QuickLinks(driver);
	
			obj_EsupportIPSWorkflow.clickViewProductsSpecsLink(driver);	
			obj_EsupportIPSWorkflow.verifyModalPopupConfiguration(driver);	
			obj_EsupportIPSWorkflow.verifyConfigurationTable(driver);	
			obj_EsupportIPSWorkflow.verifyExportOption(driver);	
			obj_EsupportIPSWorkflow.clickExportOption(driver);	
			obj_EsupportIPSWorkflow.clickCurrentConfigurationTab(driver);	
			obj_EsupportIPSWorkflow.verifyRunSupportAssistButton(driver);	
			obj_EsupportIPSWorkflow.clickModalPopupCloseButton(driver);	
			obj_EsupportIPSWorkflow.clickAddToMyProductsAndServicesLink(driver);
			obj_EsupportIPSWorkflow.clickGetSupportNotificationLink(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6880796_AMER_ED_IPS_LDellTaggedOverviewTabQuicklinks_Esupport--------->\n  "+e);
		}
	}
}
