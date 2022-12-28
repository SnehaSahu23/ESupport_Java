package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5836511_AMER_MB_SupportSearch_IntegratedUX_Searchresultimplementation_Esupport extends MobilePage{
	@Test
	public void validate_TC_5836511_AMER_MB_SupportSearch_IntegratedUX_Searchresultimplementation_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# 5836511"); 
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.searchResult(driver);

		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5836511_AMER_MB_SupportSearch_IntegratedUX_Searchresultimplementation_Esupport--------->\n  "+e);
		}
	}
}

