package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_9070141_AMER_ED_SecurityLandingPage_Pagination extends BaseTest
{
	@Test
	public void validate_TC_9070141_AMER_ED_SecurityLandingPage_Pagination() 
	{
		try
		{
			System.out.println("Starts TC_9070141_AMER_ED_SecurityLandingPage_Pagination");
			obj_EsupportSecurityLandingPageWorkflow.handleCookies(driver);
			
			obj_EsupportSecurityLandingPageWorkflow.verifyDisplayingText(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyPageDropdown(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyrightPointingArrows(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyNextPageAndLastPage(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyArrowsActivated(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyPageNavigation(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyLeftPointingArrows(driver);
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9070141_AMER_ED_SecurityLandingPage_Pagination--------->\n  "+e);
		}
	}
}
