package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7984225_AMER_IE_Content_LEMC_SeriesView_SupportTopics_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7984225_AMER_IE_Content_LEMC_SeriesView_SupportTopics_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7984225_AMER_IE_Content_LEMC_SeriesView_SupportTopics_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			obj_EsupportContentWorkflow.VerifyModelOrSeriesAvailablility(driver);
			obj_EsupportContentWorkflow.SelectModelOrSeriesFromDropDown(driver);
			
			obj_EsupportContentWorkflow.ValidateSupportTopicsNotFoundInOverviewTab(driver);
			
			obj_EsupportIPSWorkflow.clickChangeProductLink(driver);
			obj_EsupportContentWorkflow.ClickOnXButtonAfterClickingOnChangeProductForLEMCUser(driver);
			
			obj_EsupportContentWorkflow.ClickSearchServiceTagOnProductHomePageAfterClickingOnChangeProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			
			obj_EsupportContentWorkflow.VerifyModelOrSeriesAvailablility(driver);
			obj_EsupportContentWorkflow.SelectModelOrSeriesFromDropDownForPositiveScenario(driver);
			
			obj_EsupportContentWorkflow.ValidateSupportTopicsInOverviewTab(driver);
			obj_EsupportContentWorkflow.ValidateSupportTopicsSection(driver);
			obj_EsupportContentWorkflow.ClickOnFirstAvaialableSupportTopic(driver);
			obj_EsupportContentWorkflow.ValidateChangeCountryForOverviewTabForSupportTopicsValidations(driver);
			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7984225_AMER_IE_Content_LEMC_SeriesView_SupportTopics_ESUPPORT--------->\n  "+e);
		}
	}
}
