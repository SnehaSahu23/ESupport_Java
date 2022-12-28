package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_9072848_AMER_IE_SecurityLandingPage_InfoDetails extends BaseTest
{
	@Test
	public void validate_TC_9072848_AMER_IE_SecurityLandingPage_InfoDetails() 
	{
		try
		{
			System.out.println("Starts TC_9072848_AMER_IE_SecurityLandingPage_InfoDetails");
			obj_EsupportSecurityLandingPageWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			
			obj_EsupportSecurityLandingPageWorkflow.verifySecurityAdvisoriesTooltip(driver);
			Thread.sleep(5000);
			obj_EsupportSecurityLandingPageWorkflow.verifySecurityNoticesTooltip(driver);
			Thread.sleep(5000);
			obj_EsupportSecurityLandingPageWorkflow.verifyInformationalTooltip(driver);
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9072848_AMER_IE_SecurityLandingPage_InfoDetails--------->\n  "+e);
		}
	}
}
