package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8594395_AMER_CH_UnifiedProfile_UserInformations_ProductionAutomation extends BaseTest
{
	@Test
	public void validate_TC_8594395_AMER_CH_UnifiedProfile_UserInformations_ProductionAutomation()
	{
		try
		{
			System.out.println("Starts TC_8594395_AMER_CH_UnifiedProfile_UserInformations_ProductionAutomation");
			
			//TC_7090256_AMER_CH_UNI_CustomerpartnerUsershouldbeabletoviewmyUserSettings
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickUserSettingsTab(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.verifyPreferenceSectionCustomer(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferenceFullName(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferenceBusinessEmail(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferenceAlternateEmail(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferencePassword(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferencePrimaryPhNum(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferenceAlternatePhNum(driver);
			obj_EsupportProductionValidationsWorkflow.verifyContactPreferenceInitialMethod(driver);
			obj_EsupportProductionValidationsWorkflow.verifyContactPreferenceContactHours(driver);
			
			//TC_7068494_AMER_CH_UNI_CustomerandpartnerUsershouldbeabletoEditUserSettings

			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickPersonalPreferenceSectionEditButton(driver);
			obj_EsupportProductionValidationsWorkflow.editPersonalPreferenceFullName(driver);
			obj_EsupportProductionValidationsWorkflow.editPersonalPreferenceBusinessEmail(driver);
			obj_EsupportProductionValidationsWorkflow.editPersonalPreferenceAlternateEmail(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			obj_EsupportProductionValidationsWorkflow.clickPersonalPreferenceSectionEditButton(driver);
			obj_EsupportProductionValidationsWorkflow.editPersonalPreferencePassword(driver);
			obj_EsupportProductionValidationsWorkflow.editPersonalPreferencePrimaryPhNum(driver, TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.editPersonalPreferenceAlternatePhNum(driver, TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()).split(";")[1]);
			obj_EsupportProductionValidationsWorkflow.editContactPreferenceContactMethod(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.editContactPreferenceContactHours(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportProductionValidationsWorkflow.clickPersonalPreferenceSectionSaveButton(driver);
			
			
			
			//Starts TC_7090833_AMER_CH_UNI_UserSettingsViewforServiceenabledEmployeeUser
			obj_EsupportProductionValidationsWorkflow.signOut(driver);
			driver.get("https://www.dell.com/support/preferences/us/en/04");
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.clickSignInHereLink_UnifiedProfile(driver);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.clickUserSettingsTab(driver);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.verifyPreferenceSectionEmployee(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferenceFullName(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferenceBusinessEmail(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferenceAlternateEmailEmployee(driver);
	
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferencesPasswordDisabled(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferencePrimaryPhNumDisplayedEmployee(driver);
			
			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferenceAlternatePhNumEmployee(driver);
			
			obj_EsupportProductionValidationsWorkflow.verifyContactPreferenceInitialMethod(driver);
			obj_EsupportProductionValidationsWorkflow.verifyContactPreferenceContactHours(driver);
			
			//Starts TC_7103481_AMER_CH_UsersettingsViewforNonServicesEmployeeUser

			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.validatePersonalPreferenceSection(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferencesTooltip(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferencesPasswordDisabled(driver);
			
//			//TC_7089789_AMER_CH_UNI_ServicesEmployeeUserSettingsExperience

			Thread.sleep(5000);	

			obj_EsupportProductionValidationsWorkflow.verifyPersonalPreferenceSectionOnClickingEdit(driver);
			obj_EsupportProductionValidationsWorkflow.clickPersonalPreferenceSectionSaveButton(driver);
			
			//TC_7090444_AMER_CH_UNI_ServiceenabledEmployeeusershouldbeabletoeditmycontactpreferenceswithinUserSettings
			//Steps are already covered in previous steps
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8594395_AMER_CH_UnifiedProfile_UserInformations_ProductionAutomation--------->\n  "+e);
		}
	}
}
