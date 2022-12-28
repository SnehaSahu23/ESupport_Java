package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7090256_AMER_CH_UNI_CustomerpartnerUsershouldbeabletoviewmyUserSettings extends BaseTest
{
	@Test
	public void validate_TC_7090256_AMER_CH_UNI_CustomerpartnerUsershouldbeabletoviewmyUserSettings() 
	{
		try
		{
			System.out.println("Starts TC_7090256_AMER_CH_UNI_CustomerpartnerUsershouldbeabletoviewmyUserSettings");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickUserSettingsTab(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.verifyPreferenceSectionCustomer(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceFullName(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceBusinessEmail(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceAlternateEmail(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferencePassword(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferencePrimaryPhNum(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceAlternatePhNum(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyContactPreferenceInitialMethod(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyContactPreferenceContactHours(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7090256_AMER_CH_UNI_CustomerpartnerUsershouldbeabletoviewmyUserSettings--------->\n  "+e);
		}
	}
}
