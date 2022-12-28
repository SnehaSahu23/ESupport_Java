package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7036687_AMER_CH_PORT_ServiceRequestsEscalationsspecificfilters extends BaseTest
{
	@Test
	public void validate_TC_7036687_AMER_CH_PORT_ServiceRequestsEscalationsspecificfilters() 
	{
		try
		{
			System.out.println("Starts TC_7036687_AMER_CH_PORT_ServiceRequestsEscalationsspecificfilters");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportPortalWorkflow.clickChangeViewLink(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementEscalationsButton(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.applyIncidentManagementSummaryViewFilter(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementClearAllButton(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementSummaryViewFilterEscalationsOption(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementExpandButton(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementExpandViewFilterEscalationsOption(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7036687_AMER_CH_PORT_ServiceRequestsEscalationsspecificfilters--------->\n  "+e);
		}
	}
}

