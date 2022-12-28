package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_D9206582_AMER_FF_DriversNotifications_Edit_Products_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_D9206582_AMER_FF_DriversNotifications_Edit_Products_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_D9206582_AMER_IE_DriversNotifications_Edit_Products");
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
			//obj_EsupportDriverandDownloadsWorkflow.ClickCreateSubscription_AuthenticatedUser_ChangeProduct(driver);
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while executing TC_D9206582_AMER_FF_DriversNotifications_Edit_Products_ESUPPORT--------->\n  "+e);

		}

	}
}