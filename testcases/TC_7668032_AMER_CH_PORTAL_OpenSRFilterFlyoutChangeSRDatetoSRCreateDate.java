package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7668032_AMER_CH_PORTAL_OpenSRFilterFlyoutChangeSRDatetoSRCreateDate extends BaseTest
{
	@Test
	public void validate_TC_7668032_AMER_CH_PORTAL_OpenSRFilterFlyoutChangeSRDatetoSRCreateDate() 
	{
		try
		{
			System.out.println("Starts TC_7668032_AMER_CH_PORTAL_OpenSRFilterFlyoutChangeSRDatetoSRCreateDate");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementTotalSrsButton(driver);
			
			obj_EsupportPortalWorkflow.verifySRCreateDateFilter(driver);
			
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementExpandButton(driver);
			obj_EsupportPortalWorkflow.verifySRCreateDateFilter(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7668032_AMER_CH_PORTAL_OpenSRFilterFlyoutChangeSRDatetoSRCreateDate--------->\n  "+e);
		}
	}
}

