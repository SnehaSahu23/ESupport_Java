package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510591_AMER_FF_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsinfo extends BaseTest
{
	@Test
	public void validate_TC_7510591_AMER_FF_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsinfo() 
	{
		try
		{
			System.out.println("Starts TC_7510591_AMER_FF_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsinfo");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportContentWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.verifySRDetailsInOverviewTab(driver);					
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510591_AMER_FF_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsinfo--------->\n  "+e);
		}
	}
}

