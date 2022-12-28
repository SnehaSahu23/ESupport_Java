package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7038745_AMER_CH_PORT_SRHUDInteractionswiththeGrid extends BaseTest
{
	@Test
	public void validate_TC_7038745_AMER_CH_PORT_SRHUDInteractionswiththeGrid() 
	{
		try
		{
			System.out.println("Starts TC_7038745_AMER_CH_PORT_SRHUDInteractionswiththeGrid");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementTotalSrHud(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementOnsiteServicesHud(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementEscalationsHud(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementPartsReplacedHud(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7038745_AMER_CH_PORT_SRHUDInteractionswiththeGrid--------->\n  "+e);
		}
	}
}

