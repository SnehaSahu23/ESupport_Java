package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7165930_AMER_FF_Contact_SPEContactUS_OOW_SelfHelpOptions_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7165930_AMER_FF_Contact_SPEContactUS_OOW_SelfHelpOptions_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7165930_AMER_FF_Contact_SPEContactUS_OOW_SelfHelpOptions_ESUPPORT");
			//driver.get("https://www.dell.com/support/incidents-online/us/en/04/ContactUs/");
			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			//for US service tag
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownNotDisplayedForOOWTag(driver);
			
			//Verify Software Offer
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection_OOWTag(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateSoftwareSupport_OOWTag(driver);
			obj_EsupportErevenueWorkflow.verifySoftwareOfferTile(driver);
			
			obj_EsupportErevenueWorkflow.verifyLearnMoreLinksSoftwareRepair(driver);
			obj_EsupportErevenueWorkflow.clickLearnMoreLinkSoftwareRepair(driver);

			
			//Verify Hardware Standard Offer
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection_OOWTag(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateHardware_OOWTag(driver);
			obj_EsupportErevenueWorkflow.verifyHardwareOfferTile(driver);
			obj_EsupportErevenueWorkflow.verifyLearnMoreLinksHardwareRepair(driver);
			obj_EsupportErevenueWorkflow.clickLearnMoreLinkHardwareRepairStandard(driver);
			obj_EsupportIncidentsWorkflow.ClickOnSearchSupport(driver);
			
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus");
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			
			// Sign in and after sign in validations
			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			
			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			//for US service tag
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownNotDisplayedForOOWTag(driver);
			
			//Verify Software Offer
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection_OOWTag(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateSoftwareSupport_OOWTag(driver);
			obj_EsupportErevenueWorkflow.verifySoftwareOfferTile(driver);
			
			obj_EsupportErevenueWorkflow.verifyLearnMoreLinksSoftwareRepair(driver);
			obj_EsupportErevenueWorkflow.clickLearnMoreLinkSoftwareRepair(driver);

			
			//Verify Hardware Standard Offer
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection_OOWTag(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateHardware_OOWTag(driver);
			obj_EsupportErevenueWorkflow.verifyHardwareOfferTile(driver);
			obj_EsupportErevenueWorkflow.verifyLearnMoreLinksHardwareRepair(driver);
			obj_EsupportErevenueWorkflow.clickLearnMoreLinkHardwareRepairStandard(driver);
			obj_EsupportIncidentsWorkflow.ClickOnSearchSupport(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7165930_AMER_FF_Contact_SPEContactUS_OOW_SelfHelpOptions_ESUPPORT--------->\n  "+e);

		}

	}
}
