package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7124726_AMER_FF_Contact_SPECONTACTCHANNELS_LIveChat_SnapInChat_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7124726_AMER_FF_Contact_SPECONTACTCHANNELS_LIveChat_SnapInChat_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7124726_AMER_FF_Contact_SPECONTACTCHANNELS_LIveChat_SnapInChat_ESUPPORT");
			//driver.get("https://www.dell.com/support/incidents-online/us/en/04/ContactUs/");
			
			//run this only during business hours. otherwise start chat(live chat) button will be disabled

			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);

			
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			
			obj_EsupportIncidentsWorkflow.ValidateIfLiveChatContactChannelIsEnabled(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnStartChatButton(driver);
//			
//			obj_EsupportIncidentsWorkflow.ClickOnDellPrivacyStatementHyperlink(driver);
//			
//			
//			obj_EsupportIncidentsWorkflow.WithoutEnteringAnyDetailsInPreChatFormClickStartChatButton(driver);
//			obj_EsupportIncidentsWorkflow.WriteIssueDetailsInTheProblemDescriptionValidateForRecommendedResources(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnViewAllRecommendations(driver);
//			obj_EsupportIncidentsWorkflow.AfterEnteringAllDetailsInPreChatFormClickOnStartChatButton(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnCancelChatRequestButton(driver);
//			
//			obj_EsupportIncidentsWorkflow.ClickOnLeaveButton(driver);
			
//			obj_EsupportIncidentsWorkflow.WriteIssueDetailsInTheProblemDescriptionValidateForRecommendedResources(driver);
//			obj_EsupportIncidentsWorkflow.AfterEnteringAllDetailsInPreChatFormClickOnStartChatButton(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnCancelChatRequestButton(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnContinueToWaitButton(driver);
//			
//			obj_EsupportIncidentsWorkflow.VerifyTheDetailsOnceChatIsConnected(driver);
//			
//			obj_EsupportIncidentsWorkflow.ClickOnSaveTranscript(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnEndChatItem(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnGoBackButton(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnConfirmEndChatButton(driver);
//			
//			obj_EsupportIncidentsWorkflow.ClickOnCloseChatButton(driver);
			
//			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			Thread.sleep(5000);
////			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownGreyedOut(driver);
//			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
////			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
//			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
//			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
//			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
//			obj_EsupportIncidentsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
//			
//			obj_EsupportIncidentsWorkflow.ValidateIfLiveChatContactChannelIsEnabled(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnStartChatButton(driver);
//			
//			obj_EsupportIncidentsWorkflow.ClickOnDellPrivacyStatementHyperlink(driver);
//			
//			obj_EsupportIncidentsWorkflow.WithoutEnteringAnyDetailsInPreChatFormClickStartChatButton(driver);
//			obj_EsupportIncidentsWorkflow.WriteIssueDetailsInTheProblemDescriptionValidateForRecommendedResources(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnViewAllRecommendations(driver);
//			obj_EsupportIncidentsWorkflow.AfterEnteringAllDetailsInPreChatFormClickOnStartChatButton(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnCancelChatRequestButton(driver);
//			
//			obj_EsupportIncidentsWorkflow.ClickOnLeaveButton(driver);
//			
//			obj_EsupportIncidentsWorkflow.WriteIssueDetailsInTheProblemDescriptionValidateForRecommendedResources(driver);
//			obj_EsupportIncidentsWorkflow.AfterEnteringAllDetailsInPreChatFormClickOnStartChatButton(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnCancelChatRequestButton(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnContinueToWaitButton(driver);
//			
//			obj_EsupportIncidentsWorkflow.VerifyTheDetailsOnceChatIsConnected(driver);
//			
//			obj_EsupportIncidentsWorkflow.ClickOnSaveTranscript(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnEndChatItem(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnGoBackButton(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnConfirmEndChatButton(driver);
//			
//			obj_EsupportIncidentsWorkflow.ClickOnCloseChatButton(driver);
			

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7124726_AMER_FF_Contact_SPECONTACTCHANNELS_LIveChat_SnapInChat_ESUPPORT--------->\n  "+e);

		}

	}
}
