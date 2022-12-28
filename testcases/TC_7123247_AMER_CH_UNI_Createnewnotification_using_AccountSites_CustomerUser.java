package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7123247_AMER_CH_UNI_Createnewnotification_using_AccountSites_CustomerUser extends BaseTest
{
	@Test
	public void validate_TC_7123247_AMER_CH_UNI_Createnewnotification_using_AccountSites_CustomerUser()
	{
		try
		{
			System.out.println("Starts TC_7123247_AMER_CH_UNI_Createnewnotification_using_AccountSites_CustomerUser");
			//obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
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
			Assert.fail("Failed in TC_7123247_AMER_CH_UNI_Createnewnotification_using_AccountSites_CustomerUser--------->\n  "+e);
		}
	}
}
