package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7114983_AMER_IE_Contact_SPEContactUS_CONTACTCHANNELS_CREATESERVICEREQUEST_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7114983_AMER_IE_Contact_SPEContactUS_CONTACTCHANNELS_CREATESERVICEREQUEST_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7114983_AMER_IE_Contact_SPEContactUS_CONTACTCHANNELS_CREATESERVICEREQUEST_ESUPPORT");
			//driver.get("https://www.dell.com/support/incidents-online/us/en/04/ContactUs/");
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateIfCreateServiceRequestChannelsEnabled(driver);
			obj_EsupportIncidentsWorkflow.ClickOnCreateServiceRequestButton(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormIssueDetails(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormOperatingSystemDropDown(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormHelpUsTroubleshootYourIssue(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormAddAttachmentButton(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormContactInformation(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormPrivacyStatement(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormSubmitButton(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormCancelButton(driver);
			obj_EsupportIncidentsWorkflow.ValidateClickingOnSubmitButtonWithoutEnteringAnyDetails(driver);
			obj_EsupportIncidentsWorkflow.ValidateGivingMoreThank500CharsinProvidedetailstohelpustroubleshootyourissueTextBox(driver);
			obj_EsupportIncidentsWorkflow.ValidateEnteringIncorrectEmailAddress(driver);
			obj_EsupportIncidentsWorkflow.ValidateEnteringCharactersInPhoneNumberField(driver);
			obj_EsupportIncidentsWorkflow.ClickOnDellPrivacyStatementHyperlink(driver);
			obj_EsupportIncidentsWorkflow.ClickCancelButton(driver);
			obj_EsupportIncidentsWorkflow.EnterAllDetailsInCRCreateFormAndClickOnSubmitButton(driver);
			obj_EsupportIncidentsWorkflow.ClickOnSRNumberHyperlink(driver);
			obj_EsupportIncidentsWorkflow.ClickOnArrowInSRPage(driver);
			obj_EsupportIncidentsWorkflow.WithoutEnteringEmailClickOnSubmitInPopup(driver);
			obj_EsupportIncidentsWorkflow.EnterInvalidEmailAndClickSubmitInPopup(driver);
			obj_EsupportIncidentsWorkflow.EntervalidEmailAndClickSubmitInPopup(driver);
		
			
			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateIfCreateServiceRequestChannelsEnabled(driver);
			obj_EsupportIncidentsWorkflow.ClickOnCreateServiceRequestButton(driver);
			
			
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormIssueDetails(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormOperatingSystemDropDown(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormHelpUsTroubleshootYourIssue(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormAddAttachmentButton(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormContactInformation(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormPrivacyStatement(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormSubmitButton(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormCancelButton(driver);
			obj_EsupportIncidentsWorkflow.ValidateClickingOnSubmitButtonWithoutEnteringAnyDetails(driver);
			obj_EsupportIncidentsWorkflow.ValidateGivingMoreThank500CharsinProvidedetailstohelpustroubleshootyourissueTextBox(driver);
			obj_EsupportIncidentsWorkflow.ValidateEnteringIncorrectEmailAddress(driver);
			obj_EsupportIncidentsWorkflow.ValidateEnteringCharactersInPhoneNumberField(driver);
			obj_EsupportIncidentsWorkflow.ClickOnDellPrivacyStatementHyperlink(driver);
			obj_EsupportIncidentsWorkflow.ClickCancelButton(driver);
			obj_EsupportIncidentsWorkflow.EnterAllDetailsInCRCreateFormAndClickOnSubmitButton(driver);
			obj_EsupportIncidentsWorkflow.ClickOnSRNumberHyperlink(driver);
			obj_EsupportIncidentsWorkflow.ClickOnArrowInSRPage(driver);
			obj_EsupportIncidentsWorkflow.WithoutEnteringEmailClickOnSubmitInPopup(driver);
			obj_EsupportIncidentsWorkflow.EnterInvalidEmailAndClickSubmitInPopup(driver);
			obj_EsupportIncidentsWorkflow.EntervalidEmailAndClickSubmitInPopup(driver);
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7114983_AMER_IE_Contact_SPEContactUS_CONTACTCHANNELS_CREATESERVICEREQUEST_ESUPPORT--------->\n  "+e);

		}

	}
}
