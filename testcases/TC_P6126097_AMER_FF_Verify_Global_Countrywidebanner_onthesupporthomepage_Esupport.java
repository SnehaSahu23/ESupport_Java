package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_P6126097_AMER_FF_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport extends BaseTest
{
	@Test
	public void validate_TC_P6126097_AMER_FF_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_P6126097_AMER_FF_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport");
			System.out.println("Entering into Prod.");
			System.out.println("Integrated HomePage.");
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);

			obj_EsupportIntegratedHomePageWorkflow.verifyIntegratedSupportHomePage(driver);
			obj_EsupportIntegratedHomePageWorkflow.ProdverifyalertbannerssupportHomePage(driver);
			obj_EsupportIntegratedHomePageWorkflow.ProdclickOnLinkInBanners(driver);
			driver.navigate().back();
			Thread.sleep(3000);
			obj_EsupportIntegratedHomePageWorkflow.countryExecution_prod(driver);


		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_P6126097_AMER_FF_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport--------->\n  "+e);

		}

	}
}
