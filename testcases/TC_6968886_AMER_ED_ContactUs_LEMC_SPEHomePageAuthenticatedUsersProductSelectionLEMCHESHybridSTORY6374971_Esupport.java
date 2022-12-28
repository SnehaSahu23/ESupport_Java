package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6968886_AMER_ED_ContactUs_LEMC_SPEHomePageAuthenticatedUsersProductSelectionLEMCHESHybridSTORY6374971_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6968886_AMER_ED_ContactUs_LEMC_SPEHomePageAuthenticatedUsersProductSelectionLEMCHESHybridSTORY6374971_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_6968886_AMER_ED_ContactUs_LEMC_SPEHomePageAuthenticatedUsersProductSelectionLEMCHESHybridSTORY6374971_Esupport");
			obj_EsupportIncidentsWorkflow.handleCookies(driver);
			
			obj_EsupportIncidentsWorkflow.ValidationContactChannelsAreGreyedOut(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			
			//searching product ID
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/Dynamic");
			//Clicking on browse all assets
			obj_EsupportIncidentsWorkflow.clickBrowseMyAssetsButton_AfterSignOn(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6968886_AMER_ED_ContactUs_LEMC_SPEHomePageAuthenticatedUsersProductSelectionLEMCHESHybridSTORY6374971_Esupport--------->\n  "+e);
		}
	}
}
