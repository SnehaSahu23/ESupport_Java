
package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_19214795_AMER_authenticatedUsers_NotificationSummaryPage_CancelBehavior_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_19214795_AMER_authenticatedUsers_NotificationSummaryPage_CancelBehavior_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_19214795_AMER_authenticatedUsers_NotificationSummaryPage_CancelBehavior_ESUPPORT");
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
			//obj_EsupportDriverandDownloadsWorkflow.ClickCreateSubscription_TabDelete(driver);
			obj_EsupportDriverandDownloadsWorkflow.TOVerify_clickDriverNotificationsUpdatelink(driver);
			
			

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_19214795_AMER_authenticatedUsers_NotificationSummaryPage_CancelBehavior_ESUPPORT--------->\n  "+e);

		}

	}
}


