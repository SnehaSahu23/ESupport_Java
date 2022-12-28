package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7637114_AMER_CH_UNI_SReventsubscriptionsforCPCreateanewnotificationusingAccountSitesPartnerUser extends BaseTest
{
	@Test
	public void validate_TC_7637114_AMER_CH_UNI_SReventsubscriptionsforCPCreateanewnotificationusingAccountSitesPartnerUser()
	{
		try
		{
			System.out.println("Starts TC_7637114_AMER_CH_UNI_SReventsubscriptionsforCPCreateanewnotificationusingAccountSitesPartnerUser");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickNotificationsAlertsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.clickServiceRequestEventsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.clickAddNotificationButton(driver);			
			obj_EsupportUnifiedPortalWorkflow.verifySREventNotificationEditableFields(driver);
			obj_EsupportUnifiedPortalWorkflow.verifySREventNotificationSetYourPreferenceValues(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7637114_AMER_CH_UNI_SReventsubscriptionsforCPCreateanewnotificationusingAccountSitesPartnerUser--------->\n  "+e);
		}
	}
}

