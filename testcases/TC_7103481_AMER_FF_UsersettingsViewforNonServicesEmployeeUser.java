package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_7103481_AMER_FF_UsersettingsViewforNonServicesEmployeeUser extends BaseTest
{
	@Test
	public void validate_TC_7103481_AMER_FF_UsersettingsViewforNonServicesEmployeeUser() 
	{
		try
		{
			System.out.println("Starts TC_7103481_AMER_FF_UsersettingsViewforNonServicesEmployeeUser");
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			Thread.sleep(10000);
		//	obj_EsupportIPSWorkflow.employeeLogin_Firefox(driver);
			obj_EsupportUnifiedPortalWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			obj_EsupportUnifiedPortalWorkflow.clickUserSettingsTab(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.validatePersonalPreferenceSection(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferencesTooltip(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPersonalPreferencesPasswordDisabled(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7103481_AMER_FF_UsersettingsViewforNonServicesEmployeeUser--------->\n  "+e);
		}
	}
}
