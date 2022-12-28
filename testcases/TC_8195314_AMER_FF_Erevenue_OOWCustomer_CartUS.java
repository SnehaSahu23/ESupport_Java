package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8195314_AMER_FF_Erevenue_OOWCustomer_CartUS extends BaseTest
{
	@Test
	public void validate_TC_8195314_AMER_FF_Erevenue_OOWCustomer_CartUS() 
	{
		try
		{
			System.out.println("Starts TC_8195314_AMER_FF_Erevenue_OOWCustomer_CartUS");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.verifyHardwareOfferTile(driver);
			obj_EsupportErevenueWorkflow.verifySoftwareOfferTile(driver);
//			obj_EsupportErevenueWorkflow.enterServiceTagAndVerifyHardwareAndSoftwareOfferInCTS(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8195314_AMER_FF_Erevenue_OOWCustomer_CartUS--------->\n  "+e);
		}
	}
}
