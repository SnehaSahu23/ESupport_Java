package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8506576_AMER_MB_Erevenue_Addmessaging_onthe_SWSchedulerModal extends BaseTest
{
	@Test
	public void validate_TC_8506576_AMER_MB_Erevenue_Addmessaging_onthe_SWSchedulerModal() 
	{
		try
		{
			System.out.println("Starts TC_8506576_AMER_MB_Erevenue_Addmessaging_onthe_SWSchedulerModal");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportMobileWorkflow.clickOnBuySoftwareSupport(driver);
            obj_EsupportMobileWorkflow.verifySoftwareSupportPaymentOptions(driver);
			obj_EsupportMobileWorkflow.clickSoftwareSupportOtherPaymentOption(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8506576_AMER_MB_Erevenue_Addmessaging_onthe_SWSchedulerModal--------->\n  "+e);
		}
	}
}

