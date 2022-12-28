package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7228792_AMER_CH_PORTAL_AdvisoryGridView extends BaseTest
{
	@Test
	public void validate_TC_7228792_AMER_CH_PORTAL_AdvisoryGridView() 
	{
		try
		{
			System.out.println("Starts TC_7228792_AMER_CH_PORTAL_AdvisoryGridView");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);			
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryTab(driver);			
			obj_EsupportPortalWorkflow.verifySecurityAndTechnicalAdvisoryGrid(driver);
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryTab(driver);
			obj_EsupportPortalWorkflow.verifySeverityColumn(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryColumn(driver);
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryTab(driver);
			obj_EsupportPortalWorkflow.verifySeverityColumn(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryColumn(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7228792_AMER_CH_PORTAL_AdvisoryGridView--------->\n  "+e);
		}
	}
}

