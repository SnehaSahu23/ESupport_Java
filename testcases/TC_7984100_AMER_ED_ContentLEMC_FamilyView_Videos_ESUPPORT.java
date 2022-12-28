package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7984100_AMER_ED_ContentLEMC_FamilyView_Videos_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7984100_AMER_ED_ContentLEMC_FamilyView_Videos_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7984100_AMER_ED_ContentLEMC_FamilyView_Videos_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
//			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			obj_EsupportContentWorkflow.VerifyModelOrSeriesAvailablility(driver);
			obj_EsupportContentWorkflow.SelectModelOrSeriesFromDropDownForNegativeScrenario(driver);
			obj_EsupportContentWorkflow.SelectModelOrSeriesFromDropDownForNegativeScrenario2(driver);
			
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			//obj_EsupportContentWorkflow.ValidateVidoesNotFoundScenario(driver);
			obj_EsupportIPSWorkflow.clickChangeProductLink(driver);
			obj_EsupportContentWorkflow.ClickOnXButtonAfterClickingOnChangeProductForLEMCUser(driver);
			
			obj_EsupportContentWorkflow.ClickSearchServiceTagOnProductHomePageAfterClickingOnChangeProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			
			obj_EsupportContentWorkflow.VerifyModelOrSeriesAvailablility(driver);
			obj_EsupportContentWorkflow.SelectModelOrSeriesFromDropDown(driver);
			obj_EsupportContentWorkflow.SelectModelOrSeriesFromDropDown2(driver);
			
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportContentWorkflow.ScrollToVIdeosForLEMCUser(driver);
			obj_EsupportContentWorkflow.ValidateAvailableVideosCountForLEMCUser(driver);
			
			obj_EsupportContentWorkflow.ClickSeeAllButtonOnVideosForLEMCUser(driver);
			obj_EsupportContentWorkflow.ClickOnBackToDocumentationTab(driver);
			
			obj_EsupportContentWorkflow.ClickOnFirstVideoLinkDisplayedFromTheVideosListForLEMCUser(driver);
		
//			obj_EsupportContentWorkflow.ValidateChangeCountryAndValidateVideosSectionForLEMCUser(driver);
//			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7984100_AMER_ED_ContentLEMC_FamilyView_Videos_ESUPPORT--------->\n  "+e);
		}
	}
}
