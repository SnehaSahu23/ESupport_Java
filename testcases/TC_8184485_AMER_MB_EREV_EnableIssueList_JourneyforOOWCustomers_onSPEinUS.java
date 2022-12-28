package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_8184485_AMER_MB_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS extends BaseTest
{
	@Test
	public void validate_TC_8184485_AMER_MB_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS() 
	{
		try
		{
			System.out.println("Starts TC_8184485_AMER_MB_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
//            obj_EsupportMobileWorkflow.verifyIssueListInCTSPage(driver);
            obj_EsupportMobileWorkflow.verifyContactSupportInMenu(driver);
			
            obj_EsupportMobileWorkflow.ClickOnContactSupportInMenu(driver);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8184485_AMER_MB_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS--------->\n  "+e);
		}
	}
}
