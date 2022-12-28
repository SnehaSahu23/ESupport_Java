package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7386264_AMER_CH_PORTAL_DefaultViewofLandingPage extends BaseTest
{
	@Test
	public void validate_TC_7386264_AMER_CH_PORTAL_DefaultViewofLandingPage() 
	{
		try
		{
			System.out.println("Starts TC_7386264_AMER_CH_PORTAL_DefaultViewofLandingPage");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.verifyFirstSectionAccountName(driver);
			obj_EsupportPortalWorkflow.verifyHealthScoreRisk(driver);
			obj_EsupportPortalWorkflow.verifyPortalTabs(driver);
			obj_EsupportPortalWorkflow.verifySummaryTabKPIs(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7386264_AMER_CH_PORTAL_DefaultViewofLandingPage--------->\n  "+e);
		}
	}
}
