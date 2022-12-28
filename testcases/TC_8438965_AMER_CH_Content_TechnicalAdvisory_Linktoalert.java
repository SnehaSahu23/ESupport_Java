package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8438965_AMER_CH_Content_TechnicalAdvisory_Linktoalert extends BaseTest
{
	@Test
	public void validate_TC_8438965_AMER_CH_Content_TechnicalAdvisory_Linktoalert() 
	{
		try
		{
			System.out.println("Starts TC_8438965_AMER_CH_Content_TechnicalAdvisory_Linktoalert");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.verifyArticleAlertLink(driver);
			obj_EsupportContentWorkflow.clickArticleAlertLink(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8438965_AMER_CH_Content_TechnicalAdvisory_Linktoalert--------->\n  "+e);
		}
	}
}
