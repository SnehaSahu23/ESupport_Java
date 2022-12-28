package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7863878_AMER_FF_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadSearch_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7863878_AMER_FF_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadSearch_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7863878_AMER_FF_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadSearch_ESUPPORT");
			
			obj_EsupportCoveoWorkflow.ToNavigate_SearchSupportPage(driver);
			
			obj_EsupportCoveoWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButton(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButton(driver);
			
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7863878_AMER_FF_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadSearch_ESUPPORT--------->\n  "+e);
		}
	}
}
