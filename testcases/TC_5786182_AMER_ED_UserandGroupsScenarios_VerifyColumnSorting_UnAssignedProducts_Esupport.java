

package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5786182_AMER_ED_UserandGroupsScenarios_VerifyColumnSorting_UnAssignedProducts_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5786182_AMER_ED_UserandGroupsScenarios_VerifyColumnSorting_UnAssignedProducts_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# _5786182_AMER_ED");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.ToClick_UserGroups(driver);
		
			obj_EsupportDDLWorkflow.ToClick_UserGroupsProdutsTab(driver);
		
			obj_EsupportDDLWorkflow.ToVerify_ClickUnAssignedRadioProduct(driver);
			obj_EsupportDDLWorkflow.ToVerify_UnassignProductGroupsLNAscending(driver);
			obj_EsupportDDLWorkflow.ToClick_UnassignedproductsLNDescending(driver);
			
			obj_EsupportDDLWorkflow.ToClick_UserGroupsproductnamecustomernumber(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsproductnameOrdernumber(driver);
			
			
			obj_EsupportDDLWorkflow.ToClick_UserGroupsproductnameShipdate(driver);
			obj_EsupportDDLWorkflow.ToClick_UserGroupsproductnamePrimaryID(driver);
			
			
			
			
			
			
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5786182_AMER_ED_UserandGroupsScenarios_VerifyColumnSorting_UnAssignedProducts_Esupport--------->\n  "+e);
		}
	}
}



