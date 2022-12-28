package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7082311_AMER_FF_UNI_LinktoCustomgroupswhilecreatinganSReventnotification extends BaseTest
{
	@Test
	public void validate_TC_7082311_AMER_FF_UNI_LinktoCustomgroupswhilecreatinganSReventnotification() 
	{
		try
		{
			System.out.println("Starts TC_7082311_AMER_FF_UNI_LinktoCustomgroupswhilecreatinganSReventnotification");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.verifyNotificationsAlertsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.clickServiceRequestEventsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.clickAddNotificationButton(driver);
			obj_EsupportUnifiedPortalWorkflow.selectSRNotificationPopupProductsDropdown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(10000);
			obj_EsupportUnifiedPortalWorkflow.verifySRNotificationCreateEditGroupLink(driver);
			obj_EsupportUnifiedPortalWorkflow.clickSRNotificationCreateEditGroupLink(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7082311_AMER_FF_UNI_LinktoCustomgroupswhilecreatinganSReventnotification--------->\n  "+e);
		}
	}
}
