package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5786169_AMER_FF_UserandGroupsScenarios_VerifySortingUsers_GroupspageallTabs_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5786169_AMER_FF_UserandGroupsScenarios_VerifySortingUsers_GroupspageallTabs_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# TC_5786169_AMER_FF_UserandGroupsScenarios_VerifySortingUsers_GroupspageallTabs_Esupport");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.ToClick_UserGroups(driver);
			
			obj_EsupportDDLWorkflow.ToVerify_UserGroupsTablesdataUsergroup(driver);
			obj_EsupportDDLWorkflow.ToVerify_UserGroupsTablesdata(driver);
			obj_EsupportDDLWorkflow.ToVerify_UserGroupsLNAscending(driver);
			
			obj_EsupportDDLWorkflow.ToClick_UserGroupsLNDescending(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsTabdata(driver);
			
			obj_EsupportDDLWorkflow.ToVerify_UserGroupsNameTabdata(driver);
			obj_EsupportDDLWorkflow.ToVerify_ClickUserGroupsNameTabdata(driver);
			
			obj_EsupportDDLWorkflow.ToClick_UserGroupsProdutsTab(driver);
			
			obj_EsupportDDLWorkflow.ToClick_UserGroupsProdutsRadioBtn(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsColoumnHeader(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsColoumnHeaderclickPG(driver);
			
			obj_EsupportDDLWorkflow.ToVerify_ClickUnAssignedRadioProduct(driver);
			obj_EsupportDDLWorkflow.ToVerify_UnassignProductGroupsLNAscending(driver);
			obj_EsupportDDLWorkflow.ToClick_UnassignedproductsLNDescending(driver);
			
			
			
			obj_EsupportDDLWorkflow.ToClick_RemoversUsersTabdata(driver);
			obj_EsupportDDLWorkflow.ToVerify_RemoveuserNameTabdataascending(driver);
			obj_EsupportDDLWorkflow.ToVerify_RemoversTablastnameDescending(driver);
			
			
			
			
			
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5786169_AMER_FF_UserandGroupsScenarios_VerifySortingUsers_GroupspageallTabs_Esupport--------->\n  "+e);
		}
	}
}
