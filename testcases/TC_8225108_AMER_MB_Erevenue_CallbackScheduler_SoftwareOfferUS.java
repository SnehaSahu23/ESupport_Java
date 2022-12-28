package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8225108_AMER_MB_Erevenue_CallbackScheduler_SoftwareOfferUS extends BaseTest
{
	@Test
	public void validate_TC_8225108_AMER_MB_Erevenue_CallbackScheduler_SoftwareOfferUS() 
	{
		try
		{
			System.out.println("Starts TC_8225108_AMER_MB_Erevenue_CallbackScheduler_SoftwareOfferUS");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
			//Work Around
            obj_EsupportMobileWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportMobileWorkflow.clickOnBuySoftwareSupport(driver);
            obj_EsupportMobileWorkflow.clickSoftwareSupportOtherPaymentOption(driver);
            obj_EsupportMobileWorkflow.verifySoftwareSupportPickAnotherSlotTime(driver);
			obj_EsupportMobileWorkflow.selectPaymentMethodAndClickNextButton(driver);
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.clickSoftwareSupportBackButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8225108_AMER_MB_Erevenue_CallbackScheduler_SoftwareOfferUS--------->\n  "+e);
		}
	}
}
