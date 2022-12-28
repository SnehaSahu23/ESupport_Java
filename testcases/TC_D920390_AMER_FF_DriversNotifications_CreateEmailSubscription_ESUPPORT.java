package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_D920390_AMER_FF_DriversNotifications_CreateEmailSubscription_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_D920390_AMER_FF_DriversNotifications_CreateEmailSubscription_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC# _D920390");  
			obj_EsupportDriverandDownloadsWorkflow.ClickSignIn(driver);
			obj_EsupportDriverandDownloadsWorkflow.Login(driver);
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickBrowseAllProductsLink(driver);
			//obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLaptops(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitude(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitudeE4200(driver);
			System.out.println("Clicked on Latitude E4200");  
			obj_EsupportDriverandDownloadsWorkflow.ClickDriversandDownloads_Tab(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickDriverNotifications(driver);
			obj_EsupportDriverandDownloadsWorkflow.ClickCreateSubscription_SelectOS(driver);
			obj_EsupportDriverandDownloadsWorkflow.selectCheckBox(driver);
			obj_EsupportDriverandDownloadsWorkflow.deSelectCheckBox(driver);
			obj_EsupportDriverandDownloadsWorkflow.selectCheckBoxWindow7(driver);
			obj_EsupportDriverandDownloadsWorkflow.deSelectCheckBoxWindow7(driver);

		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_D920390_AMER_FF_DriversNotifications_CreateEmailSubscription_ESUPPORT--------->\n  "+e);
		}
	}
}

