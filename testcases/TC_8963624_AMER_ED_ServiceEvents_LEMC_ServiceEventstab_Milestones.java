package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8963624_AMER_ED_ServiceEvents_LEMC_ServiceEventstab_Milestones extends BaseTest
{
	@Test
	public void validate_TC_8963624_AMER_ED_ServiceEvents_LEMC_ServiceEventstab_Milestones() 
	{
		try
		{
			System.out.println("Starts TC_8963624_AMER_ED_ServiceEvents_LEMC_ServiceEventstab_Milestones");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.clickOnServiceEventsTab_LEMC(driver);
			Thread.sleep(5000);
			obj_EsupportServiceEventsWorkflow.verifyEventTypesSETabLeftPanel_LEMC(driver);
			Thread.sleep(5000);
			obj_EsupportServiceEventsWorkflow.clickMilestonesExpandIconAndVerifyOptions(driver);
			obj_EsupportServiceEventsWorkflow.clickMilestoneCheckboxAndApplyFiltersButtonAndVerifyFilters(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8963624_AMER_ED_ServiceEvents_LEMC_ServiceEventstab_Milestones--------->\n  "+e);
		}
	}
}