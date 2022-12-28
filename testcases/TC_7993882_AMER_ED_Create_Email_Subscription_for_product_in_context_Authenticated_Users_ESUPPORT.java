package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7993882_AMER_ED_Create_Email_Subscription_for_product_in_context_Authenticated_Users_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_7993882_AMER_ED_Create_Email_Subscription_for_product_in_context_Authenticated_Users_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 7993882");
			
			obj_EsupportDriverandDownloadsWorkflow.ClickSignIn(driver);
			obj_EsupportDriverandDownloadsWorkflow.Login(driver);
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);

			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportDriverandDownloadsWorkflow.ClickDriversandDownloads_Tab(driver);
			obj_EsupportDriverandDownloadsWorkflow.ClickCreateSubscription_AuthenticatedUser(driver);
			

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_7993882_AMER_ED_Create_Email_Subscription_for_product_in_context_Authenticated_Users_ESUPPORT--------->\n  "+e);

		}

	}

}