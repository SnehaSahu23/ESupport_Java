package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7947923_AMER_FF_Content_LEMC_AutomationModelUnserializedView_ManualsAndDocuments_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7947923_AMER_FF_Content_LEMC_AutomationModelUnserializedView_ManualsAndDocuments_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7947923_AMER_FF_Content_LEMC_AutomationModelUnserializedView_ManualsAndDocuments_ESUPPORT()");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportContentWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			
			obj_EsupportContentWorkflow.ScrollToManualsAndDocumentsForLEMCUser(driver);
			obj_EsupportContentWorkflow.ValidateAvailableManualsAndDocumentsCountForLEMCUser(driver);
			
			obj_EsupportContentWorkflow.ClickSeeAllButtonOnManualsAndDocumentsForLEMCUser(driver);
			obj_EsupportContentWorkflow.ClickOnBackToDocumentationTab(driver);
			
			obj_EsupportContentWorkflow.ValidateManualsAndDocumentsDisplayTitleEmailIconCollapseIconLinkToServiceRequestIconLockKeyForL40OrL50LEMCUser(driver);
			obj_EsupportContentWorkflow.ClickCollapseIconValidateDetailsDisplayedInTheSectionForManualsAndDocumentsForLEMCUser(driver);
			
			obj_EsupportContentWorkflow.ClickCollapseIconToValidateExpandIconForManualsAndDocumentsLEMCUser(driver);
			obj_EsupportContentWorkflow.ClickExpandIconToValidateCollapseIconForManulasAndDocumentsLemcUser(driver);
			obj_EsupportContentWorkflow.ClickOnFirstTitleFromManualsAndDocumentsListForLEMCUser(driver);
			
			
//			obj_EsupportContentWorkflow.ClickOnLinkToServiceRequestLogoOfManualsAndDocumentsForLEMCUser(driver);
			obj_EsupportContentWorkflow.ForL40OrL50LEMCUserKeyIconDisplayForManulasAndDocuments(driver);
		
			obj_EsupportContentWorkflow.ValidateChangeCountryAndValidateManualsAndDocumentsForLEMCUser(driver);
			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
			
			obj_EsupportContentWorkflow.ValidateChangingLanguageFromDropDownForManualsAndDocuments(driver);
			obj_EsupportContentWorkflow.ClickOnBackToDocumentationTab(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7947923_AMER_FF_Content_LEMC_AutomationModelUnserializedView_ManualsAndDocuments_ESUPPORT()--------->\n  "+e);
		}
	}
}
