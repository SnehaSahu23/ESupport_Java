package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7222881_AMER_CH_Portal_HealthAndRisk_ReportingViewUnderAddProductsAffectedInSecurityAdvisory_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7222881_AMER_CH_Portal_HealthAndRisk_ReportingViewUnderAddProductsAffectedInSecurityAdvisory_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7222881_AMER_CH_Portal_HealthAndRisk_ReportingViewUnderAddProductsAffectedInSecurityAdvisory_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);	
			
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryTab(driver);
			
			
			obj_EsupportPortalWorkflow.ValidateDefaultFilterInSummaryPageWhenUserSelectedSecurityAdvisoriesFromLeftMenu(driver);
			obj_EsupportPortalWorkflow.ValidateDefaultFilterInSummaryPageWhenUserSelectedTechnicalAdvisoriesFromLeftMenu(driver);
			
			obj_EsupportPortalWorkflow.ClickOnFilterAndValidateIBStatusDefaultSelectedOptionsDisplayedInInstallBasePage(driver);
			obj_EsupportPortalWorkflow.ClickOnFilterAndValidateIBStatusDefaultNotSelectedOptionsDisplayedInInstallBasePage(driver);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7222881_AMER_CH_Portal_HealthAndRisk_ReportingViewUnderAddProductsAffectedInSecurityAdvisory_ESUPPORT--------->\n  "+e);
		}
	}
}
