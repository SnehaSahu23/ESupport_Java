package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8255276_AMER_IE_ProductionAutomation_Drivers extends BaseTest
{
	@Test
	public void validate_TC_8255276_AMER_IE_ProductionAutomation_Drivers() 
	{
		try
		{
			System.out.println("Starts TC_8255276_AMER_IE_ProductionAutomation_Drivers");
			
			obj_EsupportProductionValidationsWorkflow.verifyDrivers_ProductionAutomationFunctionality(driver);
			obj_EsupportProductionValidationsWorkflow.launchurl(driver);	
			obj_EsupportProductionValidationsWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			
			obj_EsupportProductionValidationsWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportProductionValidationsWorkflow.pcfVerifyDriversTable(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickViewDetailsLinkForFirstDisplayedDriver(driver);
			
			obj_EsupportProductionValidationsWorkflow.VerifyKitcAndOsisoDriversDetailsPage(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyCertifiedDriverPage(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyCoReqPreReqDriverPage(driver);
			
			obj_EsupportProductionValidationsWorkflow.ValidateDownloadForRestrictedAndSecureDriversDetailsPage(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_8255276_AMER_IE_ProductionAutomation_Drivers--------->\n  "+e);
		}
	}
}

