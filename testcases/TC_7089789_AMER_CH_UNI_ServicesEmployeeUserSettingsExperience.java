package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_7089789_AMER_CH_UNI_ServicesEmployeeUserSettingsExperience extends BaseTest
{
	@Test
	public void validate_TC_7089789_AMER_CH_UNI_ServicesEmployeeUserSettingsExperience() 
	{
		try
		{
			System.out.println("Starts TC_7089789_AMER_CH_UNI_ServicesEmployeeUserSettingsExperience");
			Thread.sleep(10000);
			obj_EsupportUnifiedPortalWorkflow.clickSignInHereLink(driver);
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportUnifiedPortalWorkflow.clickUserSettingsTab(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.validatePersonalPreferenceSection(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferencesTooltip(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferenceSectionOnClickingEdit(driver);
			obj_EsupportUnifiedPortalWorkflow.clickPersonalPreferenceSectionSaveButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7089789_AMER_CH_UNI_ServicesEmployeeUserSettingsExperience--------->\n  "+e);
		}
	}
}
