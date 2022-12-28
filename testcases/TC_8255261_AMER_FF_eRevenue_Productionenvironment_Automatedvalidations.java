package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8255261_AMER_FF_eRevenue_Productionenvironment_Automatedvalidations extends BaseTest
{
	@Test
	public void validate_TC_8255261_AMER_FF_eRevenue_Productionenvironment_Automatedvalidations()
	{
		try
		{
			System.out.println("Starts TC_8255261_AMER_FF_eRevenue_Productionenvironment_Automatedvalidations");
			
			//TC_6722287_AMER_CH_Erevenue_OOWDepotFreeTextEntryBox_ESUPPORT
			
			//obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportProductionValidationsWorkflow.clickBuyStandardButton(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyNextButtonInIssueDetailsPageOfPopup(driver);
			
			obj_EsupportProductionValidationsWorkflow.enterTextInTextboxAndClickXButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.clickBuyStandardButton(driver);
			obj_EsupportProductionValidationsWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			
			Thread.sleep(5000);
			
////			TC_6727274_AMER_CH_Erevenue_SoftwareRepair_FreeTextEntryBox_ESUPPORT
//			//obj_EsupportContentWorkflow.handleCookies(driver);
//			driver.get("http://www.dell.com/support/home");
//			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//			obj_EsupportErevenueWorkflow.clickOnBuySoftwareSupport(driver);
//			obj_EsupportErevenueWorkflow.selectPaymentMethodAndClickNextButton(driver);
//			obj_EsupportErevenueWorkflow.selectCheckBoxForIAgreeSoftwareSupportAndEnterIssue(driver);
//			//obj_EsupportErevenueWorkflow.selectAvailableSlotAndClickNextButton(driver);
//			obj_EsupportErevenueWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
//			obj_EsupportErevenueWorkflow.clickOnBuySoftwareSupport(driver);
//			obj_EsupportErevenueWorkflow.selectPaymentMethodAndClickNextButton(driver);
//			obj_EsupportErevenueWorkflow.selectCheckBoxForIAgreeSoftwareSupportAndEnterIssue(driver);
//			//obj_EsupportErevenueWorkflow.selectAvailableSlotAndClickNextButton(driver);
//			
//			obj_EsupportErevenueWorkflow.ValidateFreeTextBoxEnteringMoreThan150Characters(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
//			Thread.sleep(5000);
//			obj_EsupportErevenueWorkflow.VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
//			obj_EsupportErevenueWorkflow.VerifyNextButtonInIssueDetailsPageOfPopup(driver);
//			obj_EsupportErevenueWorkflow.VerifyTheLabelOfTextBox(driver);
//			

			//TC_6795403_AMER_CH_UpdateOfferCardswithLearnMoreLink
		//	obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
	//		obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			driver.get("http://www.dell.com/support/home");
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportProductionValidationsWorkflow.verifyLearnMoreLinksHardwareRepair(driver);
			obj_EsupportProductionValidationsWorkflow.verifyLearnMoreLinksSoftwareRepair(driver);
			obj_EsupportProductionValidationsWorkflow.clickLearnMoreLinkHardwareRepairStandard(driver);
			obj_EsupportProductionValidationsWorkflow.clickLearnMoreLinkSoftwareRepair(driver);
			
			//TC_6884508_AMER_CH_UpdateSWOffercardwithToolTip
		//	obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			//obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			driver.get("http://www.dell.com/support/home");
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportProductionValidationsWorkflow.verifyTooltipSoftwareSection(driver);
			obj_EsupportProductionValidationsWorkflow.clickTooltipSoftwareSection(driver);
			obj_EsupportProductionValidationsWorkflow.verifyTooltipTextDisabled(driver);

			//TC_8184485_AMER_CH_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS
			driver.get("http://www.dell.com/support/home");
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.verifyIssueListInCTSPage(driver);
			
			Thread.sleep(5000);
			
			//TC_8184899_AMER_CH_EREV_Offer_PurchaseUI_inUS
			
			//	obj_EsupportErevenueWorkflow.verifyHardwareRepairInCTSPage(driver);
				
				Thread.sleep(5000);
				driver.navigate().to("https://www.dell.com/support/home");
				obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
				Thread.sleep(5000);
				obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
				obj_EsupportProductionValidationsWorkflow.selectIssueAndSubIssueFromDropdownOverviewTab(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[8], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[9]);
				obj_EsupportProductionValidationsWorkflow.verifyHardwareOfferTile(driver);
				obj_EsupportProductionValidationsWorkflow.clickBuyStandardButton(driver);
				obj_EsupportProductionValidationsWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
				obj_EsupportProductionValidationsWorkflow.selectCheckBoxForIAgreeHardwareOffer(driver);
				Thread.sleep(5000);
				obj_EsupportProductionValidationsWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
				Thread.sleep(5000);
				obj_EsupportProductionValidationsWorkflow.clickResetButtonOverviewTab(driver);
				Thread.sleep(10000);
				obj_EsupportProductionValidationsWorkflow.clickBuyStandardButton(driver);
				obj_EsupportProductionValidationsWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
				obj_EsupportProductionValidationsWorkflow.selectCheckBoxForIAgreeHardwareOffer(driver);
				
				
				//TC_8194733_AMER_CH_EREV_EnableSoftwarerepairOfferinUS
				driver.get("http://www.dell.com/support/home");
				obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
				obj_EsupportProductionValidationsWorkflow.verifySoftwareSupportOfferInContactTechnicalSupport(driver);
				
				Thread.sleep(5000);
				driver.navigate().to("https://www.dell.com/support/home");
				Thread.sleep(5000);
				obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
				obj_EsupportProductionValidationsWorkflow.selectIssueAndSubIssueFromDropdownOverviewTab(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[8]);
				obj_EsupportProductionValidationsWorkflow.clickOnBuySoftwareSupport(driver);
				obj_EsupportProductionValidationsWorkflow.selectPaymentMethodAndClickNextButton(driver);
				Thread.sleep(5000);
				obj_EsupportProductionValidationsWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
				obj_EsupportProductionValidationsWorkflow.clickResetButtonOverviewTab(driver);
				Thread.sleep(5000);
				obj_EsupportProductionValidationsWorkflow.clickOnBuySoftwareSupport(driver);
				obj_EsupportProductionValidationsWorkflow.selectPaymentMethodAndClickNextButton(driver);
				
				
				//TC_8195314_AMER_CH_Erevenue_OOWCustomer_CartUS
				driver.get("http://www.dell.com/support/home");
				obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
				obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
				obj_EsupportProductionValidationsWorkflow.verifyHardwareOfferTile(driver);
				obj_EsupportProductionValidationsWorkflow.verifySoftwareOfferTile(driver);
				obj_EsupportProductionValidationsWorkflow.enterServiceTagAndVerifyHardwareAndSoftwareOfferInCTS(driver);
				
				//TC_8225108_AMER_CH_Erevenue_CallbackScheduler_SoftwareOfferUS
				driver.get("http://www.dell.com/support/home");
				obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			//	obj_EsupportErevenueWorkflow.verifySoftwareSupportOfferSchedulerInCTSPage(driver);
				
				//Work Around
				obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
				obj_EsupportProductionValidationsWorkflow.clickOnBuySoftwareSupport(driver);
				obj_EsupportProductionValidationsWorkflow.clickSoftwareSupportOtherPaymentOption(driver);
				obj_EsupportProductionValidationsWorkflow.verifySoftwareSupportPickAnotherSlotTime(driver);
				obj_EsupportProductionValidationsWorkflow.selectPaymentMethodAndClickNextButton(driver);
				Thread.sleep(5000);
				obj_EsupportProductionValidationsWorkflow.clickSoftwareSupportBackButton(driver);
				
				//TC_8506576_AMER_CH_Erevenue_Addmessaging_onthe_SWSchedulerModal
				driver.get("http://www.dell.com/support/home");
				obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
				obj_EsupportProductionValidationsWorkflow.clickOnBuySoftwareSupport(driver);
				obj_EsupportProductionValidationsWorkflow.verifySoftwareSupportPaymentOptions(driver);
				obj_EsupportProductionValidationsWorkflow.clickSoftwareSupportOtherPaymentOption(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8255261_AMER_FF_eRevenue_Productionenvironment_Automatedvalidations--------->\n  "+e);
		}
	}
}


