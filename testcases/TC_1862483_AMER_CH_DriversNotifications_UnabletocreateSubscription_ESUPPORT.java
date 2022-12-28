package com.dell.delta_uat_automation.esupport.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;


public class TC_1862483_AMER_CH_DriversNotifications_UnabletocreateSubscription_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_1862483_AMER_CH_DriversNotifications_UnabletocreateSubscription_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_1862483_AMER_CH_DriversNotifications_UnabletocreateSubscription_ESUPPORT");
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportDriverandDownloadsWorkflow.ToClick_Storage(driver);
			obj_EsupportDriverandDownloadsWorkflow.ToClick_EntryLevelMidrange(driver);
			obj_EsupportDriverandDownloadsWorkflow.ToClick_EqualLogiclink(driver);
			obj_EsupportDriverandDownloadsWorkflow.ToClick_EqualLogicProductlink(driver);
			System.out.println("Clicked on Equallogic PS6010");
			
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ClickDriversandDownloads_Tab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ClickCreateSubscription_TabLagecyProduct(driver);
			
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_1862483_AMER_CH_DriversNotifications_UnabletocreateSubscription_ESUPPORT--------->\n  "+e);

		}

	}
}