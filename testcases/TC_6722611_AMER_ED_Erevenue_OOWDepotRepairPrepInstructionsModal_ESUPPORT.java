package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6722611_AMER_ED_Erevenue_OOWDepotRepairPrepInstructionsModal_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6722611_AMER_ED_Erevenue_OOWDepotRepairPrepInstructionsModal_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6722611_AMER_ED_Erevenue_OOWDepotRepairPrepInstructionsModal_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.ValidateOOWCustomerOffersDisplayedInOverviewTab(driver);
			obj_EsupportErevenueWorkflow.ClickOnStandardOrExpressService(driver);
			obj_EsupportErevenueWorkflow.ValidateEnteringDetailsInTextEntryBoxAndClickNext(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportErevenueWorkflow.ValidateNextButtonInPreparationInstructionsPage(driver);
			obj_EsupportErevenueWorkflow.VerifyCheckBoxForIAgreeIsUncheckedByDefault(driver);
			obj_EsupportErevenueWorkflow.SelectCheckBoxForIAgree(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6722611_AMER_ED_Erevenue_OOWDepotRepairPrepInstructionsModal_ESUPPORT--------->\n  "+e);
		}
	}
}

