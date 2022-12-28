package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8458165_AMER_CH_UnifiedProfile_ProductsUpdates_ProductionAutomation_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_8458165_AMER_CH_UnifiedProfile_ProductsUpdates_ProductionAutomation_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8458165_AMER_CH_UnifiedProfile_ProductsUpdates_ProductionAutomation_ESUPPORT");
			
			//test case ID 7061479
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportProductionValidationsWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductUpdatesTab(driver);

			obj_EsupportProductionValidationsWorkflow.VerifyDeliveryPreferencesSectionInProductUpdatesTab(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyDefaultEmailAddress(driver);
			obj_EsupportProductionValidationsWorkflow.ChangeEmailInProductUpdates(driver);
			
	
			obj_EsupportProductionValidationsWorkflow.ValidateEmailChangeInProductUpdates(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyInformationIconDisplayedNextToEmailField(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnInofrmationIconInProductUpdatesTab(driver);
			
			obj_EsupportProductionValidationsWorkflow.CheckForExistingNotificationsInProductsUpdates(driver);
			
			obj_EsupportProductionValidationsWorkflow.CheckForNumberOfResultsUserCanSelectForPagination(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyDefaultNumberOfResultsInAPage(driver);

			obj_EsupportProductionValidationsWorkflow.VerifyIfUserCanEnterNumberInTextBoxAndNavigateThroghPagesWithTheHelpOfPagination(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);

			obj_EsupportProductionValidationsWorkflow.ValidatePaginationSectionDisabledForSinglePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);

			obj_EsupportProductionValidationsWorkflow.VerifyDefaultSortOfGridPage(driver);

			obj_EsupportProductionValidationsWorkflow.SortRecordsInDescendingOrderInProductUpdatesGrid(driver);
			
			// test case id 7061546
			driver.get("https://www.dell.com/support/preferences/us/en/04");
			Thread.sleep(10000);
//			obj_EsupportProductionValidationsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportProductionValidationsWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductUpdatesTab(driver);

			obj_EsupportProductionValidationsWorkflow.CheckIfNoAddedNotificationsInProductUpdatesForNoExistingNotifications(driver);
			obj_EsupportProductionValidationsWorkflow.CheckForExistingNotificationsInProductsUpdates(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnAddNotificationButton(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyCancelAndAddProductButtons(driver);
			
			
			obj_EsupportProductionValidationsWorkflow.ClickXMarkAtTopRightOfPopUp(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnAddNotificationButton(driver);
			
			obj_EsupportProductionValidationsWorkflow.SerachForAProductAndClickOnCancel(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportProductionValidationsWorkflow.SerachForAProductAndClickOnAddProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnAddNotificationButton(driver);
			obj_EsupportProductionValidationsWorkflow.SearchForADuplicateProductAndClickOnAddProduct(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyAlertMessageForDuplicateProductAddition(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickXMarkAtTopRightOfPopUp(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnDeleteButtonForOneProductInTheProductUpdatesNotificationList(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportProductionValidationsWorkflow.ClickOnConfirmButtonInDeleteNotificationPopUp(driver);
			
			//test case ID 7064069
			driver.get("https://www.dell.com/support/preferences/us/en/04");
			Thread.sleep(10000);
//			obj_EsupportProductionValidationsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportProductionValidationsWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductUpdatesTab(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyProductUpdatesSection(driver);
			

			obj_EsupportProductionValidationsWorkflow.VerifyDeliveryPreferencesSectionInProductUpdatesTab(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductAdvisories(driver);
			obj_EsupportProductionValidationsWorkflow.ChangeEmailInProductAdvisoryAndCheckInProductUpdates(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnProductUpdatesTab(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateEmailChangeInProductUpdates(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyInformationIconDisplayedNextToEmailField(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnInofrmationIconInProductUpdatesTab(driver);
			
			//test case ID 7064216
			driver.get("https://www.dell.com/support/preferences/us/en/04");
			Thread.sleep(10000);
//			obj_EsupportProductionValidationsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportProductionValidationsWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductUpdatesTab(driver);

			obj_EsupportProductionValidationsWorkflow.CheckIfNoAddedNotificationsInProductUpdatesForNoExistingNotifications(driver);
			obj_EsupportProductionValidationsWorkflow.CheckForExistingNotificationsInProductsUpdates(driver);
			
			//test case ID 7065126
			driver.get("https://www.dell.com/support/preferences/us/en/04");
			Thread.sleep(10000);
//			obj_EsupportProductionValidationsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportProductionValidationsWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductUpdatesTab(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyForAddNotification(driver);
			
			//test case ID 7065222
			driver.get("https://www.dell.com/support/preferences/us/en/04");
			Thread.sleep(10000);
//			obj_EsupportProductionValidationsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportProductionValidationsWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductUpdatesTab(driver);

			obj_EsupportProductionValidationsWorkflow.CheckIfNoAddedNotificationsInProductUpdatesForNoExistingNotifications(driver);
			obj_EsupportProductionValidationsWorkflow.CheckForExistingNotificationsInProductsUpdates(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnAddNotificationButton(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyCancelAndAddProductButtons(driver);
			
			
			obj_EsupportProductionValidationsWorkflow.ClickXMarkAtTopRightOfPopUp(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnAddNotificationButton(driver);
			
			obj_EsupportProductionValidationsWorkflow.SerachForAProductAndClickOnCancel(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportProductionValidationsWorkflow.SerachForAProductAndClickOnAddProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnAddNotificationButton(driver);
			obj_EsupportProductionValidationsWorkflow.SearchForADuplicateProductAndClickOnAddProduct(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyAlertMessageForDuplicateProductAddition(driver);
			obj_EsupportProductionValidationsWorkflow.ClickXMarkAtTopRightOfPopUp(driver);
			
			//test case ID 7065380
			driver.get("https://www.dell.com/support/preferences/us/en/04");
			Thread.sleep(10000);
//			obj_EsupportProductionValidationsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportProductionValidationsWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductUpdatesTab(driver);

			obj_EsupportProductionValidationsWorkflow.ClickOnDeleteButtonForOneProductInTheProductUpdatesNotificationList(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportProductionValidationsWorkflow.ClickOnXOrCancelButtonInDeletePopUp(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnDeleteButtonForOneProductInTheProductUpdatesNotificationList(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportProductionValidationsWorkflow.ClickOnConfirmButtonInDeleteNotificationPopUp(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8458165_AMER_CH_UnifiedProfile_ProductsUpdates_ProductionAutomation_ESUPPORT--------->\n  "+e);
		}
	}
}
