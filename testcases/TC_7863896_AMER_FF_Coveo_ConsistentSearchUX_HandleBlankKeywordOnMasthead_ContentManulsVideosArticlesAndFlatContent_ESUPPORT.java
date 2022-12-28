package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7863896_AMER_FF_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_ContentManulsVideosArticlesAndFlatContent_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7863896_AMER_FF_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_ContentManulsVideosArticlesAndFlatContent_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7863896_AMER_FF_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_ContentManulsVideosArticlesAndFlatContent_ESUPPORT");
			
			obj_EsupportCoveoWorkflow.ToNavigate_ArticleHTMLPage(driver);
			
			
			obj_EsupportCoveoWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInArticleHomePage(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInArticlePage(driver);
			
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			
			obj_EsupportCoveoWorkflow.ToNavigate_ManualPage(driver);
			
			
			obj_EsupportCoveoWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInAlertAndVulnerabilityPage(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInAlertsAndVulnerabilities(driver);
			
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			
			obj_EsupportCoveoWorkflow.ToNavigate_SupportVidoesPage(driver);
			
			
			obj_EsupportCoveoWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInSupportVideosPage(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInSupportVideosPage(driver);
			
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			
			obj_EsupportCoveoWorkflow.ToNavigate_AlertVulnerabilitiesPage(driver);
			
			
			obj_EsupportCoveoWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInAlertVulnerabilityPage(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInAlertVulnerabilityPage(driver);
			
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7863896_AMER_FF_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_ContentManulsVideosArticlesAndFlatContent_ESUPPORT--------->\n  "+e);
		}
	}
}
