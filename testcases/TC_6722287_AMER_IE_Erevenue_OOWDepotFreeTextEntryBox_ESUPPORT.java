package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6722287_AMER_IE_Erevenue_OOWDepotFreeTextEntryBox_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6722287_AMER_IE_Erevenue_OOWDepotFreeTextEntryBox_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6722287_AMER_IE_Erevenue_OOWDepotFreeTextEntryBox_ESUPPORT");
		//	obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.ClickOnStandardOrExpressService(driver);
			obj_EsupportErevenueWorkflow.VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportErevenueWorkflow.VerifyNextButtonInIssueDetailsPageOfPopup(driver);

			obj_EsupportErevenueWorkflow.enterTextInTextboxAndClickXButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportErevenueWorkflow.ClickOnStandardOrExpressService(driver);
			obj_EsupportErevenueWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);

			
//			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//			obj_EsupportErevenueWorkflow.ValidateOOWCustomerOffersDisplayedInOverviewTab(driver);
//			obj_EsupportErevenueWorkflow.ClickOnStandardOrExpressService(driver);
//			obj_EsupportErevenueWorkflow.VerifyNextButtonInIssueDetailsPageOfPopup(driver);
//			obj_EsupportErevenueWorkflow.VerifyTheLabelOfTextBox(driver);
//			obj_EsupportErevenueWorkflow.VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
//			obj_EsupportErevenueWorkflow.ValidateEnteringDetailsInTextEntryBoxAndClickNext2(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportErevenueWorkflow.ClickOnBackButton(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportErevenueWorkflow.ValidateFreeTextBoxEnteringMoreThan150Characters(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
//			obj_EsupportErevenueWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6722287_AMER_IE_Erevenue_OOWDepotFreeTextEntryBox_ESUPPORT--------->\n  "+e);
		}
	}
}
