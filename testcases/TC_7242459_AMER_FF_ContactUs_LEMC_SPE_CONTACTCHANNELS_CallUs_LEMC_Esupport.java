package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7242459_AMER_FF_ContactUs_LEMC_SPE_CONTACTCHANNELS_CallUs_LEMC_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_7242459_AMER_FF_ContactUs_LEMC_SPE_CONTACTCHANNELS_CallUs_LEMC_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_7242459_AMER_FF_ContactUs_LEMC_SPE_CONTACTCHANNELS_CallUs_LEMC_Esupport");
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
			
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateIfCallUsChannelEnabled(driver);
		
			obj_EsupportIPSWorkflow.signOut(driver);
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7242459_AMER_FF_ContactUs_LEMC_SPE_CONTACTCHANNELS_CallUs_LEMC_Esupport--------->\n  "+e);

		}

	}
}

