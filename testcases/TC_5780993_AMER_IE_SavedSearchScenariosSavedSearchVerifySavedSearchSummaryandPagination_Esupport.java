package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5780993_AMER_IE_SavedSearchScenariosSavedSearchVerifySavedSearchSummaryandPagination_Esupport extends BaseTest {
	@Test
	public void validate_TC_5780993_AMER_IE_SavedSearchScenariosSavedSearchVerifySavedSearchSummaryandPagination_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5780993_AMER_IE_SavedSearchScenariosSavedSearchVerifySavedSearchSummaryandPagination_Esupport");

			
			
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.handleCookies(driver);
			
			//obj_EsupportDDLWorkflow.verifySignInPageElements(driver);
			obj_EsupportDDLWorkflow.validemailaddress(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver, TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver); 
			obj_EsupportDDLWorkflow.ToClick_SavedSearchTab(driver); 
			obj_EsupportDDLWorkflow.verifyNumOfItems(driver);
			obj_EsupportDDLWorkflow.verifyPagesinSaveSearch(driver);
			obj_EsupportDDLWorkflow.ToVerify_Paginations_SaveSearch(driver);


			obj_EsupportDDLWorkflow.ToVerify_TablesdataTenSaveSearch(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[0]);
			obj_EsupportDDLWorkflow.ToVerify_TablesdataTenSaveSearch(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[1]);
			obj_EsupportDDLWorkflow.ToVerify_TablesdataTenSaveSearch(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[2]);
			obj_EsupportDDLWorkflow.ToVerify_TablesdataTenSaveSearch(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[3]);

			
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5780993_AMER_IE_SavedSearchScenariosSavedSearchVerifySavedSearchSummaryandPagination_Esupport--------->\n  "+e);
		}
	}
}

