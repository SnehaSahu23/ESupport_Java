package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6979733_AMER_CH_ContactUs_LEMC_SPE_eSupportContactUSChannelsforNonEntitledAssetsHESSPE_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_6979733_AMER_CH_ContactUs_LEMC_SPE_eSupportContactUSChannelsforNonEntitledAssetsHESSPE_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_6979733_AMER_CH_ContactUs_LEMC_SPE_eSupportContactUSChannelsforNonEntitledAssetsHESSPE_Esupport");
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
			
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			
			obj_EsupportIncidentsWorkflow.VerifyOnlineSupportResourcesSelfHelpOption(driver);
			
			
			obj_EsupportIncidentsWorkflow.ClickSearchSupportLink(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateIfCallUsChannelEnabled(driver);
		
			obj_EsupportIPSWorkflow.signOut(driver);
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_6979733_AMER_CH_ContactUs_LEMC_SPE_eSupportContactUSChannelsforNonEntitledAssetsHESSPE_Esupport--------->\n  "+e);

		}

	}
}