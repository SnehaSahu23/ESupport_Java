package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7229455_AMER_CH_PORTAL_AdvisoryFilters_Addsearchbar extends BaseTest
{
	@Test
	public void validate_TC_7229455_AMER_CH_PORTAL_AdvisoryFilters_Addsearchbar() 
	{
		try
		{
			System.out.println("Starts TC_7229455_AMER_CH_PORTAL_AdvisoryFilters_Addsearchbar");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);		
			obj_EsupportPortalWorkflow.verifyHealthAndRiskSearchTextbox(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskSearchTextboxDefaultText(driver);
			
			obj_EsupportPortalWorkflow.clickIncidentManagementExpandButton(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskSearchTextbox(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskSearchTextboxDefaultText(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7229455_AMER_CH_PORTAL_AdvisoryFilters_Addsearchbar--------->\n  "+e);
		}
	}
}
