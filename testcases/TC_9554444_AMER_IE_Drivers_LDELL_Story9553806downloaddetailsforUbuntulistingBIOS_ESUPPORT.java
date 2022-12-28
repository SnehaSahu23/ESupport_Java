package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9554444_AMER_IE_Drivers_LDELL_Story9553806downloaddetailsforUbuntulistingBIOS_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9554444_AMER_IE_Drivers_LDELL_Story9553806downloaddetailsforUbuntulistingBIOS_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9554444_AMER_IE_Drivers_LDELL_Story9553806downloaddetailsforUbuntulistingBIOS_ESUPPORT");


			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ClickOnCollapsedDriversList(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.selectUbuntuVersionFromOperatingSystem(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
//			obj_EsupportDriverandDownloadsWorkflow.validateBannerForSelectedOS(driver);
			
//			obj_EsupportDriverandDownloadsWorkflow.clickUbuntuLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9554444_AMER_IE_Drivers_LDELL_Story9553806downloaddetailsforUbuntulistingBIOS_ESUPPORT--------->\n  "+e);
		}
	}
}

