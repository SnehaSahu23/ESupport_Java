package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7123075_AMER_ED_Contact_SPECountryRedirectionPopup_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7123075_AMER_ED_Contact_SPECountryRedirectionPopup_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7123075_AMER_ED_Contact_SPECountryRedirectionPopup_ESUPPORT");
			//driver.get("https://www.dell.com/support/incidents-online/us/en/04/ContactUs/");
			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.HandleCountryRedirectionPopup(driver, TestNGCreator.TestData.get(Esupport.Country.ordinal()));
			

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7123075_AMER_ED_Contact_SPECountryRedirectionPopup_ESUPPORT--------->\n  "+e);

		}

	}
}
