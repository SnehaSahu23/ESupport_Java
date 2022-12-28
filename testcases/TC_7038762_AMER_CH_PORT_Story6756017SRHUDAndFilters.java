package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7038762_AMER_CH_PORT_Story6756017SRHUDAndFilters  extends BaseTest
{
	@Test
	public void validate_TC_7038762_AMER_CH_PORT_Story6756017SRHUDAndFilters() 
	{
		try
		{
			System.out.println("Starts TC_7038762_AMER_CH_PORT_Story6756017SRHUDAndFilters");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportPortalWorkflow.ClickOnIncidentManagementTab(driver);
			
			obj_EsupportPortalWorkflow.ValidateOpenSRsCircleInHUD(driver);	
//			obj_EsupportPortalWorkflow.verifyIncidentManagementSRStatusOpen(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementFiltersDisplayDefault(driver);
			obj_EsupportPortalWorkflow.ClickOnClearAllAtBreadScrumb(driver);
			obj_EsupportPortalWorkflow.ValidateTotalSRsCircleInHUD(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7038762_AMER_CH_PORT_Story6756017SRHUDAndFilters--------->\n  "+e);
		}
	}
}

