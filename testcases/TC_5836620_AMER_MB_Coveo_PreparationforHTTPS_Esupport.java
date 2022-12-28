package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5836620_AMER_MB_Coveo_PreparationforHTTPS_Esupport extends MobilePage
{
	@Test
	public void validate_TC_5836620_AMER_MB_Coveo_PreparationforHTTPS_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5836620_AMER_MB_Coveo_PreparationforHTTPS_Esupport");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
            obj_EsupportMobileWorkflow.validateSupportPage(driver);
            obj_EsupportMobileWorkflow.validateSearch(driver);
            obj_EsupportMobileWorkflow.searchServiceTag(driver);

//            obj_EsupportMobileWorkflow.validateHeader(driver);
//            obj_EsupportMobileWorkflow.clickOnLink(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_5836620_AMER_MB_Coveo_PreparationforHTTPS_Esupport--------->\n  "+e);
		}
	}
}
