package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9072848_AMER_FF_SecurityLandingPage_InfoDetails extends BaseTest
{
	@Test
	public void validate_TC_9072848_AMER_FF_SecurityLandingPage_InfoDetails() 
	{
		try
		{
			System.out.println("Starts TC_9072848_AMER_FF_SecurityLandingPage_InfoDetails");
			obj_EsupportSecurityLandingPageWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			Thread.sleep(5000);
			
			obj_EsupportSecurityLandingPageWorkflow.verifySecurityAdvisoriesTooltip(driver);
			Thread.sleep(3000);
			obj_EsupportSecurityLandingPageWorkflow.verifySecurityNoticesTooltip(driver);
			Thread.sleep(3000);
			obj_EsupportSecurityLandingPageWorkflow.verifyInformationalTooltip(driver);
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9072848_AMER_FF_SecurityLandingPage_InfoDetails--------->\n  "+e);
		}
	}
}
