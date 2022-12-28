package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9086562_AMER_FF_SecurityLandingPage_CustomerSupport_ContactSlider extends BaseTest
{
	@Test
	public void validate_TC_9086562_AMER_FF_SecurityLandingPage_CustomerSupport_ContactSlider() 
	{
		try
		{
			System.out.println("Starts TC_9086562_AMER_FF_SecurityLandingPage_CustomerSupport_ContactSlider");
			obj_EsupportSecurityLandingPageWorkflow.handleCookies(driver);
			
			obj_EsupportSecurityLandingPageWorkflow.verifyContactUsSliderContent(driver);
			obj_EsupportIPSWorkflow.clickTechnicalSupportLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOrderSupportContactUsSlider(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			
			Thread.sleep(5000);
			obj_EsupportSecurityLandingPageWorkflow.verifyContactUsSliderOnSignIn(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickChatWithSupportOptionContactSlider(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportSecurityLandingPageWorkflow.verifyContactUsSliderOnSignIn(driver);
			obj_EsupportIPSWorkflow.clickTechnicalSupportLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOrderSupportContactUsSlider(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9086562_AMER_FF_SecurityLandingPage_CustomerSupport_ContactSlider--------->\n  "+e);
		}
	}
}
