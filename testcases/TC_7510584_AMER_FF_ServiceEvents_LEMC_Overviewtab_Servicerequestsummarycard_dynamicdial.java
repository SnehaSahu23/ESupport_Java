package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510584_AMER_FF_ServiceEvents_LEMC_Overviewtab_Servicerequestsummarycard_dynamicdial extends BaseTest
{
	@Test
	public void validate_TC_7510584_AMER_FF_ServiceEvents_LEMC_Overviewtab_Servicerequestsummarycard_dynamicdial() 
	{
		try
		{
			System.out.println("Starts TC_7510584_AMER_FF_ServiceEvents_LEMC_Overviewtab_Servicerequestsummarycard_dynamicdial");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.verifyServiceRequestSummaryOverviewTab(driver);	
			obj_EsupportServiceEventsWorkflow.verifyServiceRequestSummaryDonutZeroActive(driver);	
			obj_EsupportServiceEventsWorkflow.verifyServiceRequestSummaryDynamicDial(driver);	
			obj_EsupportServiceEventsWorkflow.verifyServiceRequestSummaryColourDynamicDial(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510584_AMER_FF_ServiceEvents_LEMC_Overviewtab_Servicerequestsummarycard_dynamicdial--------->\n  "+e);
		}
	}
}