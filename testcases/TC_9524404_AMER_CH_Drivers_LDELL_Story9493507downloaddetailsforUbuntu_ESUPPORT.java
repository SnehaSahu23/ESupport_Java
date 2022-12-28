package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9524404_AMER_CH_Drivers_LDELL_Story9493507downloaddetailsforUbuntu_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9524404_AMER_CH_Drivers_LDELL_Story9493507downloaddetailsforUbuntu_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9524404_AMER_CH_Drivers_LDELL_Story9493507downloaddetailsforUbuntu_ESUPPORT");


			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ClickOnCollapsedDriversList(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.selectUbuntuVersionFromOperatingSystem_Nodrivers(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
//			obj_EsupportDriverandDownloadsWorkflow.validateBannerForSelectedOS(driver);
			
//			obj_EsupportDriverandDownloadsWorkflow.clickUbuntuLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9524404_AMER_CH_Drivers_LDELL_Story9493507downloaddetailsforUbuntu_ESUPPORT--------->\n  "+e);
		}
	}
}

