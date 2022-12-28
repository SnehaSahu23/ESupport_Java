package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5784146_AMER_ED_SearchScenarios_CreateDateRangesearch_OrderHistory_ESUPPORT extends BaseTest
{	
	@Test
	public void validate_TC_5784146_AMER_ED_SearchScenarios_CreateDateRangesearch_OrderHistory_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# _5784146_AMER_ED");

			obj_EsupportDDLWorkflow.handleCookies(driver);
			obj_EsupportDDLWorkflow.VerifySignInbutton(driver);
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.validemailaddress(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver,TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver);
			obj_EsupportDDLWorkflow.Click_OrderHistoryTab(driver);
			obj_EsupportDDLWorkflow.ToVerify_TablesdataDateRange(driver);
			obj_EsupportDDLWorkflow.SavethisSearch(driver);
			obj_EsupportDDLWorkflow.EnternameinSavethisSearch(driver,TestNGCreator.TestData.get(Esupport.Textarea.ordinal()));
			
			obj_EsupportDDLWorkflow.ToClick_SavedSearches(driver,TestNGCreator.TestData.get(Esupport.Textarea.ordinal()));

		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5784146_AMER_ED_SearchScenarios_CreateDateRangesearch_OrderHistory_ESUPPORT--------->\n  "+e);
		}
	}
}