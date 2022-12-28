package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5786155_AMER_ED_FAQScenariosFAQVerifyFAQpage_Esupport extends BaseTest
{	
	@Test
	public void validate_TC_5786155_AMER_ED_FAQScenariosFAQVerifyFAQpage_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_5786155_AMER_ED_FAQScenariosFAQVerifyFAQpage_Esupport");


			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.clickHelpTab(driver);

			obj_EsupportDDLWorkflow.verifyShowAllLink(driver);

			obj_EsupportDDLWorkflow.clickShowAllLink(driver);

			obj_EsupportDDLWorkflow.verifyAndClickHideAllLink(driver);

			obj_EsupportDDLWorkflow.verifyHeadingsFaqsPage(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5786155_AMER_ED_FAQScenariosFAQVerifyFAQpage_Esupport--------->\n  "+e);
		}
	}
}
