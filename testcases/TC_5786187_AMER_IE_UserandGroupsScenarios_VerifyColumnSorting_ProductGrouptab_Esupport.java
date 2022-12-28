

package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5786187_AMER_IE_UserandGroupsScenarios_VerifyColumnSorting_ProductGrouptab_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5786187_AMER_IE_UserandGroupsScenarios_VerifyColumnSorting_ProductGrouptab_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# _5786187_AMER_IE");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.ToClick_UserGroups(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsProdutsTab(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsProdutsRadioBtn(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsColoumnHeader(driver);
			
			obj_EsupportDDLWorkflow.ToClick_UserGroupsColoumnHeaderclickPG(driver);
			
			
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5786187_AMER_IE_UserandGroupsScenarios_VerifyColumnSorting_ProductGrouptab_Esupport--------->\n  "+e);
		}
	}
}


