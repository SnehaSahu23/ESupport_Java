package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7229457_AMER_CH_PORTAL_ExpandGridAddsearchbar extends BaseTest
{
	@Test
	public void validate_TC_7229457_AMER_CH_PORTAL_ExpandGridAddsearchbar() 
	{
		try
		{
			System.out.println("Starts TC_7229457_AMER_CH_PORTAL_ExpandGridAddsearchbar");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);		
			obj_EsupportPortalWorkflow.verifyHealthAndRiskSearchTextbox(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskSearchTextboxDefaultText(driver);
			
			obj_EsupportPortalWorkflow.verifyHealthAndRiskSearchTextboxAfterEnteringText(driver);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskSearchTextboxInvalidData(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskSearchTextboxValidData(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7229457_AMER_CH_PORTAL_ExpandGridAddsearchbar--------->\n  "+e);
		}
	}
}
