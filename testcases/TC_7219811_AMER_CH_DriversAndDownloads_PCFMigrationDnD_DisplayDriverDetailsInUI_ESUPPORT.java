package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7219811_AMER_CH_DriversAndDownloads_PCFMigrationDnD_DisplayDriverDetailsInUI_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7219811_AMER_CH_DriversAndDownloads_PCFMigrationDnD_DisplayDriverDetailsInUI_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7219811_AMER_CH_DriversAndDownloads_PCFMigrationDnD_DisplayDriverDetailsInUI_ESUPPORT");

			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyDriversTable(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ClickViewDetailsLinkForFirstDisplayedDriver(driver);
			
//			obj_EsupportDriverandDownloadsWorkflow.VerifyKitcAndOsisoDriversDetailsPage(driver);
			//obj_EsupportDriverandDownloadsWorkflow.VerifyCertifiedDriverPage(driver);
//			obj_EsupportDriverandDownloadsWorkflow.VerifyCoReqPreReqDriverPage(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ValidateDownloadForRestrictedAndSecureDriversDetailsPage(driver);			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7219811_AMER_CH_DriversAndDownloads_PCFMigrationDnD_DisplayDriverDetailsInUI_ESUPPORT--------->\n  "+e);
		}
	}
}
