package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7637122_AMER_CH_UNI_SReventsubscriptionsforEmployeeViewdetailsofanotification extends BaseTest
{
	@Test
	public void validate_TC_7637122_AMER_CH_UNI_SReventsubscriptionsforEmployeeViewdetailsofanotification() 
	{
		try
		{
			System.out.println("Starts TC_7637122_AMER_CH_UNI_SReventsubscriptionsforEmployeeViewdetailsofanotification");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportUnifiedPortalWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			obj_EsupportUnifiedPortalWorkflow.clickNotificationsAlertsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyServiceRequestEventsColumns(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyActionsButtonOptions(driver);
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			obj_EsupportUnifiedPortalWorkflow.clickActionsButtonViewDetailsOption(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.verifyNotificationPopupDetails(driver);
			obj_EsupportUnifiedPortalWorkflow.clickNotificationPopupCloseButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7637122_AMER_CH_UNI_SReventsubscriptionsforEmployeeViewdetailsofanotification--------->\n  "+e);
		}
	}
}
