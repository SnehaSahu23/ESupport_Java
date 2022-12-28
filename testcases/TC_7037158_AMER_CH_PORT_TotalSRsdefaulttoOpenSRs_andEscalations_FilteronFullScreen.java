package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7037158_AMER_CH_PORT_TotalSRsdefaulttoOpenSRs_andEscalations_FilteronFullScreen extends BaseTest
{
	@Test
	public void validate_TC_7037158_AMER_CH_PORT_TotalSRsdefaulttoOpenSRs_andEscalations_FilteronFullScreen() 
	{
		try
		{
			System.out.println("Starts TC_7037158_AMER_CH_PORT_TotalSRsdefaulttoOpenSRs_andEscalations_FilteronFullScreen");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementDefaultSelectedFilter(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementExpandButton(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementExpandViewColumns(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementSRSpecificFilters(driver);
			obj_EsupportPortalWorkflow.closeIncidentManagementExpandedViewFilterAndTable(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementEscalationsButton(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementExpandButton(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementExpandViewColumns(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementSRSpecificFilters(driver);
			obj_EsupportPortalWorkflow.applyIncidentManagementExpandedViewFilter(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7037158_AMER_CH_PORT_TotalSRsdefaulttoOpenSRs_andEscalations_FilteronFullScreen--------->\n  "+e);
		}
	}
}
