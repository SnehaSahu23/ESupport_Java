package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8458116_AMER_CH_UnifiedProfile_Notifications_ProductionAutomation extends BaseTest
{
	@Test
	public void validate_TC_8458116_AMER_CH_UnifiedProfile_Notifications_ProductionAutomation()
	{
		try
		{
			System.out.println("Starts TC_8458116_AMER_CH_UnifiedProfile_Notifications_ProductionAutomation");
			
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			
			obj_EsupportProductionValidationsWorkflow.clickNotificationsAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.verifyNotificationsAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.clickServiceRequestEventsTab(driver);
			
			//Starts TC_7204444_AMER_CH_UNI_SReventsubscriptionsforCPEusersTurnONOFF
			
			obj_EsupportProductionValidationsWorkflow.verifyServiceRequestEventsColumns(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPaginationServiceRequestEvents(driver);
			obj_EsupportProductionValidationsWorkflow.verifyServiceRequestEventsNotificationToggle(driver);
			
			//TC_7067905_AMER_CH_UNI_SReventsubscriptionsforCPCreateanewnotificationusingAccountSites
			
			obj_EsupportProductionValidationsWorkflow.clickAddNotificationButton(driver);	
			
			//Starts TC_7123247_AMER_CH_UNI_Createnewnotification_using_AccountSites_CustomerUser
			obj_EsupportProductionValidationsWorkflow.verifySREventNotificationEditableFields(driver);
			obj_EsupportProductionValidationsWorkflow.verifySREventNotificationSetYourPreferenceValues(driver);
			
			obj_EsupportProductionValidationsWorkflow.verifySREventNotificationPopup(driver);
			obj_EsupportProductionValidationsWorkflow.verifySRNotificationPopupProductsDropdown(driver);
			obj_EsupportProductionValidationsWorkflow.selectSitesSRNotificationPopupProductsDropdown(driver);
			obj_EsupportProductionValidationsWorkflow.clickSREventNotificationSitesCheckbox(driver);
			obj_EsupportProductionValidationsWorkflow.verifySREventNotificationPagination(driver);
			obj_EsupportProductionValidationsWorkflow.verifyConfirmEmailOption(driver);
			obj_EsupportProductionValidationsWorkflow.verifyActivateNotificationSREventNotification(driver);
			obj_EsupportProductionValidationsWorkflow.verifySaveandCancelButtonREventNotification(driver);
			obj_EsupportProductionValidationsWorkflow.createSREventNotificationAccountSite(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.clickAddNotificationButton(driver);
			obj_EsupportProductionValidationsWorkflow.editSREventNotificationclickCancel(driver);
			Thread.sleep(5000);	
			
			
			//Starts TC_7082311_AMER_CH_UNI_LinktoCustomgroupswhilecreatinganSReventnotification

			obj_EsupportProductionValidationsWorkflow.clickAddNotificationButton(driver);
			obj_EsupportProductionValidationsWorkflow.selectSRNotificationPopupProductsDropdown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.verifySRNotificationCreateEditGroupLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickSRNotificationCreateEditGroupLink(driver);
	
			obj_EsupportProductionValidationsWorkflow.editSREventNotificationclickCancel(driver);
			//Starts TC_7067707_AMER_CH_UNI_SReventsubscriptionsforCPEDeleteanotification
			
			obj_EsupportProductionValidationsWorkflow.clickActionsButtonFirstRow(driver);
			obj_EsupportProductionValidationsWorkflow.clickDeleteSubscriptionConfirmButton(driver);
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.clickActionsButtonFirstRow(driver);
			obj_EsupportProductionValidationsWorkflow.clickDeleteSubscriptionCancelButton(driver);
			
			
			//TC_7107271_AMER_CH_UNI_SReventsubscriptionsforPartnerViewdetailsofanotification & TC_7637119_AMER_CH_UNI_SReventsubscriptionsforCustomerViewdetailsofanotification
			obj_EsupportProductionValidationsWorkflow.verifyActionsButtonOptions(driver);
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.clickActionsButtonViewDetailsOption(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.verifyNotificationPopupDetails(driver);
			obj_EsupportProductionValidationsWorkflow.clickNotificationPopupCloseButton(driver);
			
			//Starts TC_7083727_AMER_CH_SReventsubscriptionsforCPE_Editnotifications
		
			obj_EsupportProductionValidationsWorkflow.clickSREventsNotificationName(driver);
			obj_EsupportProductionValidationsWorkflow.verifySREventNotificationEditableFields(driver);
			obj_EsupportProductionValidationsWorkflow.verifySRNotificationPopupProductsDropdown(driver);
			
			//Check for the Select your Products dropdown as Euser
			obj_EsupportProductionValidationsWorkflow.clickSRNotificationPopupCloseButton(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.signOut(driver);
		
			driver.navigate().to("https://www.dell.com/support/preferences/us/en/04");
			obj_EsupportProductionValidationsWorkflow.clickSignInHereLink_UnifiedProfile(driver);
			Thread.sleep(30000);	
			//obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.clickNotificationsAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.clickSREventsNotificationName(driver);
			obj_EsupportProductionValidationsWorkflow.verifySRNotificationPopupProductsDropdown(driver);
			obj_EsupportProductionValidationsWorkflow.editSREventNotificationclickSave(driver);
			obj_EsupportProductionValidationsWorkflow.clickSREventsNotificationName(driver);
			obj_EsupportProductionValidationsWorkflow.editSREventNotificationclickCancel(driver);
			
			//Starts TC_7637122_AMER_CH_UNI_SReventsubscriptionsforEmployeeViewdetailsofanotification
			
			obj_EsupportProductionValidationsWorkflow.verifyServiceRequestEventsColumns(driver);
			obj_EsupportProductionValidationsWorkflow.verifyActionsButtonOptions(driver);
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.clickActionsButtonViewDetailsOption(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.verifyNotificationPopupDetails(driver);
			obj_EsupportProductionValidationsWorkflow.clickNotificationPopupCloseButton(driver);
					
			//Starts TC_7070299_AMER_CH_SReventsubscriptionsforCPEChangetheorderoffields - Covered in existing flow
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8458116_AMER_CH_UnifiedProfile_Notifications_ProductionAutomation--------->\n  "+e);
		}
	}
}
