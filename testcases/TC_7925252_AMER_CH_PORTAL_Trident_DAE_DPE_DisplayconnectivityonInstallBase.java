package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7925252_AMER_CH_PORTAL_Trident_DAE_DPE_DisplayconnectivityonInstallBase extends BaseTest
{
	@Test
	public void validate_TC_7925252_AMER_CH_PORTAL_Trident_DAE_DPE_DisplayconnectivityonInstallBase() 
	{
		try
		{
			System.out.println("Starts TC_7925252_AMER_CH_PORTAL_Trident_DAE_DPE_DisplayconnectivityonInstallBase");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.clickInstallBaseTab(driver);
			obj_EsupportPortalWorkflow.clickInstallBaseConnectivityButton(driver);
			Thread.sleep(5000);
			obj_EsupportPortalWorkflow.clickExpandArrowAndVerifyConnectivityStatus(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7925252_AMER_CH_PORTAL_Trident_DAE_DPE_DisplayconnectivityonInstallBase--------->\n  "+e);
		}
	}
}

