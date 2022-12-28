package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510586_AMER_ED_ServiceEvents_LEMC_Overviewtab_ServicerequestSummarycardSRInfo extends BaseTest
{
	@Test
	public void validate_TC_7510586_AMER_ED_ServiceEvents_LEMC_Overviewtab_ServicerequestSummarycardSRInfo() 
	{
		try
		{
			System.out.println("Starts TC_7510586_AMER_ED_ServiceEvents_LEMC_Overviewtab_ServicerequestSummarycardSRInfo");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.verifyServiceRequestSummaryOverviewTab(driver);	
			obj_EsupportServiceEventsWorkflow.verifyServiceRequestSummaryDynamicDial(driver);	
			obj_EsupportServiceEventsWorkflow.verifyServiceRequestSummaryZeroEscalated(driver);	
			obj_EsupportServiceEventsWorkflow.verifyServiceRequestSummaryZeroAwaiting(driver);	
			obj_EsupportServiceEventsWorkflow.verifyServiceRequestSummaryZeroActive(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510586_AMER_ED_ServiceEvents_LEMC_Overviewtab_ServicerequestSummarycardSRInfo--------->\n  "+e);
		}
	}
}

