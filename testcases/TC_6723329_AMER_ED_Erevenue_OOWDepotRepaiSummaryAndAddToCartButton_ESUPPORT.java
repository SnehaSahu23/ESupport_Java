package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6723329_AMER_ED_Erevenue_OOWDepotRepaiSummaryAndAddToCartButton_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6723329_AMER_ED_Erevenue_OOWDepotRepaiSummaryAndAddToCartButton_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6723329_AMER_ED_Erevenue_OOWDepotRepaiSummaryAndAddToCartButton_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.ValidateOOWCustomerOffersDisplayedInOverviewTab(driver);
			obj_EsupportErevenueWorkflow.ClickOnStandardOrExpressService(driver);
			
			obj_EsupportErevenueWorkflow.ValidateEnteringDetailsInTextEntryBoxAndClickNext(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			obj_EsupportErevenueWorkflow.SelectCheckBoxForIAgreeAndClickOnNext(driver);
			
			obj_EsupportErevenueWorkflow.ValidateClickingOnBackButton(driver);
			
			obj_EsupportErevenueWorkflow.VerifySMSOptInCheckBox(driver);
			
			obj_EsupportErevenueWorkflow.ClickOnAddToCartButtonAndValidateLandingPage(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6723329_AMER_ED_Erevenue_OOWDepotRepaiSummaryAndAddToCartButton_ESUPPORT--------->\n  "+e);
		}
	}
}
