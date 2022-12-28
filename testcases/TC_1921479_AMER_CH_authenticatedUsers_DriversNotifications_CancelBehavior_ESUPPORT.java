

package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_1921479_AMER_CH_authenticatedUsers_DriversNotifications_CancelBehavior_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_1921479_AMER_CH_authenticatedUsers_DriversNotifications_CancelBehavior_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 1921479");
			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportDriverandDownloadsWorkflow.ClickDriversandDownloads_Tab(driver);
			obj_EsupportDriverandDownloadsWorkflow.ClickCreateSubscription_TabChangeProductcancel(driver);
			
			
			

			Thread.sleep(3000);


		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_1921479_AMER_CH_authenticatedUsers_DriversNotifications_CancelBehavior_ESUPPORT--------->\n  "+e);

		}

	}

}




