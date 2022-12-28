package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5786189_AMER_IE_UserandGroupsScenarios_Roles_Permissions_VerifyAddUserspage_SuperAdmin_Esupport extends BaseTest
{	
	@Test
	public void validate_TC_5786189_AMER_IE_UserandGroupsScenarios_Roles_Permissions_VerifyAddUserspage_SuperAdmin_Esupport() 
	{
		
		try
		{
			System.out.println("Starts TC#_5786189_AMER_IE");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.ToClick_UserGroups(driver);
			obj_EsupportDDLWorkflow.ToVerify_UsersTab(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsTab(driver);
		
			obj_EsupportDDLWorkflow.ToVerify_AddUserGroupbutton(driver);
			obj_EsupportDDLWorkflow.ToClick_AddaUserGroup(driver);
			obj_EsupportDDLWorkflow.ToEnterUGname(driver, TestNGCreator.TestData.get(Esupport.Textarea.ordinal()),"SuperAdmin");
			obj_EsupportDDLWorkflow.ToVerify_unassignedandAssignedUserstabs(driver);
			obj_EsupportDDLWorkflow.ToVerify_AddNewUser(driver);
			obj_EsupportDDLWorkflow.ToClick_AddNewUser(driver);
			obj_EsupportDDLWorkflow.ToEnterUname(driver, TestNGCreator.TestData.get(Esupport.FirstName.ordinal()),TestNGCreator.TestData.get(Esupport.LastName.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()),"SuperAdmin");
			obj_EsupportDDLWorkflow.ToClick_Submit_AddNewUser(driver);
			obj_EsupportDDLWorkflow.ToVerify_UserSavedmessage(driver);
			obj_EsupportDDLWorkflow.ToClick_ReturntoAddUserGrouplink(driver);
			
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5786189_AMER_IE_UserandGroupsScenarios_Roles_Permissions_VerifyAddUserspage_SuperAdmin_Esupport--------->\n  "+e);
		}
	}
}