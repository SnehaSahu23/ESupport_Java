package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10148535_AMER_ED_IPS_LEMC_SerializedOverviewRecentServicerequests_Esupport extends BaseTest
{
	@Test
	public void validate_TC_10148535_AMER_ED_IPS_LEMC_SerializedOverviewRecentServicerequests_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_10148535_AMER_ED_IPS_LEMC_SerializedOverviewRecentServicerequests_Esupport");
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);

			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_ServiceEventsSection(driver);
			
			obj_EsupportIPSWorkflow.clickViewAllLinkSRTab(driver);
			obj_EsupportIPSWorkflow.clickOnFirstDisplayedSRInOverviewTab(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10148535_AMER_ED_IPS_LEMC_SerializedOverviewRecentServicerequests_Esupport--------->\n  "+e);
		}
	}
}
