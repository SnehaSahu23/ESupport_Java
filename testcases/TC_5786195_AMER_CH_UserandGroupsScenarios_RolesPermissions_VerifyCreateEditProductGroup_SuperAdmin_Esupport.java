
package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5786195_AMER_CH_UserandGroupsScenarios_RolesPermissions_VerifyCreateEditProductGroup_SuperAdmin_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5786195_AMER_CH_UserandGroupsScenarios_RolesPermissions_VerifyCreateEditProductGroup_SuperAdmin_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# _5786195_AMER_CH");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.ToClick_UserGroups(driver);
		
			obj_EsupportDDLWorkflow.ToClick_UserGroupsProdutsTab(driver);
			
			obj_EsupportDDLWorkflow.ToClick_AddaProductname(driver);
			
			obj_EsupportDDLWorkflow.ToClick_availableAddProducts(driver);
			obj_EsupportDDLWorkflow.ToVerify_productGroupName(driver);
			
			
			Thread.sleep(10000);
			
			
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5786195_AMER_CH_UserandGroupsScenarios_RolesPermissions_VerifyCreateEditProductGroup_SuperAdmin_Esupport--------->\n  "+e);
		}
	}
}


