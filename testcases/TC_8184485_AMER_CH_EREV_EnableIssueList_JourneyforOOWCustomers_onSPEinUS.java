package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8184485_AMER_CH_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS extends BaseTest
{
	@Test
	public void validate_TC_8184485_AMER_CH_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS() 
	{
		try
		{
			System.out.println("Starts TC_8184485_AMER_CH_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS");
			obj_EsupportErevenueWorkflow.handleCookies(driver);
			obj_EsupportErevenueWorkflow.verifyIssueListInCTSPage(driver);
			
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8184485_AMER_CH_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS--------->\n  "+e);
		}
	}
}

