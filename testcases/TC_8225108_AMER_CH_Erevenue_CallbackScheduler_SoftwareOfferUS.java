package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8225108_AMER_CH_Erevenue_CallbackScheduler_SoftwareOfferUS extends BaseTest
{
	@Test
	public void validate_TC_8225108_AMER_CH_Erevenue_CallbackScheduler_SoftwareOfferUS() 
	{
		try
		{
			System.out.println("Starts TC_8225108_AMER_CH_Erevenue_CallbackScheduler_SoftwareOfferUS");
			obj_EsupportContentWorkflow.handleCookies(driver);
		//	obj_EsupportErevenueWorkflow.verifySoftwareSupportOfferSchedulerInCTSPage(driver);
			
			//Work Around
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportErevenueWorkflow.clickSoftwareSupportOtherPaymentOption(driver);
			obj_EsupportErevenueWorkflow.verifySoftwareSupportPickAnotherSlotTime(driver);
			obj_EsupportErevenueWorkflow.selectPaymentMethodAndClickNextButton(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.clickSoftwareSupportBackButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8225108_AMER_CH_Erevenue_CallbackScheduler_SoftwareOfferUS--------->\n  "+e);
		}
	}
}
