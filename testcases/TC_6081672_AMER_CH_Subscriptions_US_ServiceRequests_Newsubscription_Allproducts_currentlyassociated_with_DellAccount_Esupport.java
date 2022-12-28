package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6081672_AMER_CH_Subscriptions_US_ServiceRequests_Newsubscription_Allproducts_currentlyassociated_with_DellAccount_Esupport extends BaseTest {

		@Test
		public void validate_TC_6081672_AMER_CH_Subscriptions_US_ServiceRequests_Newsubscription_Allproducts_currentlyassociated_with_DellAccount_Esupport() 
		{
			try
			{
				System.out.println("Starts TC# _6081672_CH");  


				obj_EsupportSubscriptionWorkflow.TOClick_LOGINSigninButton(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));

				obj_EsupportSubscriptionWorkflow.TOVerify_Supportnotificationsheadersubheader(driver);
				obj_EsupportSubscriptionWorkflow.TOClick_CreateSubscriptionButton_ServiceRequests(driver);
				obj_EsupportSubscriptionWorkflow.TOVerify_ServiceRequestSubscription(driver);
//				obj_EsupportSubscriptionWorkflow.SelectProduct(driver);
//				obj_EsupportSubscriptionWorkflow.toSelectOperatingSystem(driver);
//				obj_EsupportSubscriptionWorkflow.handleNotificationFrequency(driver);
//				obj_EsupportSubscriptionWorkflow.toEnterSubscription(driver);
//				obj_EsupportSubscriptionWorkflow.clickSaveButton(driver);
//				obj_EsupportSubscriptionWorkflow.reviewSubscription(driver);
//				obj_EsupportSubscriptionWorkflow.ToCancelDeleteRecord(driver);
//				obj_EsupportSubscriptionWorkflow.DeleteRecord(driver);


			}
			catch(Exception e)
			{
				Assert.fail("Failed while executing test case TC_6081672_AMER_CH_Subscriptions_US_ServiceRequests_Newsubscription_Allproducts_currentlyassociated_with_DellAccount_Esupport--------->\n  "+e);
			}
		}
	}
