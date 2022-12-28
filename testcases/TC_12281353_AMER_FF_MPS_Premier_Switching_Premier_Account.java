package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_12281353_AMER_FF_MPS_Premier_Switching_Premier_Account extends BaseTest
{
	@Test
	public void validate_TC_12281353_AMER_FF_MPS_Premier_Switching_Premier_Account()
	{
		try
		{
			obj_EsupportMPSWorkflow.SignInToPremierAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()),
					                                               TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[0]);
		    obj_EsupportMPSWorkflow.ValidateMyProductsTab(driver);
		    obj_EsupportMPSWorkflow.clickOnSwitchToPremierAccount(driver);
		    obj_EsupportMPSWorkflow.selectPremierAccountFromDropdown(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(",")[1]);
		    obj_EsupportMPSWorkflow.ValidateMyProductsTab(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_12281353_AMER_FF_MPS_Premier_Switching_Premier_Account--------->\n  "+e);
		}
	}
}
