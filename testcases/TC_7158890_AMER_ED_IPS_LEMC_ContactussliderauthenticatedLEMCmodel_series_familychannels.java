package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7158890_AMER_ED_IPS_LEMC_ContactussliderauthenticatedLEMCmodel_series_familychannels extends BaseTest
{
	@Test
	public void validate_TC_7158890_AMER_ED_IPS_LEMC_ContactussliderauthenticatedLEMCmodel_series_familychannels() 
	{
		try
		{
			System.out.println("Starts TC_7158890_AMER_ED_IPS_LEMC_ContactussliderauthenticatedLEMCmodel_series_familychannels");
				
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
			//obj_EsupportIPSWorkflow.selectVmaxProduct(driver);
			obj_EsupportIPSWorkflow.selectVmaxProductFromBrowseAll(driver);
			
			obj_EsupportIPSWorkflow.verifyContactUsSliderLandingPage(driver);
			obj_EsupportIPSWorkflow.verifyContactUsSliderOpen(driver);
			obj_EsupportIPSWorkflow.verifyContactUsSliderContent(driver);
			obj_EsupportIPSWorkflow.clickTechnicalSupportLink(driver);
			//obj_EsupportIPSWorkflow.verifyNotificationOptions(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7158890_AMER_ED_IPS_LEMC_ContactussliderauthenticatedLEMCmodel_series_familychannels--------->\n  "+e);
		}
	}
}


