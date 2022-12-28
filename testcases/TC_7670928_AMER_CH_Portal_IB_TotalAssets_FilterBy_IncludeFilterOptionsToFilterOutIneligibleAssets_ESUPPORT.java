package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7670928_AMER_CH_Portal_IB_TotalAssets_FilterBy_IncludeFilterOptionsToFilterOutIneligibleAssets_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7670928_AMER_CH_Portal_IB_TotalAssets_FilterBy_IncludeFilterOptionsToFilterOutIneligibleAssets_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7670928_AMER_CH_Portal_IB_TotalAssets_FilterBy_IncludeFilterOptionsToFilterOutIneligibleAssets_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ClickOnInstallBaseTab(driver);
			
			obj_EsupportPortalWorkflow.ValidateDefaultFilterInTabularViewInIBTabUnderAssets(driver);
			
			obj_EsupportPortalWorkflow.ClickOnFilterAndValidateEligibleForConnectivityFilter(driver);
			
			obj_EsupportPortalWorkflow.ClickOnFilterAndValidateEligibleForCodeLevelsFilter(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7670928_AMER_CH_Portal_IB_TotalAssets_FilterBy_IncludeFilterOptionsToFilterOutIneligibleAssets_ESUPPORT--------->\n  "+e);
		}
	}
}
