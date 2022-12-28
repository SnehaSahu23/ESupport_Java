package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6978874_AMER_IE_ContactUs_LEMC_SPEBrowseAllProductandBrowsemyassetsbuttonsLEMC_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_6978874_AMER_IE_ContactUs_LEMC_SPEBrowseAllProductandBrowsemyassetsbuttonsLEMC_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6978874_AMER_IE_ContactUs_LEMC_SPEBrowseAllProductandBrowsemyassetsbuttonsLEMC_Esupport");
			obj_EsupportIPSWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.validateCtsHomePage(driver);	
			obj_EsupportIncidentsWorkflow.clickBrowseMyAssetsButton(driver);		
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));		
			obj_EsupportIncidentsWorkflow.verifyBrowseAllProductsDisabledForEMCUSerAthentication(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while executing TC_6978874_AMER_IE_ContactUs_LEMC_SPEBrowseAllProductandBrowsemyassetsbuttonsLEMC_Esupport--------->\n  "+e);
		}

	}
}

