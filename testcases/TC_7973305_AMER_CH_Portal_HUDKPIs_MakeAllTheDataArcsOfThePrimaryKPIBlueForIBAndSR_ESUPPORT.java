package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7973305_AMER_CH_Portal_HUDKPIs_MakeAllTheDataArcsOfThePrimaryKPIBlueForIBAndSR_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7973305_AMER_CH_Portal_HUDKPIs_MakeAllTheDataArcsOfThePrimaryKPIBlueForIBAndSR_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7973305_AMER_CH_Portal_HUDKPIs_MakeAllTheDataArcsOfThePrimaryKPIBlueForIBAndSR_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportPortalWorkflow.ClickOnInstallBaseTab(driver);	
			
			obj_EsupportPortalWorkflow.ValidateTotalAssetsCircleInHUD(driver);	
			
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);	
			
			obj_EsupportPortalWorkflow.ValidateTotalSRsCircleInHUD(driver);	
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7973305_AMER_CH_Portal_HUDKPIs_MakeAllTheDataArcsOfThePrimaryKPIBlueForIBAndSR_ESUPPORT--------->\n  "+e);
		}
	}
}
