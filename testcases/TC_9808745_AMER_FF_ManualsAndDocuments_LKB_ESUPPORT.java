package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9808745_AMER_FF_ManualsAndDocuments_LKB_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9808745_AMER_FF_ManualsAndDocuments_LKB_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9808745_AMER_FF_ManualsAndDocuments_LKB_ESUPPORT");
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
			
			obj_EsupportContentWorkflow.ClickCollapseIconValidateTextForManualsAndDocumentsArticle(driver);
			
			obj_EsupportContentWorkflow.ClickViewPageHyperLinkForManualsAndDocuments_ForArticle(driver);
			
			obj_EsupportContentWorkflow.ValidateLanguageDropDownInManualsAndDocuments(driver);
			
			obj_EsupportContentWorkflow.changeLanguageFromDropdownManualAndDocuments(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportContentWorkflow.ClickOnBackToDocumentationTab(driver);
			obj_EsupportContentWorkflow.ValidateChangeCountry(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9808745_AMER_FF_ManualsAndDocuments_LKB_ESUPPORT--------->\n  "+e);
		}
	}
}

