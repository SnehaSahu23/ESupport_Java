package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7227047_AMER_CH_PORTAL_TechnicalAdvisoryHUDView extends BaseTest
{
	@Test
	public void validate_TC_7227047_AMER_CH_PORTAL_TechnicalAdvisoryHUDView() 
	{
		try
		{
			System.out.println("Starts TC_7227047_AMER_CH_PORTAL_TechnicalAdvisoryHUDView");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);		
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryTab(driver);	
			obj_EsupportPortalWorkflow.verifyAdvisoryStatusColumnPendingAndHUD(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskSecurityAdvisoryHUDOrder(driver);
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryTab(driver);	
			obj_EsupportPortalWorkflow.verifyTechnicalAdvisoryHUDArcValues(driver);	
			obj_EsupportPortalWorkflow.verifyTechnicalAdvisoryHUDDefaultData(driver);
			obj_EsupportPortalWorkflow.hoverOverTechnicalAdvisoryHUDMediumArc(driver);
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryHUDAndVerifyStatusColumn(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7227047_AMER_CH_PORTAL_TechnicalAdvisoryHUDView--------->\n  "+e);
		}
	}
}
