package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8506576_AMER_ED_Erevenue_Addmessaging_onthe_SWSchedulerModal extends BaseTest
{
	@Test
	public void validate_TC_8506576_AMER_ED_Erevenue_Addmessaging_onthe_SWSchedulerModal() 
	{
		try
		{
			System.out.println("Starts TC_8506576_AMER_ED_Erevenue_Addmessaging_onthe_SWSchedulerModal");
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportErevenueWorkflow.verifySoftwareSupportPaymentOptions(driver);
			obj_EsupportErevenueWorkflow.clickSoftwareSupportOtherPaymentOption(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8506576_AMER_ED_Erevenue_Addmessaging_onthe_SWSchedulerModal--------->\n  "+e);
		}
	}
}