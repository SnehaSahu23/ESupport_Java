package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7067905_AMER_CH_UNI_SReventsubscriptionsforCPCreateanewnotificationusingAccountSites extends BaseTest
{
	@Test
	public void validate_TC_7067905_AMER_CH_UNI_SReventsubscriptionsforCPCreateanewnotificationusingAccountSites()
	{
		try
		{
			System.out.println("Starts TC_7067905_AMER_CH_UNI_SReventsubscriptionsforCPCreateanewnotificationusingAccountSites");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickNotificationsAlertsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.clickServiceRequestEventsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.clickAddNotificationButton(driver);			
			obj_EsupportUnifiedPortalWorkflow.verifySREventNotificationPopup(driver);
			obj_EsupportUnifiedPortalWorkflow.verifySRNotificationPopupProductsDropdown(driver);
			obj_EsupportUnifiedPortalWorkflow.selectSitesSRNotificationPopupProductsDropdown(driver);
			obj_EsupportUnifiedPortalWorkflow.clickSREventNotificationSitesCheckbox(driver);
			obj_EsupportUnifiedPortalWorkflow.verifySREventNotificationPagination(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyConfirmEmailOption(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyActivateNotificationSREventNotification(driver);
			obj_EsupportUnifiedPortalWorkflow.verifySaveandCancelButtonREventNotification(driver);
			obj_EsupportUnifiedPortalWorkflow.createSREventNotificationAccountSite(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.clickAddNotificationButton(driver);
			obj_EsupportUnifiedPortalWorkflow.editSREventNotificationclickCancel(driver);
			Thread.sleep(5000);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7067905_AMER_CH_UNI_SReventsubscriptionsforCPCreateanewnotificationusingAccountSites--------->\n  "+e);
		}
	}
}