package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7061479_AMER_CH_UnifiedPortal_ProductUpdatesTab_ProductUpdateSubscriptionsForC_P_E_Users_ListOfNotifications_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7061479_AMER_CH_UnifiedPortal_ProductUpdatesTab_ProductUpdateSubscriptionsForC_P_E_Users_ListOfNotifications_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7061479_AMER_CH_UnifiedPortal_ProductUpdatesTab_ProductUpdateSubscriptionsForC_P_E_Users_ListOfNotifications_ESUPPORT");
			
//			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportUnifiedPortalWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.ClickOnProductUpdatesTab(driver);

			obj_EsupportUnifiedPortalWorkflow.VerifyDeliveryPreferencesSectionInProductUpdatesTab(driver);
			obj_EsupportUnifiedPortalWorkflow.VerifyDefaultEmailAddress(driver);
			obj_EsupportUnifiedPortalWorkflow.ChangeEmailInProductUpdates(driver);
			
	
			obj_EsupportUnifiedPortalWorkflow.ValidateEmailChangeInProductUpdates(driver);
			
			obj_EsupportUnifiedPortalWorkflow.VerifyInformationIconDisplayedNextToEmailField(driver);
			
			obj_EsupportUnifiedPortalWorkflow.ClickOnInofrmationIconInProductUpdatesTab(driver);
			
			obj_EsupportUnifiedPortalWorkflow.CheckForExistingNotificationsInProductsUpdates(driver);
			
			obj_EsupportUnifiedPortalWorkflow.CheckForNumberOfResultsUserCanSelectForPagination(driver);
			obj_EsupportUnifiedPortalWorkflow.VerifyDefaultNumberOfResultsInAPage(driver);

			obj_EsupportUnifiedPortalWorkflow.VerifyIfUserCanEnterNumberInTextBoxAndNavigateThroghPagesWithTheHelpOfPagination(driver);

			obj_EsupportUnifiedPortalWorkflow.ValidatePaginationSectionDisabledForSinglePage(driver);

			obj_EsupportUnifiedPortalWorkflow.VerifyDefaultSortOfGridPage(driver);

			obj_EsupportUnifiedPortalWorkflow.SortRecordsInDescendingOrderInProductUpdatesGrid(driver);


		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7061479_AMER_CH_UnifiedPortal_ProductUpdatesTab_ProductUpdateSubscriptionsForC_P_E_Users_ListOfNotifications_ESUPPORT--------->\n  "+e);

		}

	}
}
