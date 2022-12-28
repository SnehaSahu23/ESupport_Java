package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5775324_AMER_IE_CriticalLinksResources_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5775324_AMER_IE_CriticalLinksResources_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5775324_AMER_IE_CriticalLinksResources_Esupport");
			System.out.println("Hai");
			obj_EsupportIntegratedHomePageWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyQuickLinks(driver);
//			obj_EsupportIntegratedHomePageWorkflow.ToVerify_WebPartsbelowProductSelector(driver);
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_clickonSoftwareLicence(driver);
			driver.navigate().back();
			obj_EsupportIntegratedHomePageWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyWarrantyContracts(driver);
			driver.navigate().back();
			obj_EsupportIntegratedHomePageWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyDriversDownloads(driver);
			driver.navigate().back();
			obj_EsupportIntegratedHomePageWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyDiagnosticsTools(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while TC_5780094_AMER_IE_ContactUSSliderColdUserorLdellcustomer_Esupport--------->\n  "+e);
		}
	}
}
