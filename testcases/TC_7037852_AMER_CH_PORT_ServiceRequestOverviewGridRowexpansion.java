package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7037852_AMER_CH_PORT_ServiceRequestOverviewGridRowexpansion extends BaseTest
{
	@Test
	public void validate_TC_7037852_AMER_CH_PORT_ServiceRequestOverviewGridRowexpansion() 
	{
		try
		{
			System.out.println("Starts TC_7037852_AMER_CH_PORT_ServiceRequestOverviewGridRowexpansion");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(30000);
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementTotalSrsButton(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSiteIdColumnDropdownArrow(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementSiteIdColumnDataPoints(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7037852_AMER_CH_PORT_ServiceRequestOverviewGridRowexpansion--------->\n  "+e);
		}
	}
}