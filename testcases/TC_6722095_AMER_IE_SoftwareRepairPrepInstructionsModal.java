package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6722095_AMER_IE_SoftwareRepairPrepInstructionsModal extends BaseTest
{
	@Test
	public void validate_TC_6722095_AMER_IE_SoftwareRepairPrepInstructionsModal() 
	{
		try
		{
			System.out.println("Starts TC_6722095_AMER_IE_SoftwareRepairPrepInstructionsModal");
			
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.ValidateOOWCustomerOffersDisplayedInOverviewTab(driver);
			obj_EsupportErevenueWorkflow.clickOnSoftwareRepairService(driver);
			obj_EsupportErevenueWorkflow.EnterDetailsIssueSoftwareRepair(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportErevenueWorkflow.selectAvailableSlotCallScheduling(driver);
			obj_EsupportErevenueWorkflow.verifyCheckboxandNextButtonPreparationInstructions(driver);
			obj_EsupportErevenueWorkflow.SelectCheckBoxForIAgree(driver);
			obj_EsupportErevenueWorkflow.clickPreparationInstructionCloseButton(driver);
			
			//Repeat the steps 3 to 7 and  click on the Back button
			obj_EsupportErevenueWorkflow.clickOnSoftwareRepairService(driver);
			obj_EsupportErevenueWorkflow.EnterDetailsIssueSoftwareRepair(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportErevenueWorkflow.selectAvailableSlotCallScheduling(driver);
			obj_EsupportErevenueWorkflow.verifyCheckboxandNextButtonPreparationInstructions(driver);
			obj_EsupportErevenueWorkflow.clickPreparationInstructionBackButton(driver);
		}
		
		
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6722095_AMER_IE_SoftwareRepairPrepInstructionsModal--------->\n  "+e);
		}
	}
}



