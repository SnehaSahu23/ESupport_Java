package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7968827_AMER_ED_Content_LEMC_AbilityForSearchResultsToShowFamilySeriesAndProductViewAsAFilter_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7968827_AMER_ED_Content_LEMC_AbilityForSearchResultsToShowFamilySeriesAndProductViewAsAFilter_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7968827_AMER_ED_Content_LEMC_AbilityForSearchResultsToShowFamilySeriesAndProductViewAsAFilter_ESUPPORT()");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportContentWorkflow.ClickSeeAllButtonOnKNowledgeBaseArticlesForLEMCUser(driver);
			obj_EsupportContentWorkflow.ClickOnBackToDocumentationTab(driver);
			obj_EsupportContentWorkflow.ClickSeeAllButtonOnManualsAndDocumentsForLEMCUser(driver);
			obj_EsupportContentWorkflow.ClickOnBackToDocumentationTab(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7968827_AMER_ED_Content_LEMC_AbilityForSearchResultsToShowFamilySeriesAndProductViewAsAFilter_ESUPPORT()--------->\n  "+e);
		}
	}
}

