package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8510311_AMER_IE_Content_LEMC_FamilyView_TopSolutions_OverviewTab_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_8510311_AMER_IE_Content_LEMC_FamilyView_TopSolutions_OverviewTab_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8510311_AMER_IE_Content_LEMC_FamilyView_TopSolutions_OverviewTab_ESUPPORT()");
			obj_EsupportContentWorkflow.handleCookies(driver);
//			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			obj_EsupportContentWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportContentWorkflow.VerifyModelOrSeriesAvailablility(driver);
			obj_EsupportContentWorkflow.SelectModelOrSeriesFromDropDownForNegativeScrenario(driver);
			obj_EsupportContentWorkflow.SelectModelOrSeriesFromDropDownForNegativeScrenario2(driver);
			
					
			obj_EsupportContentWorkflow.ScrollToTopSolutionsInOverviewTab(driver);
			
			obj_EsupportContentWorkflow.ClickCollapseIconOfKeyIconDisplayedTopSolutionAndValidateDetailsDisplayedInTheSectionInOverviewTab(driver);
			
			obj_EsupportContentWorkflow.ClickCollapseIconValidateDetailsDisplayedInTheSectionForTopSolutionsForLEMCUserInOverviewTab(driver);
			
			obj_EsupportContentWorkflow.ClickCollapseIconToValidateExpandIconForTopSolutionsLEMCUserInOverviewTab(driver);
			obj_EsupportContentWorkflow.ClickExpandIconToValidateCollapseIconForTopSolutionsForLemcUserInOverviewTab(driver);
			obj_EsupportContentWorkflow.ClickOnFirstTitleFromTopSolutionsListForLEMCUserInOverviewTab(driver);
			obj_EsupportContentWorkflow.ValidateTopSolutionsDisplayedInOverviewTab(driver);			
			obj_EsupportContentWorkflow.ValidateTopSolutionsDisplayTitleEmailIconCollapseIconLinkToServiceRequestIconLockKeyForL40OrL50LEMCUserInOverviewTab(driver);
			
//			obj_EsupportContentWorkflow.ClickOnLinkToServiceRequestLogoOfTopSolutionsForLEMCUserInOverviewTab(driver);
			obj_EsupportContentWorkflow.ForL40OrL50LEMCUserKeyIconDisplayForTopSolutionsInOverviewTab(driver);
		
			
			obj_EsupportContentWorkflow.ValidateChangeCountryForOverviewTabForSupportTopicsValidations(driver);
			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8510311_AMER_IE_Content_LEMC_FamilyView_TopSolutions_OverviewTab_ESUPPORT()--------->\n  "+e);
		}
	}
}
