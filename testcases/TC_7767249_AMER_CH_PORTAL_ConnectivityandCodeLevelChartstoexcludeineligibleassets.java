package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7767249_AMER_CH_PORTAL_ConnectivityandCodeLevelChartstoexcludeineligibleassets extends BaseTest
{
	@Test
	public void validate_TC_7767249_AMER_CH_PORTAL_ConnectivityandCodeLevelChartstoexcludeineligibleassets() 
	{
		try
		{
			System.out.println("Starts TC_7767249_AMER_CH_PORTAL_ConnectivityandCodeLevelChartstoexcludeineligibleassets");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickInstallBaseTab(driver);
			obj_EsupportPortalWorkflow.clickInstallBaseConnectivityButton(driver);
			obj_EsupportPortalWorkflow.clickInstallBaseVisualizationButton(driver);	
			obj_EsupportPortalWorkflow.verifyConnectedAndNotConnectedArcsInGraphView(driver);
			obj_EsupportPortalWorkflow.verifyNotEligibleOptionInConnectivityFilter(driver);
			obj_EsupportPortalWorkflow.verifyConnectedAndNotConnectedArcsInHUD(driver);
			obj_EsupportPortalWorkflow.clickInstallBaseCodeLevelsButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifyInstallBaseCodeLevelBubbleChartIneligibleAsset(driver);
			obj_EsupportPortalWorkflow.verifyInstallBaseCodeLevelsHUDArcIneligibleAsset(driver);
			Thread.sleep(5000);
			obj_EsupportPortalWorkflow.verifyInstallBaseCodeLevelBubbleChartMissingCode(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7767249_AMER_CH_PORTAL_ConnectivityandCodeLevelChartstoexcludeineligibleassets--------->\n  "+e);
		}
	}
}
