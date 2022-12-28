package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8510255_AMER_CH_Content_LEMC_SeriesView_RecommendedResources_TopSolutions_MayContainDriversAndWillHaveToHandleDriversLogicOnWhetherToShow_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_8510255_AMER_CH_Content_LEMC_SeriesView_RecommendedResources_TopSolutions_MayContainDriversAndWillHaveToHandleDriversLogicOnWhetherToShow_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8510255_AMER_CH_Content_LEMC_SeriesView_RecommendedResources_TopSolutions_MayContainDriversAndWillHaveToHandleDriversLogicOnWhetherToShow_ESUPPORT()");
			obj_EsupportContentWorkflow.handleCookies(driver);
//			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			obj_EsupportContentWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportContentWorkflow.VerifyModelOrSeriesAvailablility(driver);
			obj_EsupportContentWorkflow.SelectModelOrSeriesFromDropDown(driver);
			
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			
			obj_EsupportContentWorkflow.ScrollToTopSolutions(driver);
			obj_EsupportContentWorkflow.ValidateTopSolutionsDisplayed(driver);
			
						
			//obj_EsupportContentWorkflow.ValidateTopSolutionsDisplayTitleEmailIconCollapseIconLinkToServiceRequestIconLockKeyForL40OrL50LEMCUser(driver);
			
			//obj_EsupportContentWorkflow.ClickCollapseIconOfKeyIconDisplayedTopSolutionAndValidateDetailsDisplayedInTheSection(driver);
			
//			obj_EsupportContentWorkflow.ValidateChangeCountryAndValidateKNowedgebaseArticlesForLEMCUser(driver);
//			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8510255_AMER_CH_Content_LEMC_SeriesView_RecommendedResources_TopSolutions_MayContainDriversAndWillHaveToHandleDriversLogicOnWhetherToShow_ESUPPORT()--------->\n  "+e);
		}
	}
}
