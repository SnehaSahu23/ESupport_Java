package com.dell.delta_uat_automation.esupport.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;
public class TC_6126097_AMER_CH_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6126097_AMER_CH_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport() 
	{

		try
		{
			Thread.sleep(10000);
			System.out.println("Starts TC_6126097_AMER_CH_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport");
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

			Assert.fail("Failed while executing test case TC_6126097_AMER_CH_Verify_Global_Countrywidebanner_onthesupporthomepage_Esupport--------->\n  "+e);

		}

	}
}
