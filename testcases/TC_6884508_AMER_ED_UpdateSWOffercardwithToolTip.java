package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6884508_AMER_ED_UpdateSWOffercardwithToolTip extends BaseTest
{
	@Test
	public void validate_TC_6884508_AMER_ED_UpdateSWOffercardwithToolTip() 
	{
		try
		{
			System.out.println("Starts TC_6884508_AMER_ED_UpdateSWOffercardwithToolTip");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			//obj_EsupportErevenueWorkflow.ValidateOOWCustomerOffersDisplayedInOverviewTab(driver);
			obj_EsupportErevenueWorkflow.verifyTooltipSoftwareSection(driver);
			obj_EsupportErevenueWorkflow.clickTooltipSoftwareSection(driver);
			obj_EsupportErevenueWorkflow.verifyTooltipTextDisabled(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6884508_AMER_ED_UpdateSWOffercardwithToolTip--------->\n  "+e);
		}
	}
}

