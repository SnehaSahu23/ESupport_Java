package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5785256_AMER_ED_SystemConfigurationOriginalConfiguration_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5785256_AMER_ED_SystemConfigurationOriginalConfiguration_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5785256_AMER_ED_SystemConfigurationOriginalConfiguration_ESUPPORT");
			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportContentWorkflow.TOVerify_NavigationTabs(driver);
			obj_EsupportContentWorkflow.clickSystemConfiguration_Tab(driver);
			obj_EsupportContentWorkflow.clickOriginalConfiguration(driver);
			obj_EsupportContentWorkflow.clickExportButton(driver);
			obj_EsupportContentWorkflow.clickShowAllButton(driver);
			obj_EsupportContentWorkflow.clickHideAllButton(driver);
			driver.navigate().to("https://www.dell.com/support/home");
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLaptops(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitude(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitudeE4200(driver);
			obj_EsupportContentWorkflow.clickSystemConfiguration_Tab(driver);
			obj_EsupportContentWorkflow.validateConfigurationElements(driver);
			//obj_EsupportContentWorkflow.clickDetectPCButton(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5785256_AMER_ED_SystemConfigurationOriginalConfiguration_ESUPPORT--------->\n  "+e);

		}

	}
}