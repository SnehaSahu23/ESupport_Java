package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7185137_AMER_CH_UNI_LiteuserexperienceforUserSettingstab extends BaseTest
{
	@Test
	public void validate_TC_7185137_AMER_CH_UNI_LiteuserexperienceforUserSettingstab() 
	{
		try
		{
			System.out.println("Starts TC_7185137_AMER_CH_UNI_LiteuserexperienceforUserSettingstab");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickUserSettingsTab(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.verifyPreferenceSectionCustomer(driver);
			obj_EsupportUnifiedPortalWorkflow.clickPersonalPreferenceSectionEditButton(driver);
			obj_EsupportUnifiedPortalWorkflow.editPersonalPreferenceFullName(driver);
			obj_EsupportUnifiedPortalWorkflow.editPersonalPreferenceBusinessEmail(driver);
			obj_EsupportUnifiedPortalWorkflow.editPersonalPreferenceAlternateEmail(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			obj_EsupportUnifiedPortalWorkflow.clickPersonalPreferenceSectionEditButton(driver);
			obj_EsupportUnifiedPortalWorkflow.editPersonalPreferencePassword(driver);
			obj_EsupportUnifiedPortalWorkflow.editPersonalPreferencePrimaryPhNum(driver, TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()).split(";")[0]);
			obj_EsupportUnifiedPortalWorkflow.editPersonalPreferenceAlternatePhNum(driver, TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()).split(";")[1]);
			obj_EsupportUnifiedPortalWorkflow.editContactPreferenceContactMethod(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportUnifiedPortalWorkflow.editContactPreferenceContactHours(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportUnifiedPortalWorkflow.clickPersonalPreferenceSectionSaveButton(driver);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7185137_AMER_CH_UNI_LiteuserexperienceforUserSettingstab--------->\n  "+e);
		}
	}
}
