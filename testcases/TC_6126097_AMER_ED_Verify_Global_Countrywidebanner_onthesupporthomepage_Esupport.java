package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_6126097_AMER_ED_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6126097_AMER_ED_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_6126097_AMER_ED_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport");
			System.out.println("Entering into SIT.");
			System.out.println("Integrated HomePage.");
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);

			obj_EsupportIntegratedHomePageWorkflow.verifyIntegratedSupportHomePage(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyalertbannerssupportHomePage(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOnLinkInBanners(driver);
			driver.navigate().back();
			Thread.sleep(3000);
			obj_EsupportIntegratedHomePageWorkflow.countryExecution_SIT(driver);
			

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_6126097_AMER_ED_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport--------->\n  "+e);

		}

	}
}