package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6041220_AMER_ED_ContactusIntegrationDisplayopenSRhistoryincontactchannelspageforEMCInstanceIDflow_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_6041220_AMER_ED_ContactusIntegrationDisplayopenSRhistoryincontactchannelspageforEMCInstanceIDflow_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6041220_AMER_ED_ContactusIntegrationDisplayopenSRhistoryincontactchannelspageforEMCInstanceIDflow_Esupport");
			obj_EsupportIncidentsWorkflow.navigateToSignInPage(driver);		
			
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIncidentsWorkflow.verifyEMCInstanceId(driver);			

		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while TC_6041220_AMER_ED_ContactusIntegrationDisplayopenSRhistoryincontactchannelspageforEMCInstanceIDflow_Esupport--------->\n  "+e);
		}

	}
}

