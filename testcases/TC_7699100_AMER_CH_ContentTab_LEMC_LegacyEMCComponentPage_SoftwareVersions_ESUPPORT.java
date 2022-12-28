package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7699100_AMER_CH_ContentTab_LEMC_LegacyEMCComponentPage_SoftwareVersions_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7699100_AMER_CH_ContentTab_LEMC_LegacyEMCComponentPage_SoftwareVersions_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7699100_AMER_CH_ContentTab_LEMC_LegacyEMCComponentPage_SoftwareVersions_ESUPPORT()");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ClickSearchServiceTagForLEMCUser(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			
			obj_EsupportContentWorkflow.VerifySoftwareVersionAvailablility(driver);
			
			obj_EsupportContentWorkflow.SelectSoftwareVersionFromDropDown(driver);
			obj_EsupportContentWorkflow.ValidateDetailsDisplayedOnSearchResultPage(driver);
						
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7699100_AMER_CH_ContentTab_LEMC_LegacyEMCComponentPage_SoftwareVersions_ESUPPORT()--------->\n  "+e);
		}
	}
}
