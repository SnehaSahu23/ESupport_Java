package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9839297_AMER_MB_MPS_PCF_MPSRowexpansionPartsAndAccessoriesDocumentationDiagnosticsAndExtendOrUpgradeLinks_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_9839297_AMER_MB_MPS_PCF_MPSRowexpansionPartsAndAccessoriesDocumentationDiagnosticsAndExtendOrUpgradeLinks_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9839297_AMER_MB_MPS_PCF_MPSRowexpansionPartsAndAccessoriesDocumentationDiagnosticsAndExtendOrUpgradeLinks_ESUPPORT()");
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
            obj_EsupportMobileWorkflow.clickSignIn(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
            obj_EsupportMobileWorkflow.clickOnExpandButtonOfFirstDisplayedRow(driver);
//            obj_EsupportMobileWorkflow.clickOnPartsAndAccessoriesLink(driver);
//            obj_EsupportMobileWorkflow.clickOnDocumentationLink(driver);
//			
//            obj_EsupportMobileWorkflow.clickOnDiagnosticsLink(driver);
//            obj_EsupportMobileWorkflow.clickOnDriversAndDownloadsLink(driver);
			
			//obj_EsupportMPSWorkflow.clickOnExtendOrUpgradeLink(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9839297_AMER_MB_MPS_PCF_MPSRowexpansionPartsAndAccessoriesDocumentationDiagnosticsAndExtendOrUpgradeLinks_ESUPPORT()--------->\n  "+e);
		}
	}
}
