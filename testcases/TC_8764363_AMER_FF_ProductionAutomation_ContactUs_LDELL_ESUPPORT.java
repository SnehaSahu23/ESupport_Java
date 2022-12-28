package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8764363_AMER_FF_ProductionAutomation_ContactUs_LDELL_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_8764363_AMER_FF_ProductionAutomation_ContactUs_LDELL_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8764363_AMER_FF_ProductionAutomation_ContactUs_LDELL_ESUPPORT");
			
			//test case 6877603
			obj_EsupportProductionValidationsWorkflow.time(driver);
			//because of issue in login 0602, removing sign in part
			obj_EsupportProductionValidationsWorkflow.validateCtsHomePage(driver);	
			obj_EsupportProductionValidationsWorkflow.validateNatureofRequestandIssueListDropdown(driver);
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnViewPhoneNumberlink(driver);
			obj_EsupportProductionValidationsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnAnyOFContactChannelsBeforeSearchingForProductOrTag(driver);
			
			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			obj_EsupportProductionValidationsWorkflow.verifyServiceTagHeroSection(driver);
			obj_EsupportProductionValidationsWorkflow.verifyProductImageHeroSection(driver);
			obj_EsupportProductionValidationsWorkflow.verifyProductHeroSectionDetails(driver);
			
			obj_EsupportProductionValidationsWorkflow.verifyChangeProductLink(driver);
			obj_EsupportProductionValidationsWorkflow.verifySystemConfigurationLink(driver);	
			obj_EsupportProductionValidationsWorkflow.VerifyExtendOrUpgradelink(driver);
			
			obj_EsupportProductionValidationsWorkflow.clickViewDetailsLink(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyClickingXButtonOnWarrantyPage(driver);
			
			

			//configuration link validation
			
			obj_EsupportProductionValidationsWorkflow.verifySystemConfigurationLink(driver);	
			obj_EsupportProductionValidationsWorkflow.clickSystemConfigurationLink(driver);	
			obj_EsupportProductionValidationsWorkflow.verifyModalPopupConfiguration(driver);	
			obj_EsupportProductionValidationsWorkflow.verifyConfigurationTable(driver);	
			obj_EsupportProductionValidationsWorkflow.verifyExportOption(driver);	
			//			obj_EsupportIPSWorkflow.clickExportOption(driver);	
			obj_EsupportProductionValidationsWorkflow.clickCurrentConfigurationTab(driver);	
			obj_EsupportProductionValidationsWorkflow.verifyRunSupportAssistButton(driver);	
			obj_EsupportProductionValidationsWorkflow.clickModalPopupCloseButton(driver);	
			
			//click extend or upgrade link
			obj_EsupportProductionValidationsWorkflow.ClickExtendOrUpgradelink(driver);
			
			driver.navigate().back();
			
			driver.navigate().back();
			Thread.sleep(5000);
//			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
			
//			obj_EsupportProductionValidationsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
			obj_EsupportProductionValidationsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnAnyOFContactChannelsAfterSearchingForProductOrTag(driver);
			
			obj_EsupportProductionValidationsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnAnyOFContactChannelsAfterSelectingIssueFromDropDown(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyOnlineSupportResourcesSelfHelpOption(driver);
			obj_EsupportProductionValidationsWorkflow.ClickSearchSupportLink(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyDiagnoseYourProblemSelfHelpOption(driver);
			obj_EsupportProductionValidationsWorkflow.ClickRunQuickTest(driver);
	//			Thread.sleep(7000);
				
	//			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
	//			Thread.sleep(7000);
	//			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
				
			obj_EsupportProductionValidationsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportProductionValidationsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			obj_EsupportProductionValidationsWorkflow.ValidateIfCallUsChannelEnabled(driver);
			
			obj_EsupportProductionValidationsWorkflow.ValidateIfTechDirectContactChannelsEnabled(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnTechDirectButton(driver);
			
//			obj_EsupportProductionValidationsWorkflow.ValidateGeneralSupportPhoneNumbersNotDisplyed(driver);
			obj_EsupportProductionValidationsWorkflow.clickChangeProductLink(driver);

			obj_EsupportProductionValidationsWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
			obj_EsupportProductionValidationsWorkflow.RecentlyViewed(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductImageOfRecentlyViewed(driver);
			obj_EsupportProductionValidationsWorkflow.clickChangeProductLink(driver);
			
			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.verifyServiceTagHyperlinkAndClickOnServiceTagLink(driver);
			Thread.sleep(7000);
			
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
			Thread.sleep(7000);
			obj_EsupportProductionValidationsWorkflow.ToHandle_POpUp(driver);
			obj_EsupportProductionValidationsWorkflow.clickLogintoAddNickname(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportProductionValidationsWorkflow.VerifyAddNewNickname(driver);
			obj_EsupportProductionValidationsWorkflow.signOut(driver);
			
			obj_EsupportProductionValidationsWorkflow.clickChangeProductLink(driver);
			
			obj_EsupportProductionValidationsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLaptopsLink(driver);
			obj_EsupportProductionValidationsWorkflow.ClickGSeriesLink(driver);
			
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			
			
			obj_EsupportProductionValidationsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportProductionValidationsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyOnlineSupportResourcesSelfHelpOption(driver);
			obj_EsupportProductionValidationsWorkflow.ClickSearchSupportLink(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyDiagnoseYourProblemSelfHelpOption(driver);
			obj_EsupportProductionValidationsWorkflow.ClickRunQuickTest(driver);
			Thread.sleep(7000);
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
			obj_EsupportProductionValidationsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLaptopsLink(driver);
			obj_EsupportProductionValidationsWorkflow.ClickGSeriesLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			
			obj_EsupportProductionValidationsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportProductionValidationsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
			
			obj_EsupportProductionValidationsWorkflow.ValidateIfCallUsChannelEnabled(driver);
			
			obj_EsupportProductionValidationsWorkflow.clickChangeProductLink(driver);

			obj_EsupportProductionValidationsWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
			
			obj_EsupportProductionValidationsWorkflow.RecentlyViewed(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnProductImageOfRecentlyViewed(driver);
			obj_EsupportProductionValidationsWorkflow.clickChangeProductLink(driver);	

			Thread.sleep(10000);

			//test case 7056524
//			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
			obj_EsupportProductionValidationsWorkflow.validateCtsHomePage(driver);	
			obj_EsupportProductionValidationsWorkflow.clickBrowseMyAssetsButton(driver);		
			obj_EsupportProductionValidationsWorkflow.enterSignInDetails(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));		
			obj_EsupportProductionValidationsWorkflow.signOut(driver);
			Thread.sleep(10000);
			//test case 7056536
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
			Thread.sleep(7000);
			obj_EsupportProductionValidationsWorkflow.validateCtsHomePage(driver);	
			obj_EsupportProductionValidationsWorkflow.validateSearchButtonDisabled(driver);		
			obj_EsupportProductionValidationsWorkflow.enterDataSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);			
			

			// test case 7695189
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.ToVerifyURL(driver);
						
			//test case 7123344
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
			Thread.sleep(7000);
			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			
			obj_EsupportProductionValidationsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			
			obj_EsupportProductionValidationsWorkflow.ValidateCarryInServiceLocatorChannelEnabled(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnFairRepairCenterButton(driver);
			obj_EsupportProductionValidationsWorkflow.EnterCityOrZipCodeAndClickSubmit(driver);
//			obj_EsupportProductionValidationsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);
			obj_EsupportProductionValidationsWorkflow.clickChangeProductLink(driver);
			
			obj_EsupportProductionValidationsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLaptopsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickInspironLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[5]);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[6]);
			
			obj_EsupportProductionValidationsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportProductionValidationsWorkflow.ValidateCarryInServiceLocatorChannelEnabled(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnFairRepairCenterButton(driver);
			obj_EsupportProductionValidationsWorkflow.EnterCityOrZipCodeAndClickSubmit(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			
//			driver.get("https://www.dell.com/support/home/en-us");
//			Thread.sleep(7000);
//			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
//			obj_EsupportProductionValidationsWorkflow.ClickOnContactTechnicalSupportFromContactUsSlider(driver);
//			obj_EsupportProductionValidationsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupportForCTSValidation(driver);

			
			
//			//test case 7695154(no test data)
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
			Thread.sleep(7000);
			obj_EsupportProductionValidationsWorkflow.clickChangeProductLink(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[4]);
			
			obj_EsupportProductionValidationsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportProductionValidationsWorkflow.ValidateBasicWarrantyDisclaimer(driver);
			
			
			
//			//test case 7695141(Ashwini running this)
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
			Thread.sleep(7000);
			obj_EsupportProductionValidationsWorkflow.clickChangeProductLink(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[5]);
			obj_EsupportProductionValidationsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4]);
			obj_EsupportProductionValidationsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
			
			obj_EsupportProductionValidationsWorkflow.time(driver);
//			//test case 7123037(no test data)
//			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
//			Thread.sleep(7000);
//			obj_EsupportProductionValidationsWorkflow.clickChangeProductLink(driver);
//			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[6]);
//			driver.getCurrentUrl();
//			Thread.sleep(10000);
//			
//			obj_EsupportProductionValidationsWorkflow.ValidateMessageDisplayedWhenTagHasOpenServiceRequest(driver);
//			
//			obj_EsupportProductionValidationsWorkflow.ClickOnViewDetails(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
//			
			
			//test case 7165930(no test data)
			
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownGreyedOut(driver);
//			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
//			//for US service tag
//			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownNotDisplayedForOOWTag(driver);
//
//			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection_OOWTag(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnSeeOptions(driver);
//			//for India service tag
//			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
//
//			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
//
//			obj_EsupportIncidentsWorkflow.ClickOnSearchSupport(driver);
//
//			obj_EsupportIncidentsWorkflow.ClickOnGetInteractiveSupportHyperlink(driver);
			
//			//test case 7124726(changes are there-yet to automate Live snap in chat window changes)
//			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
//			
//			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[3]);
//		
//			obj_EsupportProductionValidationsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
//			
//			obj_EsupportProductionValidationsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
//			obj_EsupportProductionValidationsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
//			
//			obj_EsupportProductionValidationsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
//			obj_EsupportProductionValidationsWorkflow.VerifyIfContactChannelOptionIsRecommended(driver);
//			
//			
//			obj_EsupportProductionValidationsWorkflow.ValidateIfLiveChatContactChannelIsEnabled(driver);

			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_8764363_AMER_FF_ProductionAutomation_ContactUs_LDELL_ESUPPORT--------->\n  "+e);

		}

	}
}
