package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_D920582_AMER_CH_DriversNotifications_CreateEmailSubscription_Frequency_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_D920582_AMER_CH_DriversNotifications_CreateEmailSubscription_Frequency_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_D920582_AMER_DriversNotifications_CreateEmailSubscription_Frequency");
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
			obj_EsupportDriverandDownloadsWorkflow.ClickCreateSubscription_AuthenticatedUser_ChangeProduct(driver);

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_D920582_AMER_CH_DriversNotifications_CreateEmailSubscription_Frequency_ESUPPORT--------->\n  "+e);

		}

	}
}
