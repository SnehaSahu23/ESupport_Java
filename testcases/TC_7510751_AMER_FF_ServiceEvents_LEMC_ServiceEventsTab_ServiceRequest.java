package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510751_AMER_FF_ServiceEvents_LEMC_ServiceEventsTab_ServiceRequest extends BaseTest
{
	@Test
	public void validate_TC_7510751_AMER_FF_ServiceEvents_LEMC_ServiceEventsTab_ServiceRequest() 
	{
		try
		{
			System.out.println("Starts TC_7510751_AMER_FF_ServiceEvents_LEMC_ServiceEventsTab_ServiceRequest");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportContentWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.clickOnServiceEventsTab_LEMC(driver);
			obj_EsupportServiceEventsWorkflow.verifyEventTypesSETabLeftPanel_LEMC(driver);
			obj_EsupportServiceEventsWorkflow.verifyActiveSREventDetailsSETab(driver);
			obj_EsupportServiceEventsWorkflow.verifyActiveFilterSelectedInSREventType(driver);
			Thread.sleep(5000);
			obj_EsupportServiceEventsWorkflow.verifyClosedSREventDetailsSETab(driver);
			obj_EsupportServiceEventsWorkflow.verifySREventDetailsSETab(driver);
			obj_EsupportServiceEventsWorkflow.clickSREventExpandIconAndVerifyDetails(driver);
			obj_EsupportServiceEventsWorkflow.clickSRNumberLink(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510751_AMER_FF_ServiceEvents_LEMC_ServiceEventsTab_ServiceRequest--------->\n  "+e);
		}
	}
}
