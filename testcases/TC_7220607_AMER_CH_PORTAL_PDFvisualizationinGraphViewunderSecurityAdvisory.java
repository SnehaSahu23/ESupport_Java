package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7220607_AMER_CH_PORTAL_PDFvisualizationinGraphViewunderSecurityAdvisory extends BaseTest
{
	@Test
	public void validate_TC_7220607_AMER_CH_PORTAL_PDFvisualizationinGraphViewunderSecurityAdvisory() 
	{
		try
		{
			System.out.println("Starts TC_7220607_AMER_CH_PORTAL_PDFvisualizationinGraphViewunderSecurityAdvisory");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);			
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryTab(driver);	
			obj_EsupportPortalWorkflow.clickHealthRiskGraphView(driver);	
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);	
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskFilterBreadcrumb(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7220607_AMER_CH_PORTAL_PDFvisualizationinGraphViewunderSecurityAdvisory--------->\n  "+e);
		}
	}
}