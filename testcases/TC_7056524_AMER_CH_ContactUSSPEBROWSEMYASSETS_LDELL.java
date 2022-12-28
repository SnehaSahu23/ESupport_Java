package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7056524_AMER_CH_ContactUSSPEBROWSEMYASSETS_LDELL extends BaseTest 
{
	@Test
	public void validate_TC_7056524_AMER_CH_ContactUSSPEBROWSEMYASSETS_LDELL() 
	{
		try
		{
			System.out.println("Starts TC_7056524_AMER_CH_ContactUSSPEBROWSEMYASSETS_LDELL");
			
			obj_EsupportIncidentsWorkflow.validateCtsHomePage(driver);	
			obj_EsupportIncidentsWorkflow.clickBrowseMyAssetsButton(driver);		
			obj_EsupportIncidentsWorkflow.enterSignInDetails(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));		
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while executing TC_7056524_AMER_CH_ContactUSSPEBROWSEMYASSETS_LDELL--------->\n  "+e);
		}

	}
}


