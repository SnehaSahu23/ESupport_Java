package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_9206583_AMER_EditSubscription_EditComponents_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_9206583_AMER_EditSubscription_EditComponents_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_9206583_AMER_EditSubscription_EditComponents_Esupport");

			obj_EsupportDriverandDownloadsWorkflow.ClickSignIn(driver);
			obj_EsupportDriverandDownloadsWorkflow.Login(driver);
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLaptops(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitude(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitudeE4200(driver);
			System.out.println("Clicked on Latitude E4200");                 
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.ClickDriversandDownloads_Tab(driver);
			obj_EsupportDriverandDownloadsWorkflow.selectOperatingSystem(driver);



		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_9206583_AMER_EditSubscription_EditComponents_Esupport--------->\n  "+e);

		}

	}
}
