package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9849758_AMER_MB_MPS_PCF_MPSMyProductsListFilterApplyingFiltersToAMPSGridUsingTheFilterByOptionLayout_ESUPPORT extends MobilePage 
{
	@Test
	public void validate_TC_9849758_AMER_MB_MPS_PCF_MPSMyProductsListFilterApplyingFiltersToAMPSGridUsingTheFilterByOptionLayout_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9849758_AMER_MB_MPS_PCF_MPSMyProductsListFilterApplyingFiltersToAMPSGridUsingTheFilterByOptionLayout_ESUPPORT()");
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
            obj_EsupportMobileWorkflow.clickSignIn(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
            obj_EsupportMobileWorkflow.validateFilterOptionAboveGrid(driver);
            obj_EsupportMobileWorkflow.ClickFilterOptionAboveGridValidateOptionsDisplayed(driver);
            obj_EsupportMobileWorkflow.clickOnProductName_Filter(driver);
			
            obj_EsupportMobileWorkflow.ClickFilterOptionAboveGridValidateOptionsDisplayed(driver);
            obj_EsupportMobileWorkflow.clickOnWarrantyType_Filter(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9849758_AMER_MB_MPS_PCF_MPSMyProductsListFilterApplyingFiltersToAMPSGridUsingTheFilterByOptionLayout_ESUPPORT()--------->\n  "+e);
		}
	}
}
