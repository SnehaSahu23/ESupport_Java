package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_8195087_AMER_ED_ProductSupport_LEMC_ProductionAutomation extends BaseTest
{
	@Test
	public void validate_TC_8195087_AMER_ED_ProductSupport_LEMC_ProductionAutomation() 
	{
		try
		{
			System.out.println("Starts TC_8195087_AMER_ED_ProductSupport_LEMC_ProductionAutomation");
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.time(driver);
			obj_EsupportProductionValidationsWorkflow.verifyIPS_LEMC_AdvisoriesTabFunctionality(driver);
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.verifyIPS_LEMC_SupportsiteContactusslideropenonlyonclick(driver);
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.verifyIPS_LEMC_ContactussliderauthenticatedLEMCmodel_series_familychannels(driver);
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.verifyIPS_LEMC_ContactUsSlider_authenticated_LEMC_serialized_channels(driver);
			Thread.sleep(10000);
//		//	Need Product ID
			obj_EsupportProductionValidationsWorkflow.verifyIPS_LEMC_EnterProductID_AuthenticatedUser_model_series_family_page(driver);
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.verifyIPS_LEMC_Serialized_ChangeProduct(driver);
//			Need Product ID
			obj_EsupportProductionValidationsWorkflow.verifyIPS_LEMC_EnterProductID_AuthenticatedUser_model_series_family_pageAcceptHyphen(driver);
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.verifyIPS_LEMC_SerializedMapFunctionality(driver);
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.verifyIPS_LEMC_ConvergedSolutionsFunctionality(driver);
//			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.time(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_8195087_AMER_ED_ProductSupport_LEMC_ProductionAutomation--------->\n  "+e);
		}
	}
}
