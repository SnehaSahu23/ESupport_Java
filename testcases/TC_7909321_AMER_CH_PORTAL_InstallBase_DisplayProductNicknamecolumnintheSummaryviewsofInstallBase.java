package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7909321_AMER_CH_PORTAL_InstallBase_DisplayProductNicknamecolumnintheSummaryviewsofInstallBase extends BaseTest
{
	@Test
	public void validate_TC_7909321_AMER_CH_PORTAL_InstallBase_DisplayProductNicknamecolumnintheSummaryviewsofInstallBase() 
	{
		try
		{
			System.out.println("Starts TC_7909321_AMER_CH_PORTAL_InstallBase_DisplayProductNicknamecolumnintheSummaryviewsofInstallBase");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickInstallBaseTab(driver);
			obj_EsupportPortalWorkflow.verifyInstallBaseTotalAssetsColumnsOrder(driver);
			obj_EsupportPortalWorkflow.clickInstallBaseConnectivityButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifyInstallBaseConnectivityColumnsOrder(driver);
			obj_EsupportPortalWorkflow.clickInstallBaseCodeLevelsButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifyInstallBaseCodeLevelsColumnsOrder(driver);
			obj_EsupportPortalWorkflow.clickInstallBaseContractsButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifyInstallBaseContractsColumnsOrder(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7909321_AMER_CH_PORTAL_InstallBase_DisplayProductNicknamecolumnintheSummaryviewsofInstallBase--------->\n  "+e);
		}
	}
}
