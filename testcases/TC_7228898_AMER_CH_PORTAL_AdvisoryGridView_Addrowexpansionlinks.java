package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7228898_AMER_CH_PORTAL_AdvisoryGridView_Addrowexpansionlinks extends BaseTest
{
	@Test
	public void validate_TC_7228898_AMER_CH_PORTAL_AdvisoryGridView_Addrowexpansionlinks() 
	{
		try
		{
			System.out.println("Starts TC_7228898_AMER_CH_PORTAL_AdvisoryGridView_Addrowexpansionlinks");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);			
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryTab(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryDownArrowFirstRow(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7228898_AMER_CH_PORTAL_AdvisoryGridView_Addrowexpansionlinks--------->\n  "+e);
		}
	}
}