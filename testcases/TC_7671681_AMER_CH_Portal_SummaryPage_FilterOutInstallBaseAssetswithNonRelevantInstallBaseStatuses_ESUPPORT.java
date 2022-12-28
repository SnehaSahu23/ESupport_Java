package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7671681_AMER_CH_Portal_SummaryPage_FilterOutInstallBaseAssetswithNonRelevantInstallBaseStatuses_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7671681_AMER_CH_Portal_SummaryPage_FilterOutInstallBaseAssetswithNonRelevantInstallBaseStatuses_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7671681_AMER_CH_Portal_SummaryPage_FilterOutInstallBaseAssetswithNonRelevantInstallBaseStatuses_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportPortalWorkflow.ClickOnInstallBaseTab(driver);
			obj_EsupportPortalWorkflow.ValidateDefaultFilterInTabularViewInIBTabUnderAssets(driver);
			
			obj_EsupportPortalWorkflow.ClickOnFilterAndValidateIBStatusDefaultSelectedOptionsDisplayedInInstallBasePage(driver);
			obj_EsupportPortalWorkflow.ClickOnFilterAndValidateIBStatusDefaultNotSelectedOptionsDisplayedInInstallBasePage(driver);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7671681_AMER_CH_Portal_SummaryPage_FilterOutInstallBaseAssetswithNonRelevantInstallBaseStatuses_ESUPPORT--------->\n  "+e);
		}
	}
}
