package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_9072759_AMER_FF_SecurityLandingPage_Sorting extends BaseTest
{
	@Test
	public void validate_TC_9072759_AMER_FF_SecurityLandingPage_Sorting() 
	{
		try
		{
			System.out.println("Starts TC_9072759_AMER_FF_SecurityLandingPage_Sorting");
			obj_EsupportSecurityLandingPageWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			obj_EsupportSecurityLandingPageWorkflow.verifySeverityColumnSortingAscending(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifySeverityColumnSortingDescending(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyTypeColumnSorting(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyPublishedColumnSorting(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyUpdatedColumnSorting(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyTitleColumnSorting(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyCVEColumnSorting(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyFiltersList(driver);
			Thread.sleep(3000);
			obj_EsupportSecurityLandingPageWorkflow.removeCriticalFilterAndVerifyDetails(driver);
			Thread.sleep(3000);
			obj_EsupportSecurityLandingPageWorkflow.selectSecurityNoticesAndVerifyDetails(driver);
			Thread.sleep(3000);
			obj_EsupportSecurityLandingPageWorkflow.selectInformationalAndVerifyDetails(driver);
			Thread.sleep(10000);
			obj_EsupportSecurityLandingPageWorkflow.selectOnlyCriticalFilterAndVerifyDetails(driver);
			Thread.sleep(3000);
			obj_EsupportSecurityLandingPageWorkflow.selectOnlyHighFilterAndVerifyDetails(driver);
			Thread.sleep(3000);
			obj_EsupportSecurityLandingPageWorkflow.selectOnlyMediumFilterAndVerifyDetails(driver);
			Thread.sleep(3000);
			obj_EsupportSecurityLandingPageWorkflow.selectOnlyLowFilterAndVerifyDetails(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9072759_AMER_FF_SecurityLandingPage_Sorting--------->\n  "+e);
		}
	}
}
