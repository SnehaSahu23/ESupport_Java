package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8705013_AMER_CH_ContactUsLDELL_SRCreateLDELLConsumerCommercialFormCreation_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_8705013_AMER_CH_ContactUsLDELL_SRCreateLDELLConsumerCommercialFormCreation_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8705013_AMER_CH_ContactUsLDELL_SRCreateLDELLConsumerCommercialFormCreation_ESUPPORT");
			
//			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
//			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateIfCreateServiceRequestChannelsEnabled_ForLDELL(driver);
			obj_EsupportIncidentsWorkflow.ClickOnCreateServiceRequestButton_ForLDELL(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormTitleXButtonCollapseArrows(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormIssueDetailsTagAndModelAndServiceCode(driver);
			
			obj_EsupportIncidentsWorkflow.VerifyAllFieldsInCreateSRForm1(driver);
			
			obj_EsupportIncidentsWorkflow.ClickCancelButton(driver);
			obj_EsupportIncidentsWorkflow.ClickOnCreateServiceRequestButton_ForLDELL(driver);
			obj_EsupportIncidentsWorkflow.ValidateClickingOnContinueButtonWithoutEnteringAnyDetails(driver);
			
			obj_EsupportIncidentsWorkflow.EnterAllDetailsInCRCreateForm1AndClickOnContinueButton(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormIssueDetailsTagAndModelAndServiceCode(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationForm2OperatingSystemDropDown(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateRequestSummaryTextBox(driver);
			
			//added missing steps
			obj_EsupportIncidentsWorkflow.WriteIssueDetailsInTheProblemDescriptionValidateForRecommendedResources(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnViewAllRecommendations(driver);
			//
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationForm2AddAttachmentButtonSection(driver);
			

			obj_EsupportIncidentsWorkflow.ClickOnAddAttachmentButtonAndValidatePopUp(driver);
			

			
			obj_EsupportIncidentsWorkflow.ClickOnBackButton(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateForm2WithoutEnteringMandatoryFieldsClickOnSubmit(driver);
			
			
//			obj_EsupportIncidentsWorkflow.FillAllDetailsInPage2AndClickOnSubmit(driver);
//			
//			obj_EsupportIncidentsWorkflow.ClickOnDoneButton(driver);
			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportIncidentsWorkflow.ValidateIfCreateServiceRequestChannelsEnabled_ForLDELL(driver);
			obj_EsupportIncidentsWorkflow.ClickOnCreateServiceRequestButton_ForLDELL(driver);
			obj_EsupportIncidentsWorkflow.VerifyPrepopulatedFileds(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_8705013_AMER_CH_ContactUsLDELL_SRCreateLDELLConsumerCommercialFormCreation_ESUPPORT--------->\n  "+e);

		}

	}
}
