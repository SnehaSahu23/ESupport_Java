package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7637102_AMER_CH_CreateanewnotificationwhenUserisPrimaryContactOwneronaSR extends BaseTest
{
	@Test
	public void validate_TC_7637102_AMER_CH_CreateanewnotificationwhenUserisPrimaryContactOwneronaSR() 
	{
		try
		{
			System.out.println("Starts TC_7637102_AMER_CH_CreateanewnotificationwhenUserisPrimaryContactOwneronaSR");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickNotificationsAlertsTab(driver);
		//	obj_EsupportUnifiedPortalWorkflow.verifySREventNotificationPopup(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportUnifiedPortalWorkflow.verifyConfirmEmailOption(driver);
			
			obj_EsupportUnifiedPortalWorkflow.verifySaveButtonEnabledSREventNotification(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7637102_AMER_CH_CreateanewnotificationwhenUserisPrimaryContactOwneronaSR--------->\n  "+e);
		}
	}
}
