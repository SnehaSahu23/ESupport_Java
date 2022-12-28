package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6795403_AMER_IE_UpdateOfferCardswithLearnMoreLink extends BaseTest
{
	@Test
	public void validate_TC_6795403_AMER_IE_UpdateOfferCardswithLearnMoreLink() 
	{
		try
		{
			System.out.println("Starts TC_6795403_AMER_IE_UpdateOfferCardswithLearnMoreLink");
			obj_EsupportIPSWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.verifyLearnMoreLinksHardwareRepair(driver);
			obj_EsupportErevenueWorkflow.verifyLearnMoreLinksSoftwareRepair(driver);
			obj_EsupportErevenueWorkflow.clickLearnMoreLinkHardwareRepairStandard(driver);
			//obj_EsupportErevenueWorkflow.clickLearnMoreLinkHardwareRepairExpress(driver);
			obj_EsupportErevenueWorkflow.clickLearnMoreLinkSoftwareRepair(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6795403_AMER_IE_UpdateOfferCardswithLearnMoreLink--------->\n  "+e);
		}
	}
}
