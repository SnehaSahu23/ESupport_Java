package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7030544_AMER_CH_Content_ManualsAndDocuments_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7030544_AMER_CH_Content_ManualsAndDocuments_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7030544_AMER_CH_Content_ManualsAndDocuments_ESUPPORT()");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportContentWorkflow.ValidateDetailsOnLeftRail(driver);
			
			obj_EsupportContentWorkflow.ScrollToManualsAndDocuments(driver);
			
			obj_EsupportContentWorkflow.ValidateManualsAndDocumentsDisplayTitleViewPageViewPDFCollapseIcon(driver);
			
			obj_EsupportContentWorkflow.ClickCollapseIconValidateTextForManualsAndDocumentsArticle(driver);
			
			obj_EsupportContentWorkflow.ClickCollapseIconToValidateExpandIconForManualsAndDocuments(driver);
			
			obj_EsupportContentWorkflow.ClickExpandIconToValidateCollapseIconForManualAndDocuments(driver);
			
			obj_EsupportContentWorkflow.ClickViewPageHyperLinkForManualsAndDocuments(driver);
			
			obj_EsupportContentWorkflow.ClickViewPDFHyperLinkForManualsAndDocuments(driver);
			
			obj_EsupportContentWorkflow.ValidateLanguageDropDownInManualsAndDocuments(driver);
			
			obj_EsupportContentWorkflow.ValidateChangeCountry(driver);
			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
			
			obj_EsupportContentWorkflow.ValidateChangingLanguageFromDropDown(driver);
			
			//obj_EsupportContentWorkflow.ValidateChangingLanguageFromDropDownAndChangingCountryFromDropDown(driver);
			
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7030544_AMER_CH_Content_ManualsAndDocuments_ESUPPORT()--------->\n  "+e);
		}
	}
}
