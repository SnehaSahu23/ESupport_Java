package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7925167_AMER_CH_PORTAL_WhenProductNameisblanklabelasProductNameUnavailable extends BaseTest
{
	@Test
	public void validate_TC_7925167_AMER_CH_PORTAL_WhenProductNameisblanklabelasProductNameUnavailable() 
	{
		try
		{
			System.out.println("Starts TC_7925167_AMER_CH_PORTAL_WhenProductNameisblanklabelasProductNameUnavailable");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.clickInstallBaseTab(driver);
			obj_EsupportPortalWorkflow.clickProductNameFilterWithOptionNone(driver);
			obj_EsupportPortalWorkflow.verifyProductNameColumnWithValProductNameUnavailable(driver);
			obj_EsupportPortalWorkflow.clickExpandArrowAndVerifyProductNameUnavailable(driver);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);
			obj_EsupportPortalWorkflow.clickProductNameFilterWithOptionNone(driver);
			Thread.sleep(5000);
			obj_EsupportPortalWorkflow.verifyProductNameColumnWithValProductNameUnavailable(driver);
			obj_EsupportPortalWorkflow.clickExpandArrowAndVerifyProductNameUnavailable(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.clickProductNameFilterWithOptionNone(driver);
			obj_EsupportPortalWorkflow.clickExpandArrowAndVerifyProductNameUnavailable(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7925167_AMER_CH_PORTAL_WhenProductNameisblanklabelasProductNameUnavailable--------->\n  "+e);
		}
	}
}

