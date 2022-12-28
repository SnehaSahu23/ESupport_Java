package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7083727_AMER_ED_SReventsubscriptionsforCPE_Editnotifications extends BaseTest
{
	@Test
	public void validate_TC_7083727_AMER_ED_SReventsubscriptionsforCPE_Editnotifications() 
	{
		try
		{
			System.out.println("Starts TC_7083727_AMER_ED_SReventsubscriptionsforCPE_Editnotifications");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickNotificationsAlertsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.clickSREventsNotificationName(driver);
			obj_EsupportUnifiedPortalWorkflow.verifySREventNotificationEditableFields(driver);
			obj_EsupportUnifiedPortalWorkflow.verifySRNotificationPopupProductsDropdown(driver);
			
			//Check for the Select your Products dropdown as Euser
			obj_EsupportUnifiedPortalWorkflow.clickSRNotificationPopupCloseButton(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		
			driver.navigate().to("https://www.dell.com/support/preferences/us/en/04");
			obj_EsupportUnifiedPortalWorkflow.clickSignInHereLink(driver);
			Thread.sleep(30000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportUnifiedPortalWorkflow.clickNotificationsAlertsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.clickSREventsNotificationName(driver);
			obj_EsupportUnifiedPortalWorkflow.verifySRNotificationPopupProductsDropdown(driver);
			obj_EsupportUnifiedPortalWorkflow.editSREventNotificationclickSave(driver);
			obj_EsupportUnifiedPortalWorkflow.clickSREventsNotificationName(driver);
			obj_EsupportUnifiedPortalWorkflow.editSREventNotificationclickCancel(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7083727_AMER_ED_SReventsubscriptionsforCPE_Editnotifications--------->\n  "+e);
		}
	}
}