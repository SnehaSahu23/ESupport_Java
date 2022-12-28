package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510758_AMER_CH_ServiceEvents_LEMC_ServiceEventstab_Noactiveservicerequests extends BaseTest
{
	@Test
	public void validate_TC_7510758_AMER_CH_ServiceEvents_LEMC_ServiceEventstab_Noactiveservicerequests() 
	{
		try
		{
			System.out.println("Starts TC_7510758_AMER_CH_ServiceEvents_LEMC_ServiceEventstab_Noactiveservicerequests");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportContentWorkflow.clickSignInHereLink(driver);
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.clickOnServiceEventsTab_LEMC(driver);
			obj_EsupportServiceEventsWorkflow.verifyEventTypesSETabLeftPanel_LEMC(driver);
			obj_EsupportServiceEventsWorkflow.ValidateOnlyShowActiveEvents(driver);
			obj_EsupportServiceEventsWorkflow.verifyNoActiveEventMessage(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510758_AMER_CH_ServiceEvents_LEMC_ServiceEventstab_Noactiveservicerequests--------->\n  "+e);
		}
	}
}

