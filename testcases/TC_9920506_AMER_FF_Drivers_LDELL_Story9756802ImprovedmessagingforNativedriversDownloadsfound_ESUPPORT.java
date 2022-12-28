package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9920506_AMER_FF_Drivers_LDELL_Story9756802ImprovedmessagingforNativedriversDownloadsfound_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9920506_AMER_FF_Drivers_LDELL_Story9756802ImprovedmessagingforNativedriversDownloadsfound_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9920506_AMER_FF_Drivers_LDELL_Story9756802ImprovedmessagingforNativedriversDownloadsfound_ESUPPORT");


			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ClickOnCollapsedDriversList(driver);
			
			//Searching keyword 1
			obj_EsupportDriverandDownloadsWorkflow.SearchKeywordFromDriversPage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			obj_EsupportDriverandDownloadsWorkflow.validateBannerForSelectedCategory(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			obj_EsupportDriverandDownloadsWorkflow.clickTroubleShootLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			//Searching keyword 2
			obj_EsupportDriverandDownloadsWorkflow.SearchKeywordFromDriversPage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			obj_EsupportDriverandDownloadsWorkflow.validateBannerForSelectedCategory(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			obj_EsupportDriverandDownloadsWorkflow.clickTroubleShootLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			//Searching keyword 3
			obj_EsupportDriverandDownloadsWorkflow.SearchKeywordFromDriversPage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportDriverandDownloadsWorkflow.validateBannerForSelectedCategory(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportDriverandDownloadsWorkflow.clickTroubleShootLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9920506_AMER_FF_Drivers_LDELL_Story9756802ImprovedmessagingforNativedriversDownloadsfound_ESUPPORT--------->\n  "+e);
		}
	}
}

