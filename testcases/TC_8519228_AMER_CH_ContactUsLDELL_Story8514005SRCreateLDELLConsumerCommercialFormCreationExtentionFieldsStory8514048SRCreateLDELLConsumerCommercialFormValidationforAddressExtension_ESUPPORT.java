package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8519228_AMER_CH_ContactUsLDELL_Story8514005SRCreateLDELLConsumerCommercialFormCreationExtentionFieldsStory8514048SRCreateLDELLConsumerCommercialFormValidationforAddressExtension_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_8519228_AMER_CH_ContactUsLDELL_Story8514005SRCreateLDELLConsumerCommercialFormCreationExtentionFieldsStory8514048SRCreateLDELLConsumerCommercialFormValidationforAddressExtension_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8519228_AMER_CH_ContactUsLDELL_Story8514005SRCreateLDELLConsumerCommercialFormCreationExtentionFieldsStory8514048SRCreateLDELLConsumerCommercialFormValidationforAddressExtension_ESUPPORT");
			
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
			
			obj_EsupportIncidentsWorkflow.VerifyAllFieldsInCreateSRForm1(driver);
			obj_EsupportIncidentsWorkflow.ValidateClickingOnContinueButtonWithoutEnteringAnyDetails(driver);
		
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_8519228_AMER_CH_ContactUsLDELL_Story8514005SRCreateLDELLConsumerCommercialFormCreationExtentionFieldsStory8514048SRCreateLDELLConsumerCommercialFormValidationforAddressExtension_ESUPPORT--------->\n  "+e);

		}

	}
}
