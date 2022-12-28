package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7704563_AMER_IE_ContactUs_LEMC_SRCreate_HES_RecommendedResources_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7704563_AMER_IE_ContactUs_LEMC_SRCreate_HES_RecommendedResources_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7704563_AMER_IE_ContactUs_LEMC_SRCreate_HES_RecommendedResources_ESUPPORT");
			obj_EsupportProductionValidationsWorkflow.time(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateIfCreateServiceRequestChannelsEnabled(driver);
			obj_EsupportIncidentsWorkflow.ClickOnCreateServiceRequestButton(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormTitleXButtonCollapseArrows(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormIssueDetailsTagAndModelAndServiceCode(driver);
			
			obj_EsupportIncidentsWorkflow.VerifyAllFieldsInCreateSRForm1ForLEMC(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnAccountSeetingAndPreferencesLink(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnAlternateEmailOptionalLink(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnAlternatePhoneNumberOptionalLink(driver);
			
			obj_EsupportIncidentsWorkflow.ValidatePrefredContactMethod(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateConvenientTimeToContactYou(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateTimeZome(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnContinueWithOutEnteringDetailsForLEMC(driver);
			
			obj_EsupportIncidentsWorkflow.ClickCancelButton(driver);
			obj_EsupportIncidentsWorkflow.ClickOnCreateServiceRequestButton(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnContinueAndValidateFieldsInForm2ForLEMC(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormIssueDetailsTagAndModelAndServiceCode(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationForm2OperatingSystemDropDown(driver);
			
						
			obj_EsupportIncidentsWorkflow.ValidateRequestSummaryReqDescBusiImpaTextBoxForLEMCSRCreate(driver);
			obj_EsupportIncidentsWorkflow.WriteIssueDetailsInTheProblemDescriptionValidateForRecommendedResourcesForLEMC(driver);
			obj_EsupportIncidentsWorkflow.ClickOnViewAllRecommendations(driver);
				
			
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportProductionValidationsWorkflow.time(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7704563_AMER_IE_ContactUs_LEMC_SRCreate_HES_RecommendedResources_ESUPPORT--------->\n  "+e);

		}

	}
}
