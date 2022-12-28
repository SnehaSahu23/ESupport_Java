package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8090990_AMER_CH_IntegrationHomepageContactUsSliderUnauthenticated extends BaseTest
{
	@Test
	public void validate_TC_8090990_AMER_CH_IntegrationHomepageContactUsSliderUnauthenticated() 
	{
		try
		{
			System.out.println("Starts TC_8090990_AMER_CH_IntegrationHomepageContactUsSliderUnauthenticated");
			
			obj_EsupportIPSWorkflow.handleCookies(driver);
			Thread.sleep(3000);
			obj_EsupportIPSWorkflow.verifyContactUsSliderLandingPage(driver);
			obj_EsupportIPSWorkflow.verifyContactUsSliderOpen(driver);			
			obj_EsupportIPSWorkflow.verifyContactUsSliderContent(driver);
			obj_EsupportIPSWorkflow.clickTechnicalSupportLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOrderSupportContactUsSlider(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8090990_AMER_CH_IntegrationHomepageContactUsSliderUnauthenticated--------->\n  "+e);
		}
	}
}
