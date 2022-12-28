package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8458144_AMER_CH_UnifiedProfile_ProductAdvisories_ProductionAutomation_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_8458144_AMER_CH_UnifiedProfile_ProductAdvisories_ProductionAutomation_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8458144_AMER_CH_UnifiedProfile_ProductAdvisories_ProductionAutomation_ESUPPORT");
			//test case ID 7068076
			obj_EsupportProductionValidationsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportProductionValidationsWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductAdvisories(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyDeliveryPreferencesSection(driver);
			
			//test case ID 7068480
			driver.get("https://www.dell.com/support/preferences/us/en/04");
			Thread.sleep(10000);
//			obj_EsupportProductionValidationsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportProductionValidationsWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductAdvisories(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyForAddAlert(driver);
			
			
			//test case ID 7089718
			driver.get("https://www.dell.com/support/preferences/us/en/04");
			Thread.sleep(10000);
//			obj_EsupportProductionValidationsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportProductionValidationsWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductAdvisories(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateListOfExistingProductAdvisoryNotification(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyDeliveryPreferencesSection(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateMyAdvisoryAlertsTabInGrid(driver);
			
			obj_EsupportProductionValidationsWorkflow.ValidateTechnicalTabInGrid(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateSecurityTabInGrid(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateActionsTabInGrid(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyDeliveryPreferencesSection(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyDeliveryPreferencesSection(driver);
			
			obj_EsupportProductionValidationsWorkflow.ValidateClickingOnAllSecurityToggleButton(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateClickingOnAllTechnicalToggleButton(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateClickingFirstDisplayedProductHyperlink(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_8458144_AMER_CH_UnifiedProfile_ProductAdvisories_ProductionAutomation_ESUPPORT--------->\n  "+e);
		}
	}
}
			
