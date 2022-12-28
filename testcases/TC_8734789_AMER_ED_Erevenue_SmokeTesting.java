package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8734789_AMER_ED_Erevenue_SmokeTesting extends BaseTest
{
	@Test
	public void validate_TC_8734789_AMER_ED_Erevenue_SmokeTesting() 
	{
		try
		{
			System.out.println("Starts TC_8734789_AMER_ED_Erevenue_SmokeTesting");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.verifyHardwareOfferTile(driver);
			obj_EsupportErevenueWorkflow.verifySoftwareOfferTile(driver);
			obj_EsupportErevenueWorkflow.verifyLearnMoreLinksHardwareRepair(driver);
			obj_EsupportErevenueWorkflow.verifyLearnMoreLinksSoftwareRepair(driver);
			obj_EsupportProductionValidationsWorkflow.verifyTooltipSoftwareSection(driver);
			obj_EsupportProductionValidationsWorkflow.clickTooltipSoftwareSection(driver);
			
			//Verify Hardware Standard Offer
			Thread.sleep(5000);
		//	obj_EsupportErevenueWorkflow.selectIssueFromDropdownHardwareOffer(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			//obj_EsupportErevenueWorkflow.verifyHardwareOfferTile(driver);
			obj_EsupportErevenueWorkflow.clickBuyStandardButton(driver);
			obj_EsupportErevenueWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportErevenueWorkflow.selectCheckBoxForIAgreeHardwareOffer(driver);
			obj_EsupportErevenueWorkflow.clickAddToCartButton(driver);
			obj_EsupportErevenueWorkflow.verifyCartDetails(driver);
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(10000);
			
			//Verify Hardware Express Offer
			//obj_EsupportErevenueWorkflow.selectIssueFromDropdownHardwareOffer(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportErevenueWorkflow.clickBuyExpressButton(driver);
			obj_EsupportErevenueWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportErevenueWorkflow.selectCheckBoxForIAgreeHardwareOffer(driver);
			obj_EsupportErevenueWorkflow.clickAddToCartButton(driver);
			obj_EsupportErevenueWorkflow.verifyCartDetails(driver);
			
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(10000);
			
			//Verify Software Offer
		//	obj_EsupportErevenueWorkflow.selectIssueFromDropdownSoftwareSupport(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportErevenueWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportErevenueWorkflow.selectPaymentMethodAndClickNextButton(driver);
			obj_EsupportErevenueWorkflow.selectCheckBoxForIAgreeSoftwareSupportAndEnterIssue(driver);
			obj_EsupportErevenueWorkflow.clickAddToCartButton(driver);
			obj_EsupportErevenueWorkflow.verifyCartDetails(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8734789_AMER_ED_Erevenue_SmokeTesting--------->\n  "+e);
		}
	}
}