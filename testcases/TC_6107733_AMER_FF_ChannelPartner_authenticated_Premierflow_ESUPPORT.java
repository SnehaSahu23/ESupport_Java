package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6107733_AMER_FF_ChannelPartner_authenticated_Premierflow_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_6107733_AMER_FF_ChannelPartner_authenticated_Premierflow_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_6107733_AMER_FF_ChannelPartner_authenticated_Premierflow_ESUPPORT");
			//  obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));

			if(TestNGCreator.TestData.get(Esupport.Username.ordinal()).equalsIgnoreCase("h_neharkar@dell.com"))
			{
				obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			}
			else
			{
				obj_EsupportOrderHomeWorkflow.handlePremierPopup(driver);
				obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			}



			obj_EsupportRecentOrderWorkflow.clickOrderStatusLink(driver);
			obj_EsupportRecentOrderWorkflow.PROrderHeader(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			
			obj_EsupportRecentOrderWorkflow.ToClick_SearchboxradioOrder(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));
			//obj_EsupportOrderHomeWorkflow.handleCookies(driver);


			Thread.sleep(3000);




		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_6107733_AMER_FF_ChannelPartner_authenticated_Premierflow_ESUPPORT--------->\n  "+e);

		}

	}

}
