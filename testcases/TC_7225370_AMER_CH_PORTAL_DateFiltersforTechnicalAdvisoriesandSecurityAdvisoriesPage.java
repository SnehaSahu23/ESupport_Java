package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7225370_AMER_CH_PORTAL_DateFiltersforTechnicalAdvisoriesandSecurityAdvisoriesPage extends BaseTest
{
	@Test
	public void validate_TC_7225370_AMER_CH_PORTAL_DateFiltersforTechnicalAdvisoriesandSecurityAdvisoriesPage() 
	{
		try
		{
			System.out.println("Starts TC_7225370_AMER_CH_PORTAL_DateFiltersforTechnicalAdvisoriesandSecurityAdvisoriesPage");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);	
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryTab(driver);
			obj_EsupportPortalWorkflow.verifyDateRangeFormat(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryDateFilterAndFilterDate(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryDateFilterInvalidDates(driver);
			obj_EsupportPortalWorkflow.verifyDateFormatFromDatePicker(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryDateFilterAndApplySelectedFromDate(driver);
			Thread.sleep(5000);
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryTab(driver);
			obj_EsupportPortalWorkflow.verifyDateRangeFormat(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryDateFilterAndFilterDate(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryDateFilterInvalidDates(driver);
			obj_EsupportPortalWorkflow.verifyDateFormatFromDatePicker(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryDateFilterAndApplySelectedFromDate(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7225370_AMER_CH_PORTAL_DateFiltersforTechnicalAdvisoriesandSecurityAdvisoriesPage--------->\n  "+e);
		}
	}
}
