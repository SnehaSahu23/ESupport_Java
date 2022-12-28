package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7637156_AMER_CH_PORTAL_HUDthatwillfilterandwillworkwiththevisualizationsmaptableandfilters extends BaseTest
{
	@Test
	public void validate_TC_7637156_AMER_CH_PORTAL_HUDthatwillfilterandwillworkwiththevisualizationsmaptableandfilters() 
	{
		try
		{
			System.out.println("Starts TC_7637156_AMER_CH_PORTAL_HUDthatwillfilterandwillworkwiththevisualizationsmaptableandfilters");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.clickInstallBaseTab(driver);
			obj_EsupportPortalWorkflow.clickConnectivityTabAndApplyConnectivityFilter(driver);
			Thread.sleep(5000);
			obj_EsupportPortalWorkflow.clickCodelLevelTabAndApplyCodeLevelFilter(driver);
			Thread.sleep(5000);
			obj_EsupportPortalWorkflow.clickContractsTabAndApplyContractsFilter(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7637156_AMER_CH_PORTAL_HUDthatwillfilterandwillworkwiththevisualizationsmaptableandfilters--------->\n  "+e);
		}
	}
}