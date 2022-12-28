package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7070299_AMER_CH_SReventsubscriptionsforCPEChangetheorderoffields extends BaseTest
{
	@Test
	public void validate_TC_7070299_AMER_CH_SReventsubscriptionsforCPEChangetheorderoffields() 
	{
		try
		{
			System.out.println("Starts TC_7070299_AMER_CH_SReventsubscriptionsforCPEChangetheorderoffields");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.verifyNotificationsAlertsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.clickServiceRequestEventsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.clickAddNotificationButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7070299_AMER_CH_SReventsubscriptionsforCPEChangetheorderoffields--------->\n  "+e);
		}
	}
}

