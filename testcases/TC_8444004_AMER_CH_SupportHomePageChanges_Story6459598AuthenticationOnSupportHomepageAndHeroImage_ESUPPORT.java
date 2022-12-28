package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8444004_AMER_CH_SupportHomePageChanges_Story6459598AuthenticationOnSupportHomepageAndHeroImage_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_8444004_AMER_CH_SupportHomePageChanges_Story6459598AuthenticationOnSupportHomepageAndHeroImage_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8444004_AMER_CH_SupportHomePageChanges_Story6459598AuthenticationOnSupportHomepageAndHeroImage_ESUPPORT");
				
			obj_EsupportIPSWorkflow.SupportPage(driver);
			obj_EsupportIPSWorkflow.ClickSignInButton(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			obj_EsupportIPSWorkflow.ClickSignInButton(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.SupportPageValidationAfterSignIn(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8444004_AMER_CH_SupportHomePageChanges_Story6459598AuthenticationOnSupportHomepageAndHeroImage_ESUPPORT--------->\n  "+e);
		}
	}
}
