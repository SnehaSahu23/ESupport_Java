package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7219986_AMER_CH_PORTAL_PaginationviewforTechnicalAdvisoriesContextview extends BaseTest
{
	@Test
	public void validate_TC_7219986_AMER_CH_PORTAL_PaginationviewforTechnicalAdvisoriesContextview() 
	{
		try
		{
			System.out.println("Starts TC_7219986_AMER_CH_PORTAL_PaginationviewforTechnicalAdvisoriesContextview");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);			
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryTab(driver);			
			obj_EsupportPortalWorkflow.verifyHealthAndRiskPaginationOptions(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskPaginationOptionLeft(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskPaginationOptionRight(driver);
			obj_EsupportPortalWorkflow.enterHealthAndRiskPageNumberWithinRange(driver);
			obj_EsupportPortalWorkflow.enterHealthAndRiskPageNumberOutsideRange(driver);
			obj_EsupportPortalWorkflow.enterHealthAndRiskPageNumberCharacter(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskFirstPageButtonDisabled(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskPreviousPageButtonDisabled(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskNextPageButtonDisabled(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskLastPageButtonDisabled(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskNextPageNavigation(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskLastPageNavigation(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskPreviousPageNavigation(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskFirstPageNavigation(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskPageSelectorOptionsRight(driver);
			obj_EsupportPortalWorkflow.selectHealthAndRiskPageSelectorDropdown(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7219986_AMER_CH_PORTAL_PaginationviewforTechnicalAdvisoriesContextview--------->\n  "+e);
		}
	}
}