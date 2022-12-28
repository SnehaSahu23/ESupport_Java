package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6107708_AMER_FF_Premier_PQAThomesearch_POsearch_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_6107708_AMER_FF_Premier_PQAThomesearch_POsearch_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_6107708_AMER_FF_Premier_PQAThomesearch_POsearch_ESUPPORT");
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			//  obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));

			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
//			obj_EsupportOrderHomeWorkflow.handlePremierPopup(driver);
//			obj_EsupportRecentOrderWorkflow.clickOrderStatusLink(driver);
			obj_EsupportRecentOrderWorkflow.PROrderHeader(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);

			obj_EsupportRecentOrderWorkflow.ToVerify_PQATLink(driver);
			obj_EsupportRecentOrderWorkflow.TOverify_RecentorderheaderSerachform(driver,TestNGCreator.TestData.get(Esupport.PONumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.PONumber.ordinal()).split(";")[1]);

			

			Thread.sleep(3000);




		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_6107708_AMER_FF_Premier_PQAThomesearch_POsearch_ESUPPORT--------->\n  "+e);

		}

	}

}
