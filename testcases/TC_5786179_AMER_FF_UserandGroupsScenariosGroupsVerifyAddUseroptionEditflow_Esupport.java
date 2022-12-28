package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5786179_AMER_FF_UserandGroupsScenariosGroupsVerifyAddUseroptionEditflow_Esupport extends BaseTest
{	
	@Test
	public void validate_TC_5786179_AMER_FF_UserandGroupsScenariosGroupsVerifyAddUseroptionEditflow_Esupport() 
	{
		
		try
		{
			System.out.println("Starts  TC_5786179_AMER_FF_UserandGroupsScenariosGroupsVerifyAddUseroptionEditflow_Esupport");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.ToClick_UserGroups(driver);
			obj_EsupportDDLWorkflow.ToVerify_UsersTab(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsTab(driver);
			
			obj_EsupportDDLWorkflow.ToVerify_EditandRemoveoptions_UserGroups(driver);
			
			obj_EsupportDDLWorkflow.clickEditLinkUserGroups(driver);
			
			
			obj_EsupportDDLWorkflow.ToVerify_UserGroupsTablesdata(driver);
			
			obj_EsupportDDLWorkflow.verifyRoleDropdown(driver);
			obj_EsupportDDLWorkflow.verifyRemoveButtonUser(driver);
			
			Thread.sleep(5000);

			obj_EsupportDDLWorkflow.verifyAddUserLinkInEditUserGroup(driver);
			
			obj_EsupportDDLWorkflow.clickAddUserLinkInEditUserGroup(driver);
			Thread.sleep(5000);
			
			//obj_EsupportDDLWorkflow.clickRoleDropdownandSave(driver);
			
			obj_EsupportDDLWorkflow.clickAssignedTab(driver);
			Thread.sleep(5000);
			obj_EsupportDDLWorkflow.clickRoleDropdownandSave(driver);
			
			obj_EsupportDDLWorkflow.clickAddUserLinkInEditUserGroup(driver);
			obj_EsupportDDLWorkflow.clickAssignedTab(driver);
			
			obj_EsupportDDLWorkflow.clickAddNewUserButton(driver);
			obj_EsupportDDLWorkflow.ToEnterUname(driver, TestNGCreator.TestData.get(Esupport.FirstName.ordinal()),TestNGCreator.TestData.get(Esupport.LastName.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()),"SuperAdmin");
			obj_EsupportDDLWorkflow.ToClick_Submit_AddNewUser(driver);
			//obj_EsupportDDLWorkflow.ToVerify_UserSavedmessage(driver);
			obj_EsupportDDLWorkflow.clickReturnToEditUserGroupLink(driver);
			
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case  TC_5786179_AMER_FF_UserandGroupsScenariosGroupsVerifyAddUseroptionEditflow_Esupport--------->\n  "+e);
		}
	}
}
