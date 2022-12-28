package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7863896_AMER_MB_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_ContentManulsVideosArticlesAndFlatContent_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_7863896_AMER_CH_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_ContentManulsVideosArticlesAndFlatContent_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7863896_AMER_CH_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_ContentManulsVideosArticlesAndFlatContent_ESUPPORT");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.ToNavigate_ArticleHTMLPage(driver);
			
			
            obj_EsupportMobileWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInArticleHomePage(driver);
            obj_EsupportMobileWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInArticlePage(driver);
			
            obj_EsupportMobileWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			
            obj_EsupportMobileWorkflow.ToNavigate_ManualPage(driver);
			
			
            obj_EsupportMobileWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInAlertAndVulnerabilityPage(driver);
            obj_EsupportMobileWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInAlertsAndVulnerabilities(driver);
			
            obj_EsupportMobileWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			
            obj_EsupportMobileWorkflow.ToNavigate_SupportVidoesPage(driver);
			
			
            obj_EsupportMobileWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInSupportVideosPage(driver);
            obj_EsupportMobileWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInSupportVideosPage(driver);
			
            obj_EsupportMobileWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			
            obj_EsupportMobileWorkflow.ToNavigate_AlertVulnerabilitiesPage(driver);
			
			
            obj_EsupportMobileWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInAlertVulnerabilityPage(driver);
            obj_EsupportMobileWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInAlertVulnerabilityPage(driver);
			
            obj_EsupportMobileWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7863896_AMER_CH_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_ContentManulsVideosArticlesAndFlatContent_ESUPPORT--------->\n  "+e);
		}
	}
}
