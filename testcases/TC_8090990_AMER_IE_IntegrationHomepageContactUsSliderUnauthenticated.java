package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_8090990_AMER_IE_IntegrationHomepageContactUsSliderUnauthenticated extends BaseTest
{
	@Test
	public void validate_TC_8090990_AMER_IE_IntegrationHomepageContactUsSliderUnauthenticated() 
	{
		try
		{
			System.out.println("Starts TC_8090990_AMER_IE_IntegrationHomepageContactUsSliderUnauthenticated");
			
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
			Assert.fail("Failed in TC_8090990_AMER_IE_IntegrationHomepageContactUsSliderUnauthenticated--------->\n  "+e);
		}
	}
}
