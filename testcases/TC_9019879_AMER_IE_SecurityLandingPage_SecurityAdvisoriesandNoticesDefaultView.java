package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_9019879_AMER_IE_SecurityLandingPage_SecurityAdvisoriesandNoticesDefaultView extends BaseTest
{
	@Test
	public void validate_TC_9019879_AMER_IE_SecurityLandingPage_SecurityAdvisoriesandNoticesDefaultView() 
	{
		try
		{
			System.out.println("Starts TC_9019879_AMER_IE_SecurityLandingPage_SecurityAdvisoriesandNoticesDefaultView");
			obj_EsupportSecurityLandingPageWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			
			obj_EsupportSecurityLandingPageWorkflow.verifySecurityAndAdvisoryHeader(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifySecurityAndAdvisoryMessage(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifySearchTextbox(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyDefaultFilters(driver);
			obj_EsupportSecurityLandingPageWorkflow.validateDatePickerDefaultText(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyExportButtonAndColumnsAndDisplayingText(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyDetailsAfterSignout(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickSignInLinkAndVerifyHeader(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9019879_AMER_IE_SecurityLandingPage_SecurityAdvisoriesandNoticesDefaultView--------->\n  "+e);
		}
	}
}