package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9950601_AMER_FF_Drivers_LDELL_Story9906322ImprovedMessagingforVideocategorydownloads_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9950601_AMER_FF_Drivers_LDELL_Story9906322ImprovedMessagingforVideocategorydownloads_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9950601_AMER_FF_Drivers_LDELL_Story9906322ImprovedMessagingforVideocategorydownloads_ESUPPORT");


			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.selectVideoOptionFromCategory(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			obj_EsupportDriverandDownloadsWorkflow.validateBannerForSelectedCategory(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportDriverandDownloadsWorkflow.clickTroubleShootLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9950601_AMER_FF_Drivers_LDELL_Story9906322ImprovedMessagingforVideocategorydownloads_ESUPPORT--------->\n  "+e);
		}
	}
}
