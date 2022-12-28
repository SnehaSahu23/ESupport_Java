package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7090444_AMER_CH_UNI_ServiceenabledEmployeeusershouldbeabletoeditmycontactpreferenceswithinUserSettings extends BaseTest
{
	@Test
	public void validate_TC_7090444_AMER_CH_UNI_ServiceenabledEmployeeusershouldbeabletoeditmycontactpreferenceswithinUserSettings() 
	{
		try
		{
			System.out.println("Starts TC_7090444_AMER_CH_UNI_ServiceenabledEmployeeusershouldbeabletoeditmycontactpreferenceswithinUserSettings");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportUnifiedPortalWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickUserSettingsTab(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.verifyPreferenceSectionEmployee(driver);
			obj_EsupportUnifiedPortalWorkflow.clickPersonalPreferenceSectionEditButton(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceFullNameEmployee(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceBusinessEmailEmployee(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceAlternateEmailEmployee(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferencesPasswordDisabled(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferencePrimaryPhNumEmployee(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceAlternatePhNumEmployee(driver);
			obj_EsupportUnifiedPortalWorkflow.editContactPreferenceContactMethod(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportUnifiedPortalWorkflow.editContactPreferenceContactHours(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportUnifiedPortalWorkflow.clickPersonalPreferenceSectionSaveButton(driver);		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7068494_AMER_CH_UNI_CustomerandpartnerUsershouldbeabletoEditUserSettings--------->\n  "+e);
		}
	}
}
