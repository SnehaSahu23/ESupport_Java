package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9070088_AMER_CH_SecurityLandingPage_SearchabilityEnhancement_EMCRSAarticlesAndDellArticles extends BaseTest
{
	@Test
	public void validate_TC_9070088_AMER_CH_SecurityLandingPage_SearchabilityEnhancement_EMCRSAarticlesAndDellArticles() 
	{
		try
		{
			System.out.println("Starts TC_9070088_AMER_CH_SecurityLandingPage_SearchabilityEnhancement_EMCRSAarticlesAndDellArticles");
			obj_EsupportSecurityLandingPageWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			obj_EsupportSecurityLandingPageWorkflow.searchCVEIdentifierAndVerifyURL(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			obj_EsupportSecurityLandingPageWorkflow.searchCVEIdentifierAndVerifyURL(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportSecurityLandingPageWorkflow.searchCVEIdentifierAndVerifyURL(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			obj_EsupportSecurityLandingPageWorkflow.searchCVEIdentifierAndVerifyURL(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9070088_AMER_CH_SecurityLandingPage_SearchabilityEnhancement_EMCRSAarticlesAndDellArticles--------->\n  "+e);
		}
	}
}
