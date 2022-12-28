package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7038744_AMER_CH_PORT_SRHUD_DefaultView_UpdatedbasedonCompsfromJune1st extends BaseTest
{
	@Test
	public void validate_TC_7038744_AMER_CH_PORT_SRHUD_DefaultView_UpdatedbasedonCompsfromJune1st() 
	{
		try
		{
			System.out.println("Starts TC_7038744_AMER_CH_PORT_SRHUD_DefaultView_UpdatedbasedonCompsfromJune1st");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementSummaryViewHUD(driver);
			obj_EsupportPortalWorkflow.verifyIncidentManagementIndividualKPIHUD(driver);
			obj_EsupportPortalWorkflow.hoverOverIncidentManagementEscalationsHUD(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementOnsiteServicesHud(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7038744_AMER_CH_PORT_SRHUD_DefaultView_UpdatedbasedonCompsfromJune1st--------->\n  "+e);
		}
	}
}

