package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5781258_AMER_IE_Orderstatus_Unauthenticated_PremierCustomer_differentordersearch_Esupport extends BaseTest {


	@Test
	public void validate_TC_5781258_AMER_IE_Orderstatus_Unauthenticated_PremierCustomer_differentordersearch_Esupport() 
	{
		try
		{
			System.out.println("Starts TC# 5781258_AMER_IE");                         
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			Thread.sleep(7000);
			obj_EsupportOrderHomeWorkflow.orderHomePage(driver);
			obj_EsupportOrderHomeWorkflow.enterOrderNumber(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));
//			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
//			obj_EsupportOrderHomeWorkflow.handleCaptcha_PurchaseOrder(driver);
			obj_EsupportRecentOrderWorkflow.TOVerify_PurchasedetailsHeader(driver);
//			obj_EsupportOrderHomeWorkflow.handleCookies(driver);

			obj_EsupportRecentOrderWorkflow.TOVerify_clickonotherlookupoptions(driver);



			//obj_EsupportRecentOrderWorkflow.TOVerify_clickonPOActionslabelwithviewdifferentorder(driver);



		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5781258_AMER_IE_Orderstatus_Unauthenticated_PremierCustomer_differentordersearch_Esupport--------->\n  "+e);
		}
	}

}

