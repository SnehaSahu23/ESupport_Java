package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5786192_AMER_CH_UserandGroupsScenariosRolesPermissionsVerifyCreateUserGroupSuperAdmin_Esupport extends BaseTest
{	
	@Test
	public void validate_TC_5786192_AMER_CH_UserandGroupsScenariosRolesPermissionsVerifyCreateUserGroupSuperAdmin_Esupport() 
	{
		
		try
		{
			System.out.println("Starts TC_5786192_AMER_CH_UserandGroupsScenariosRolesPermissionsVerifyCreateUserGroupSuperAdmin_Esupport");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.ToClick_UserGroups(driver);
			obj_EsupportDDLWorkflow.ToVerify_UsersTab(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsTab(driver);
		
			obj_EsupportDDLWorkflow.ToVerify_AddUserGroupbutton(driver);
			obj_EsupportDDLWorkflow.ToClick_AddaUserGroup(driver);
			
			obj_EsupportDDLWorkflow.ToEnterUGname(driver, TestNGCreator.TestData.get(Esupport.Textarea.ordinal()).split(";")[0],"SuperAdmin");

			obj_EsupportDDLWorkflow.ToVerify_AddNewUser(driver);
			obj_EsupportDDLWorkflow.ToClick_AddNewUser(driver);
			
			obj_EsupportDDLWorkflow.ToEnterUname(driver, TestNGCreator.TestData.get(Esupport.FirstName.ordinal()),TestNGCreator.TestData.get(Esupport.LastName.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()),"SuperAdmin");
			obj_EsupportDDLWorkflow.ToClick_Submit_AddNewUser(driver);
			Thread.sleep(6000);
  		    obj_EsupportDDLWorkflow.ToVerify_UserSavedmessage(driver);
  		  Thread.sleep(6000);
			obj_EsupportDDLWorkflow.ToClick_ReturntoAddUserGrouplink(driver);
			
			
			obj_EsupportDDLWorkflow.clickUserGroupContinueButton(driver);
			obj_EsupportDDLWorkflow.clickProductGroupContinueButton(driver);
			
			obj_EsupportDDLWorkflow.selectProductGroup(driver);
			Thread.sleep(6000);
			//obj_EsupportDDLWorkflow.ToVerify_Paginations_SaveSearch(driver);
			obj_EsupportDDLWorkflow.verifyUserGroupNameandEdit(driver);
			obj_EsupportDDLWorkflow.enterEditUserGroupName(driver, TestNGCreator.TestData.get(Esupport.Textarea.ordinal()).split(";")[1]);
			
			obj_EsupportDDLWorkflow.clickOnSubmitButton(driver);
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5786192_AMER_CH_UserandGroupsScenariosRolesPermissionsVerifyCreateUserGroupSuperAdmin_Esupport--------->\n  "+e);
		}
	}
}
