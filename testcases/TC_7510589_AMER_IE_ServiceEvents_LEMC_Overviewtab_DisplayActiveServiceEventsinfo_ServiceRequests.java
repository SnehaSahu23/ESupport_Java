package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510589_AMER_IE_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsinfo_ServiceRequests extends BaseTest
{
	@Test
	public void validate_TC_7510589_AMER_IE_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsinfo_ServiceRequests() 
	{
		try
		{
			System.out.println("Starts TC_7510589_AMER_IE_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsinfo_ServiceRequests");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.verifySRDetailsInOverviewTab(driver);					
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510589_AMER_IE_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsinfo_ServiceRequests--------->\n  "+e);
		}
	}
}
