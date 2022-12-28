package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10147110_AMER_MB_IPS_LDellModelOverviewtab_Esupport extends BaseTest
{
	@Test
	public void validate_TC_10147110_AMER_MB_IPS_LDellModelOverviewtab_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_10147110_AMER_MB_IPS_LDellModelOverviewtab_Esupport");

			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.searchServiceTag_productID(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportMobileWorkflow.verifyOverviewTabDetails_ProductnameSearch(driver);		
            obj_EsupportMobileWorkflow.verifyOverviewTabDetails_QuickLinks_ProductnameSearch(driver);
			
			obj_EsupportIPSWorkflow.clickIdentifyYourProductLink(driver);
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_MoreResources(driver);
			obj_EsupportIPSWorkflow.ContactTechnicalSection(driver);
			
			obj_EsupportIPSWorkflow.clickContactTechnicalSupportLink(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10147110_AMER_MB_IPS_LDellModelOverviewtab_Esupport--------->\n  "+e);
		}
	}
}
