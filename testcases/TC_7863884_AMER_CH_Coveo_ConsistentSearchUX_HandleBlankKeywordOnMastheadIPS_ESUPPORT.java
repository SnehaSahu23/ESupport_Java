package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7863884_AMER_CH_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadIPS_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7863884_AMER_CH_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadIPS_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7863884_AMER_CH_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadIPS_ESUPPORT");
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchingServiceTagInMastHead(driver);
			
			obj_EsupportCoveoWorkflow.ValidateIntegratedProductHomePageWithOutEnteringKeywordInMastHeadAndClickOnSearchButton(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInIntegratedSuppportHomePage(driver);
			
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7863884_AMER_CH_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadIPS_ESUPPORT--------->\n  "+e);
		}
	}
}
