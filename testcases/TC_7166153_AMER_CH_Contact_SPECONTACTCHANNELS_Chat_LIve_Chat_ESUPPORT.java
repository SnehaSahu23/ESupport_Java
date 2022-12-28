package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7166153_AMER_CH_Contact_SPECONTACTCHANNELS_Chat_LIve_Chat_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7166153_AMER_CH_Contact_SPECONTACTCHANNELS_Chat_LIve_Chat_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7166153_AMER_CH_Contact_SPECONTACTCHANNELS_Chat_LIve_Chat_ESUPPORT");
			//driver.get("https://www.dell.com/support/incidents-online/us/en/04/ContactUs/");
			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			
			obj_EsupportIncidentsWorkflow.ValidateIfLiveChatContactChannelIsEnabled(driver);
			obj_EsupportIncidentsWorkflow.ClickOnStartChatButton(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnDellPrivacyStatementHyperlink(driver);
			
			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateIfLiveChatContactChannelIsEnabled(driver);
			obj_EsupportIncidentsWorkflow.ClickOnStartChatButton(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnDellPrivacyStatementHyperlink(driver);
			

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7166153_AMER_CH_Contact_SPECONTACTCHANNELS_Chat_LIve_Chat_ESUPPORT--------->\n  "+e);

		}

	}
}
