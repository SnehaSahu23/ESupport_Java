package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9950600_AMER_MB_Story9906253ImprovedMessagingforNetworkcategorydownloads_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_9950600_AMER_MB_Story9906253ImprovedMessagingforNetworkcategorydownloads_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9950600_AMER_MB_Story9906253ImprovedMessagingforNetworkcategorydownloads_ESUPPORT");

			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.ClickSearchProduct(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
            obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
			
//            obj_EsupportMobileWorkflow.selectVideoOptionFromCategory(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
            obj_EsupportMobileWorkflow.validateBannerForSelectedCategory(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
            obj_EsupportMobileWorkflow.clickTroubleShootLink(driver,MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()), MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9950600_AMER_MB_Story9906253ImprovedMessagingforNetworkcategorydownloads_ESUPPORT--------->\n  "+e);
		}
	}
}
