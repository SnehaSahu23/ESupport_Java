package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9018106_AMER_CH_SecurityLandingPage_Openlink_in_newtab extends BaseTest
{
	@Test
	public void validate_TC_9018106_AMER_CH_SecurityLandingPage_Openlink_in_newtab() 
	{
		try
		{
			System.out.println("Starts TC_9018106_AMER_CH_SecurityLandingPage_Openlink_in_newtab");
			obj_EsupportSecurityLandingPageWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			obj_EsupportSecurityLandingPageWorkflow.clickAdvisoryTitleLink(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickVulnerabilityPolicyLink(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickAdditionalSecurityLink(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickCriticalFilterAndVerifyDetails(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickAdvisoryTitleLink(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickVulnerabilityPolicyLink(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickAdditionalSecurityLink(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickCriticalFilterAndVerifyDetails(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9018106_AMER_CH_SecurityLandingPage_Openlink_in_newtab--------->\n  "+e);
		}
	}
}
