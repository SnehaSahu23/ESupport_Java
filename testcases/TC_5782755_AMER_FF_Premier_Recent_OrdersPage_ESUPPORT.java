package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5782755_AMER_FF_Premier_Recent_OrdersPage_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_5782755_AMER_FF_Premier_Recent_OrdersPage_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 5782755_AMER_FF");
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			Thread.sleep(7000);
			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal())); 
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
			obj_EsupportRecentOrderWorkflow.clickOrderStatusLink_CHMASTORE(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.VerifyRecentOrdersPage(driver);
			obj_EsupportRecentOrderWorkflow.Clickordernumber(driver,TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[4]);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5782755_AMER_FF_Premier_Recent_OrdersPage_ESUPPORT--------->\n  "+e);

		}

	}

}