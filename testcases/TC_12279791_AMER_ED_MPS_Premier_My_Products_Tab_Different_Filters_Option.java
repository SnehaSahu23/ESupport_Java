package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_12279791_AMER_ED_MPS_Premier_My_Products_Tab_Different_Filters_Option extends BaseTest
{
	@Test
	public void validate_TC_12279791_AMER_ED_MPS_Premier_My_Products_Tab_Different_Filters_Option()
	{
		try
		{
			obj_EsupportMPSWorkflow.SignInToPremierAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()),
					TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportMPSWorkflow.validateFilterOptionAboveGrid(driver);
			
			obj_EsupportMPSWorkflow.ClickFilterOptionAboveGridValidateOptionsDisplayed(driver);
			obj_EsupportMPSWorkflow.clickOnProductName_Filter(driver);
			
			obj_EsupportMPSWorkflow.ClickFilterOptionAboveGridValidateOptionsDisplayed(driver);
			obj_EsupportMPSWorkflow.clickOnWarrantyStatus_Filter(driver);
			
			obj_EsupportMPSWorkflow.ClickFilterOptionAboveGridValidateOptionsDisplayed(driver);
			obj_EsupportMPSWorkflow.clickOnWarrantyType_Filter(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_12279791_AMER_ED_MPS_Premier_My_Products_Tab_Different_Filters_Option--------->\n  "+e);
		}
	}
}
