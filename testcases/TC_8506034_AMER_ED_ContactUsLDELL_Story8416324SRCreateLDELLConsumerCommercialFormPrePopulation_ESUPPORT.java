package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8506034_AMER_ED_ContactUsLDELL_Story8416324SRCreateLDELLConsumerCommercialFormPrePopulation_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_8506034_AMER_ED_ContactUsLDELL_Story8416324SRCreateLDELLConsumerCommercialFormPrePopulation_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8506034_AMER_ED_ContactUsLDELL_Story8416324SRCreateLDELLConsumerCommercialFormPrePopulation_ESUPPORT");
			
			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
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
			
			obj_EsupportIncidentsWorkflow.VerifyPrepopulatedFileds(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_8506034_AMER_ED_ContactUsLDELL_Story8416324SRCreateLDELLConsumerCommercialFormPrePopulation_ESUPPORT--------->\n  "+e);

		}

	}
}
