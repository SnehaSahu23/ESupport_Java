package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5755260_AMER_IE_Orders_status_home_page_non_order_number_search_ESUPPORT  extends BaseTest {

	@Test
	public void validate_TC_5755260_AMER_IE_Orders_status_home_page_non_order_number_search_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 5755260_AMER_IE");        
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			Thread.sleep(7000);
			obj_EsupportOrderHomeWorkflow.orderHomePage(driver);
			obj_EsupportOrderHomeWorkflow.enterOrderNumber(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5755260_AMER_IE_Orders_status_home_page_non_order_number_search_ESUPPORT--------->\n  "+e);

		}

	}
}