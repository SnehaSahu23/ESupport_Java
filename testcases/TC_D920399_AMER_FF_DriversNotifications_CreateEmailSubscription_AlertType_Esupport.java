package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_D920399_AMER_FF_DriversNotifications_CreateEmailSubscription_AlertType_Esupport extends BaseTest {
	@Test
	public void validate_TC_D920399_AMER_FF_DriversNotifications_CreateEmailSubscription_AlertType_Esupport() 
	{
		try
		{
			System.out.println("Starts TC# _D920390");  
			obj_EsupportDriverandDownloadsWorkflow.ClickSignIn(driver);
			obj_EsupportDriverandDownloadsWorkflow.Login(driver);
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLaptops(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitude(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitudeE4200(driver);
			System.out.println("Clicked on Latitude E4200");  
			obj_EsupportDriverandDownloadsWorkflow.ClickDriversandDownloads_Tab(driver);
			obj_EsupportDriverandDownloadsWorkflow.ClickCreateSubscription_Notification(driver);
			obj_EsupportDriverandDownloadsWorkflow.continueSubscription(driver);             
			obj_EsupportDriverandDownloadsWorkflow.notificatinTypes(driver);
			obj_EsupportDriverandDownloadsWorkflow.selectOperatingSystem_closebrowser(driver);
			


		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_D920399_AMER_FF_DriversNotifications_CreateEmailSubscription_AlertType_Esupport--------->\n  "+e);
		}
	}
}
