package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;

public class TC_7219811_AMER_MB_DriversAndDownloads_PCFMigrationDnD_DisplayDriverDetailsInUI_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_7219811_AMER_MB_DriversAndDownloads_PCFMigrationDnD_DisplayDriverDetailsInUI_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7219811_AMER_MB_DriversAndDownloads_PCFMigrationDnD_DisplayDriverDetailsInUI_ESUPPORT");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.ClickSearchProduct(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
            obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
            obj_EsupportMobileWorkflow.pcfVerifyDriversTable(driver);
			
            obj_EsupportMobileWorkflow.ClickViewDetailsLinkForFirstDisplayedDriver(driver);
			
            obj_EsupportMobileWorkflow.VerifyKitcAndOsisoDriversDetailsPage(driver);
            obj_EsupportMobileWorkflow.VerifyCertifiedDriverPage(driver);
//			obj_EsupportDriverandDownloadsWorkflow.VerifyCoReqPreReqDriverPage(driver);
			
            obj_EsupportMobileWorkflow.ValidateDownloadForRestrictedAndSecureDriversDetailsPage(driver);			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7219811_AMER_MB_DriversAndDownloads_PCFMigrationDnD_DisplayDriverDetailsInUI_ESUPPORT--------->\n  "+e);
		}
	}
}
