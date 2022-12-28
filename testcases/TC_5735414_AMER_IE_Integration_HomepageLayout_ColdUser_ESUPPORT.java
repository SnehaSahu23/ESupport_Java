package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5735414_AMER_IE_Integration_HomepageLayout_ColdUser_ESUPPORT extends BaseTest{


	@Test
	public void validate_TC_5735414_AMER_IE_Integration_HomepageLayout_ColdUser_ESUPPORT(){


		try
		{
			System.out.println("Starting TC_5735414_AMER_IE_Integration_HomepageLayout_ColdUser_ESUPPORT..."); 

			System.out.println("Integrated HomePage.");
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);

			obj_EsupportIntegratedHomePageWorkflow.verifyIntegratedSupportHomePage(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyMastheadLinks(driver);
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_EnterServiceTags(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_WebPartsbelowProductSelector(driver);
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_ClickLefticonWindowsicon(driver);
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
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);

			
			obj_EsupportIntegratedHomePageWorkflow.toClickDellLogo(driver);
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickDellTechnologies(driver);
			
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5735414_AMER_IE_Integration_HomepageLayout_ColdUser_ESUPPORT--------->\n  "+e);
		}



	}

}
