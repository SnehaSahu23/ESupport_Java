package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7863849_AMER_CH_Coveo_ConsistentSearchUX_HomePage_SearchByValidProductMasthead_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7863849_AMER_CH_Coveo_ConsistentSearchUX_HomePage_SearchByValidProductMasthead_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7863849_AMER_CH_Coveo_ConsistentSearchUX_HomePage_SearchByValidProductMasthead_ESUPPORT");
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			
			obj_EsupportCoveoWorkflow.SearchLatiInMastHeadAndSearchAutoDisplayedResults(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordLatiAndSelectFirstResultFromSearchResultsAutoDisplayedResult(driver);
			obj_EsupportContentWorkflow.NavigateBack(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordLatiAndSelectFirstResultFromAutoDisplayedResultProductSupportPage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportContentWorkflow.NavigateBack(driver);

			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordLatiAndClickOnViewAllResultsForAutoDisplayedResult(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			
//			obj_EsupportCoveoWorkflow.SearchLatiInMastHeadAndSearchAutoDisplayedResults(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordLatiAndSelectFirstResultFromAutoDisplayedResultProductSupportPage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7863849_AMER_CH_Coveo_ConsistentSearchUX_HomePage_SearchByValidProductMasthead_ESUPPORT  "+e);
		}
	}
}
