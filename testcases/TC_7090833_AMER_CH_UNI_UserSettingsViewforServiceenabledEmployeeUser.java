package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7090833_AMER_CH_UNI_UserSettingsViewforServiceenabledEmployeeUser extends BaseTest
{
	@Test
	public void validate_TC_7090833_AMER_CH_UNI_UserSettingsViewforServiceenabledEmployeeUser() 
	{
		try
		{
			System.out.println("Starts TC_7090833_AMER_CH_UNI_UserSettingsViewforServiceenabledEmployeeUser");
			Thread.sleep(10000);	
			//obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportUnifiedPortalWorkflow.clickSignInHereLink(driver);
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.clickUserSettingsTab(driver);
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.verifyPreferenceSectionEmployee(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceFullName(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceBusinessEmail(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceAlternateEmailEmployee(driver);
	
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferencesPasswordDisabled(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferencePrimaryPhNumDisplayedEmployee(driver);
			
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceAlternatePhNumEmployee(driver);
			
			obj_EsupportUnifiedPortalWorkflow.verifyContactPreferenceInitialMethod(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyContactPreferenceContactHours(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7090833_AMER_CH_UNI_UserSettingsViewforServiceenabledEmployeeUser--------->\n  "+e);
		}
	}
}
