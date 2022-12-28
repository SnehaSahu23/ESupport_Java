package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9849758_AMER_CH_MPS_PCF_MPSMyProductsListFilterApplyingFiltersToAMPSGridUsingTheFilterByOptionLayout_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9849758_AMER_CH_MPS_PCF_MPSMyProductsListFilterApplyingFiltersToAMPSGridUsingTheFilterByOptionLayout_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9849758_AMER_CH_MPS_PCF_MPSMyProductsListFilterApplyingFiltersToAMPSGridUsingTheFilterByOptionLayout_ESUPPORT()");
			
//			obj_EsupportMPSWorkflow.clickSignIn(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.SignInToMyAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.validateFilterOptionAboveGrid(driver);
			obj_EsupportMPSWorkflow.ClickFilterOptionAboveGridValidateOptionsDisplayed(driver);
			obj_EsupportMPSWorkflow.clickOnProductName_Filter(driver);
			
			obj_EsupportMPSWorkflow.ClickFilterOptionAboveGridValidateOptionsDisplayed(driver);
			obj_EsupportMPSWorkflow.clickOnWarrantyType_Filter(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9849758_AMER_CH_MPS_PCF_MPSMyProductsListFilterApplyingFiltersToAMPSGridUsingTheFilterByOptionLayout_ESUPPORT()--------->\n  "+e);
		}
	}
}
