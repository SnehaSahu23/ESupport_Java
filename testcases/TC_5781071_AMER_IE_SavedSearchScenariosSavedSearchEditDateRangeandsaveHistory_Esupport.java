package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5781071_AMER_IE_SavedSearchScenariosSavedSearchEditDateRangeandsaveHistory_Esupport extends BaseTest {
	@Test
	public void validate_TC_5781071_AMER_IE_SavedSearchScenariosSavedSearchEditDateRangeandsaveHistory_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5781071_AMER_IE_SavedSearchScenariosSavedSearchEditDateRangeandsaveHistory_Esupport");

			
			
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.handleCookies(driver);
			obj_EsupportDDLWorkflow.validemailaddress(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver, TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver); 
			obj_EsupportDDLWorkflow.ToClick_SavedSearchTab(driver); 
			obj_EsupportDDLWorkflow.ToClick_SavedSearchTabEditTab(driver);
			obj_EsupportDDLWorkflow.ToVerify_TablesdataDateRange(driver);			
			obj_EsupportDDLWorkflow.SavethisSearch(driver);
			obj_EsupportDDLWorkflow.clickSaveSubmitSearch(driver);
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5781071_AMER_IE_SavedSearchScenariosSavedSearchEditDateRangeandsaveHistory_Esupport--------->\n  "+e);
		}
	}
}


