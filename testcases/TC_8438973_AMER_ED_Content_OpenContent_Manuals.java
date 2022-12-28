package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8438973_AMER_ED_Content_OpenContent_Manuals extends BaseTest {


	@Test
	public void validate_TC_8438973_AMER_ED_Content_OpenContent_Manuals() 
	{
		try
		{
			System.out.println("Starts TC_8438973_AMER_ED_Content_OpenContent_Manuals");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportContentWorkflow.ScrollToManualsAndDocumentsForLEMCUser(driver);
			obj_EsupportContentWorkflow.ValidateAvailableManualsAndDocumentsCountForLEMCUser(driver);
			
			obj_EsupportContentWorkflow.ClickSeeAllButtonOnManualsAndDocumentsForLEMCUser(driver);
			obj_EsupportContentWorkflow.ClickOnBackToDocumentationTab(driver);
			obj_EsupportContentWorkflow.ValidateManualsAndDocumentsDisplayTitleEmailIconCollapseIcon(driver);
			
			obj_EsupportContentWorkflow.ClickExpandIconToValidateCollapseIconForManualAndDocuments(driver);
			obj_EsupportContentWorkflow.ClickCollapseIconToValidateExpandIconForManualsAndDocuments(driver);
			
			obj_EsupportContentWorkflow.ClickViewPageHyperLinkForManualsAndDocuments(driver);
			
			obj_EsupportContentWorkflow.ValidateLanguageDropDownInManualsAndDocuments(driver);
			
			obj_EsupportContentWorkflow.changeLanguageFromDropdownManualAndDocuments(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportContentWorkflow.ClickOnBackToDocumentationTab(driver);
			obj_EsupportContentWorkflow.ValidateChangeCountry(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8438973_AMER_ED_Content_OpenContent_Manuals--------->\n  "+e);
		}
	}
}

