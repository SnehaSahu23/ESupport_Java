package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10147091_AMER_MB_IPS_LEMC_serializedOverviewTabMoreresourcessection_Esupport extends BaseTest
{
	@Test
	public void validate_TC_10147091_AMER_MB_IPS_LEMC_serializedOverviewTabMoreresourcessection_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_10147091_AMER_MB_IPS_LEMC_serializedOverviewTabMoreresourcessection_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);

			obj_EsupportMobileWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportMobileWorkflow.verifyOverviewTabDetails_MoreResources(driver);		
			obj_EsupportMobileWorkflow.clickWatchVideosButton(driver);
			
			obj_EsupportMobileWorkflow.clickVisitKnowledgeBaseButton(driver);
			obj_EsupportMobileWorkflow.clickVisitDellCommunityButton(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10147091_AMER_MB_IPS_LEMC_serializedOverviewTabMoreresourcessection_Esupport--------->\n  "+e);
		}
	}
}
