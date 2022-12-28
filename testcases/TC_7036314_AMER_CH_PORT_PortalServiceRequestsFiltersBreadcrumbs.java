package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7036314_AMER_CH_PORT_PortalServiceRequestsFiltersBreadcrumbs extends BaseTest
{
	@Test
	public void validate_TC_7036314_AMER_CH_PORT_PortalServiceRequestsFiltersBreadcrumbs() 
	{
		try
		{
			System.out.println("Starts TC_7036314_AMER_CH_PORT_PortalServiceRequestsFiltersBreadcrumbs");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.applyIncidentManagementSummaryViewFilter(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementClearAllButton(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementEscalationsButton(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementClearAllButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7036314_AMER_CH_PORT_PortalServiceRequestsFiltersBreadcrumbs--------->\n  "+e);
		}
	}
}
