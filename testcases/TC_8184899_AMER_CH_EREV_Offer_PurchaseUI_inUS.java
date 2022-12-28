package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8184899_AMER_CH_EREV_Offer_PurchaseUI_inUS extends BaseTest
{
	@Test
	public void validate_TC_8184899_AMER_CH_EREV_Offer_PurchaseUI_inUS() 
	{
		try
		{
			System.out.println("Starts TC_8184899_AMER_CH_EREV_Offer_PurchaseUI_inUS");
			obj_EsupportErevenueWorkflow.handleCookies(driver);
		//	obj_EsupportErevenueWorkflow.verifyHardwareRepairInCTSPage(driver);
			
			Thread.sleep(5000);
			driver.navigate().to("https://www.dell.com/support/home");
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.selectIssueAndSubIssueFromDropdownOverviewTab(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			obj_EsupportErevenueWorkflow.verifyHardwareOfferTile(driver);
			obj_EsupportErevenueWorkflow.clickBuyStandardButton(driver);
			obj_EsupportErevenueWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportErevenueWorkflow.selectCheckBoxForIAgreeHardwareOffer(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.clickResetButtonOverviewTab(driver);
			Thread.sleep(10000);
			obj_EsupportErevenueWorkflow.clickBuyStandardButton(driver);
			obj_EsupportErevenueWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportErevenueWorkflow.selectCheckBoxForIAgreeHardwareOffer(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8184899_AMER_CH_EREV_Offer_PurchaseUI_inUS--------->\n  "+e);
		}
	}
}
