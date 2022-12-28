package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7204444_AMER_CH_UNI_SReventsubscriptionsforCPEusersTurnONOFF extends BaseTest
{
	@Test
	public void validate_TC_7204444_AMER_CH_UNI_SReventsubscriptionsforCPEusersTurnONOFF() 
	{
		try
		{
			System.out.println("Starts TC_7204444_AMER_CH_UNI_SReventsubscriptionsforCPEusersTurnONOFF");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickNotificationsAlertsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyServiceRequestEventsColumns(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPaginationServiceRequestEvents(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyServiceRequestEventsNotificationToggle(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7204444_AMER_CH_UNI_SReventsubscriptionsforCPEusersTurnONOFF--------->\n  "+e);
		}
	}
}
