package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_D920648_AMER_CH_DriversNotifications_PathbackDnD_authenticatedUser_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_D920648_AMER_CH_DriversNotifications_PathbackDnD_authenticatedUser_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_D920601_AMER_CH_DriversNotifications_CreateEmailSubscription_SelectDevices");
			obj_EsupportDriverandDownloadsWorkflow.ClickSignIn(driver);
			obj_EsupportDriverandDownloadsWorkflow.Login(driver);
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			//obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLaptops(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitude(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitudeE4200(driver);
			System.out.println("Clicked on Latitude E4200");                 
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.ClickDriversandDownloads_Tab(driver);
			//obj_EsupportDriverandDownloadsWorkflow.ClickCreateSubscription_TabDelete(driver);
			//obj_EsupportDriverandDownloadsWorkflow.TOVerify_clickDriverNotifications(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.TOVerify_clickDriverNotificationsViewALL(driver);
			

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_D920648_AMER_CH_DriversNotifications_PathbackDnD_authenticatedUser_ESUPPORT--------->\n  "+e);

		}

	}
}
