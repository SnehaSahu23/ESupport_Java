package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6722211_AMER_IE_SoftwareRepairSummaryAddtoCartButton extends BaseTest
{
	@Test
	public void validate_TC_6722211_AMER_IE_SoftwareRepairSummaryAddtoCartButton() 
	{
		try
		{
			System.out.println("Starts TC_6722211_AMER_IE_SoftwareRepairSummaryAddtoCartButton");
			
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.ValidateOOWCustomerOffersDisplayedInOverviewTab(driver);
			obj_EsupportErevenueWorkflow.clickOnSoftwareRepairService(driver);
			obj_EsupportErevenueWorkflow.EnterDetailsIssueSoftwareRepair(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportErevenueWorkflow.selectAvailableSlotCallScheduling(driver);
			obj_EsupportErevenueWorkflow.verifyCheckboxandNextButtonPreparationInstructions(driver);
			obj_EsupportErevenueWorkflow.SelectCheckBoxForIAgree(driver);
			obj_EsupportErevenueWorkflow.clickPreparationInstructionNextButton(driver);
			obj_EsupportErevenueWorkflow.clickAddToCartButton(driver);
		}
		
		
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6722211_AMER_IE_SoftwareRepairSummaryAddtoCartButton--------->\n  "+e);
		}
	}
}

