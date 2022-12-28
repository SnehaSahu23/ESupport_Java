package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8900834_AMER_FF_Content_Signin_ribbonbar extends BaseTest {


	@Test
	public void validate_TC_8900834_AMER_FF_Content_Signin_ribbonbar() 
	{
		try
		{
			System.out.println("Starts TC_8900834_AMER_FF_Content_Signin_ribbonbar");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.verifySignInRibbonBar(driver);
			obj_EsupportContentWorkflow.clickSignInLinkRibbonBar(driver);
			driver.navigate().back();
			Thread.sleep(5000);
			obj_EsupportContentWorkflow.clickXButtonRibbonBar(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8900834_AMER_FF_Content_Signin_ribbonbar--------->\n  "+e);
		}
	}
}

