package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_D920661_AMER_CH_DriversNotifications_DeleteSubscription_Esupport extends BaseTest {

	@Test
	public void validate_TC_D920661_AMER_CH_DriversNotifications_DeleteSubscription_Esupport() 
	{
		try
		{
			System.out.println("Starts TC# _D920661");  
			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportDriverandDownloadsWorkflow.ClickDriversandDownloads_Tab(driver);
			obj_EsupportDriverandDownloadsWorkflow.ClickCreateSubscription_TabDelete(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickDriverNotifications_viewAll(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_D920661_AMER_CH_DriversNotifications_DeleteSubscription_Esupport--------->\n  "+e);
		}
	}
}
