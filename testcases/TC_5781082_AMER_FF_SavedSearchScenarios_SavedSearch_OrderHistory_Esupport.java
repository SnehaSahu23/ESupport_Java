package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5781082_AMER_FF_SavedSearchScenarios_SavedSearch_OrderHistory_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5781082_AMER_FF_SavedSearchScenarios_SavedSearch_OrderHistory_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# TC_5781082_AMER_FF_SavedSearchScenarios_SavedSearch_OrderHistory_Esupport");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ToClick_SavedSearchTab(driver);

			obj_EsupportDDLWorkflow.ToClick_SavedSearchTabEditTab(driver);
			obj_EsupportDDLWorkflow.ToClick_OrderhistoryEditlink(driver,TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
			obj_EsupportDDLWorkflow.SavethisSearch(driver);

			obj_EsupportDDLWorkflow.clickSaveSubmitSearch(driver);




		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5781082_AMER_FF_SavedSearchScenarios_SavedSearch_OrderHistory_Esupport--------->\n  "+e);
		}
	}
}
