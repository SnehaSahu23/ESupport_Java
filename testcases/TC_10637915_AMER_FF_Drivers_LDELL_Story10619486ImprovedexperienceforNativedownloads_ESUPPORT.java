package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10637915_AMER_FF_Drivers_LDELL_Story10619486ImprovedexperienceforNativedownloads_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_10637915_AMER_FF_Drivers_LDELL_Story10619486ImprovedexperienceforNativedownloads_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_10637915_AMER_FF_Drivers_LDELL_Story10619486ImprovedexperienceforNativedownloads_ESUPPORT");


			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ClickOnCollapsedDriversList(driver);
			
			//Searching keyword 1: webcam
			obj_EsupportDriverandDownloadsWorkflow.SearchKeywordFromDriversPage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			obj_EsupportDriverandDownloadsWorkflow.validateBannerForKeyword(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			obj_EsupportDriverandDownloadsWorkflow.clickWindowUpdateLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
//			obj_EsupportDriverandDownloadsWorkflow.clickTroubleShootingLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			//Searching keyword 2:touchpad
			obj_EsupportDriverandDownloadsWorkflow.SearchKeywordFromDriversPage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			obj_EsupportDriverandDownloadsWorkflow.validateBannerForKeyword(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			obj_EsupportDriverandDownloadsWorkflow.clickWindowUpdateLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
//			obj_EsupportDriverandDownloadsWorkflow.clickTroubleShootingLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			//Searching keyword 3:touchscreen
			obj_EsupportDriverandDownloadsWorkflow.SearchKeywordFromDriversPage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportDriverandDownloadsWorkflow.validateBannerForKeyword(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportDriverandDownloadsWorkflow.clickWindowUpdateLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			//obj_EsupportDriverandDownloadsWorkflow.clickTroubleShootingLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			//Searching keyword 3:camera
			obj_EsupportDriverandDownloadsWorkflow.SearchKeywordFromDriversPage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			
			obj_EsupportDriverandDownloadsWorkflow.validateBannerForKeyword(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			
			obj_EsupportDriverandDownloadsWorkflow.clickWindowUpdateLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			
//			obj_EsupportDriverandDownloadsWorkflow.clickTroubleShootingLink(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()), TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10637915_AMER_FF_Drivers_LDELL_Story10619486ImprovedexperienceforNativedownloads_ESUPPORT--------->\n  "+e);
		}
	}
}


