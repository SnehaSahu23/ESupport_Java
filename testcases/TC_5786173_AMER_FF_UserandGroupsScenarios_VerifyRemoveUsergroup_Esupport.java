package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5786173_AMER_FF_UserandGroupsScenarios_VerifyRemoveUsergroup_Esupport extends BaseTest
{	
	@Test
	public void validate_TC_5786173_AMER_FF_UserandGroupsScenarios_VerifyRemoveUsergroup_Esupport() 
	{
		String UserGroupName;
		try
		{
			System.out.println("Starts TC#TC_5786173_AMER_FF_UserandGroupsScenarios_VerifyRemoveUsergroup_Esupport");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.ToClick_UserGroups(driver);
			obj_EsupportDDLWorkflow.ToVerify_UsersTab(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsTab(driver);
			obj_EsupportDDLWorkflow.ToVerify_EditandRemoveoptions_UserGroups(driver);
			UserGroupName=obj_EsupportDDLWorkflow.Click_onRemoveLink(driver);
			obj_EsupportDDLWorkflow.Click_onCancelinpopupwindow(driver);
			obj_EsupportDDLWorkflow.To_Verifyusergroup_inusergroupsgrid(driver,UserGroupName);
			UserGroupName=obj_EsupportDDLWorkflow.Click_onRemoveLink(driver);
			obj_EsupportDDLWorkflow.Click_deleteinpopupwindow(driver);
			obj_EsupportDDLWorkflow.To_Verifyusergroup_inusergroupsgrid_afterDeleting(driver,UserGroupName);

		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5786173_AMER_FF_UserandGroupsScenarios_VerifyRemoveUsergroup_Esupport--------->\n  "+e);
		}
	}
}
