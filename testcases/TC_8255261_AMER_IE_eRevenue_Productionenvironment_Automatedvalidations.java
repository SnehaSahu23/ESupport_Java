package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8255261_AMER_IE_eRevenue_Productionenvironment_Automatedvalidations extends BaseTest
{
	@Test
	public void validate_TC_8255261_AMER_IE_eRevenue_Productionenvironment_Automatedvalidations()
	{
		try
		{
			System.out.println("Starts TC_8255261_AMER_IE_eRevenue_Productionenvironment_Automatedvalidations");
			
			//TC_6722287_AMER_IE_Erevenue_OOWDepotFreeTextEntryBox_ESUPPORT
			
			//obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			Thread.sleep(5000);
			driver.navigate().to("https://www.dell.com/support/home");
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.verifyIssueListInCTSPage(driver);
			
			Thread.sleep(5000);
			driver.navigate().to("https://www.dell.com/support/home");
			Thread.sleep(5000);
			//TC_6722287_AMER_CH_Erevenue_OOWDepotFreeTextEntryBox_ESUPPORT
			
			//obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.clickBuyStandardButton(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyNextButtonInIssueDetailsPageOfPopup(driver);
			
			obj_EsupportProductionValidationsWorkflow.enterTextInTextboxAndClickXButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.clickBuyStandardButton(driver);
			obj_EsupportProductionValidationsWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			
			Thread.sleep(5000);
			//TC_6727274_AMER_CH_Erevenue_SoftwareRepair_FreeTextEntryBox_ESUPPORT
			//obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
		//	obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportProductionValidationsWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportProductionValidationsWorkflow.selectPaymentMethodAndClickNextButton(driver);
			obj_EsupportProductionValidationsWorkflow.selectCheckBoxForIAgreeSoftwareSupportAndEnterIssue(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			obj_EsupportProductionValidationsWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportProductionValidationsWorkflow.selectPaymentMethodAndClickNextButton(driver);
			obj_EsupportProductionValidationsWorkflow.selectCheckBoxForIAgreeSoftwareSupportAndEnterIssue(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateFreeTextBoxEnteringMoreThan150Characters(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyNextButtonInIssueDetailsPageOfPopup(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyTheLabelOfTextBox(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			
			//TC_6795403_AMER_CH_UpdateOfferCardswithLearnMoreLink
		//	obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
	//		obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportProductionValidationsWorkflow.verifyLearnMoreLinksHardwareRepair(driver);
			obj_EsupportProductionValidationsWorkflow.verifyLearnMoreLinksSoftwareRepair(driver);
			obj_EsupportProductionValidationsWorkflow.clickLearnMoreLinkHardwareRepairStandard(driver);
			obj_EsupportProductionValidationsWorkflow.clickLearnMoreLinkSoftwareRepair(driver);
			
			//TC_6884508_AMER_CH_UpdateSWOffercardwithToolTip
		//	obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			//obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportProductionValidationsWorkflow.verifyTooltipSoftwareSection(driver);
			obj_EsupportProductionValidationsWorkflow.clickTooltipSoftwareSection(driver);
			obj_EsupportProductionValidationsWorkflow.verifyTooltipTextDisabled(driver);
//			
//			//TC_8195314_AMER_CH_Erevenue_OOWCustomer_CartUS
//		//	obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
//obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.verifyHardwareOfferTile(driver);
			obj_EsupportProductionValidationsWorkflow.verifySoftwareOfferTile(driver);
//			
//			Thread.sleep(5000);
//			driver.navigate().to("https://www.dell.com/support/home");
//			Thread.sleep(5000);
			
			obj_EsupportProductionValidationsWorkflow.enterServiceTagAndVerifyHardwareAndSoftwareOfferInCTS(driver);
			
			//Starts TC_8184899_AMER_CH_EREV_Offer_PurchaseUI_inUS
//			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
//			obj_EsupportProductionValidationsWorkflow.verifyHardwareRepairInCTSPage(driver);
			
			Thread.sleep(5000);
			driver.navigate().to("https://www.dell.com/support/home");
			Thread.sleep(5000);
			
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.selectIssueAndSubIssueFromDropdownOverviewTab(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[5]);
			obj_EsupportProductionValidationsWorkflow.verifyHardwareOfferTile(driver);
			obj_EsupportProductionValidationsWorkflow.clickBuyStandardButton(driver);
			obj_EsupportProductionValidationsWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.selectCheckBoxForIAgreeHardwareOffer(driver);
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.clickResetButtonOverviewTab(driver);
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.clickBuyStandardButton(driver);
			obj_EsupportProductionValidationsWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.selectCheckBoxForIAgreeHardwareOffer(driver);
			
			//Starts TC_8194733_AMER_CH_EREV_EnableSoftwarerepairOfferinUS
//			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
//			obj_EsupportProductionValidationsWorkflow.verifySoftwareSupportOfferInContactTechnicalSupport(driver);
			
			Thread.sleep(5000);
			driver.navigate().to("https://www.dell.com/support/home");
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.selectIssueAndSubIssueFromDropdownOverviewTab(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[5]);
			obj_EsupportProductionValidationsWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportProductionValidationsWorkflow.selectPaymentMethodAndClickNextButton(driver);
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.clickResetButtonOverviewTab(driver);
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportProductionValidationsWorkflow.selectPaymentMethodAndClickNextButton(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			Thread.sleep(5000);
			
			//Starts TC_8225108_AMER_CH_Erevenue_CallbackScheduler_SoftwareOfferUS
		//	obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
		//	obj_EsupportProductionValidationsWorkflow.verifySoftwareSupportOfferSchedulerInCTSPage(driver);
			
			obj_EsupportProductionValidationsWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportProductionValidationsWorkflow.clickSoftwareSupportOtherPaymentOption(driver);
			obj_EsupportProductionValidationsWorkflow.verifySoftwareSupportPickAnotherSlotTime(driver);
			obj_EsupportProductionValidationsWorkflow.selectPaymentMethodAndClickNextButton(driver);
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.clickSoftwareSupportBackButton(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8255261_AMER_IE_eRevenue_Productionenvironment_Automatedvalidations--------->\n  "+e);
		}
	}
}

