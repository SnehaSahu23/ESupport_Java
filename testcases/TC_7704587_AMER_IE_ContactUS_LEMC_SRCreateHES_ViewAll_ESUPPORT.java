package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7704587_AMER_IE_ContactUS_LEMC_SRCreateHES_ViewAll_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7704587_AMER_IE_ContactUS_LEMC_SRCreateHES_ViewAll_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7704587_AMER_IE_ContactUS_LEMC_SRCreateHES_ViewAll_ESUPPORT");
			//driver.get("https://www.dell.com/support/incidents-online/us/en/04/ContactUs/");
//			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
//			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateIfCreateServiceRequestChannelsEnabled(driver);
			obj_EsupportIncidentsWorkflow.ClickOnCreateServiceRequestButtonForLEMCUser(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnContinueButtonInCreateServiceRequestWindowForLEMCUser(driver);
			
//			obj_EsupportIncidentsWorkflow.ValidateDetailsDisplayedUnderAttachmentsInCreateServiceRequestWindowForLEMCUser(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationForm2AddAttachmentButtonSectionForLEMC(driver);
			obj_EsupportIncidentsWorkflow.ValidateAndClickOnViewAllLinkInCreateServiceRequestWindowForLEMCUser(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7704587_AMER_IE_ContactUS_LEMC_SRCreateHES_ViewAll_ESUPPORT--------->\n  "+e);

		}

	}
}
