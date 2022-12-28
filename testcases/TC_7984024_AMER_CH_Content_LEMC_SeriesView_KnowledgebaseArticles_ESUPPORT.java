package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7984024_AMER_CH_Content_LEMC_SeriesView_KnowledgebaseArticles_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7984024_AMER_CH_Content_LEMC_SeriesView_KnowledgebaseArticles_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7984024_AMER_CH_Content_LEMC_SeriesView_KnowledgebaseArticles_ESUPPORT()");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportContentWorkflow.VerifyModelOrSeriesAvailablility(driver);
			obj_EsupportContentWorkflow.SelectModelOrSeriesFromDropDown(driver);
			
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			
			obj_EsupportContentWorkflow.ScrollToKnowledgeBaseArticlesForLEMCUser(driver);
			obj_EsupportContentWorkflow.ValidateAvailableKnowledgeBaseArticlesCountForLEMCUser(driver);
			
//			obj_EsupportContentWorkflow.ClickSeeAllButtonOnKNowledgeBaseArticlesForLEMCUser(driver);
//			obj_EsupportContentWorkflow.ClickOnBackToDocumentationTab(driver);
			
			//obj_EsupportContentWorkflow.ValidateKnowledgebaseArticlesDisplayTitleEmailIconCollapseIconLinkToServiceRequestIconLockKeyForL40OrL50LEMCUser(driver);
			obj_EsupportContentWorkflow.ClickCollapseIconValidateDetailsDisplayedInTheSection(driver);
			
			obj_EsupportContentWorkflow.ClickCollapseIconToValidateExpandIconForKNowledgeBaseArticlesLEMCUser(driver);
			obj_EsupportContentWorkflow.ClickExpandIconToValidateCollapseIconForKnowledgebaseArticlesLemcUser(driver);
			obj_EsupportContentWorkflow.ClickOnFirstTitleFromKnowledgeBaseArticleListForLEMCUser(driver);
			
			
//			obj_EsupportContentWorkflow.ClickOnLinkToServiceRequestLogoOfKnowledgebaseArticlesForLEMCUser(driver);
//			obj_EsupportContentWorkflow.ForL40OrL50LEMCUserKeyIconDisplayForKnowledgebaseArticles(driver);
//		
//			obj_EsupportContentWorkflow.ValidateChangeCountryAndValidateKNowedgebaseArticlesForLEMCUser(driver);
//			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7984024_AMER_CH_Content_LEMC_SeriesView_KnowledgebaseArticles_ESUPPORT()--------->\n  "+e);
		}
	}
}
