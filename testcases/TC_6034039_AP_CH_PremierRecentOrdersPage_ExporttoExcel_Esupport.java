package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6034039_AP_CH_PremierRecentOrdersPage_ExporttoExcel_Esupport extends BaseTest{

	@Test
	public void validate_TC_6034039_AP_CH_PremierRecentOrdersPage_ExporttoExcel_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# _6034039"); 
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			Thread.sleep(7000);
			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal())); 
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
			obj_EsupportOrderHomeWorkflow.exportToExcel(driver);


		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6034039_AP_CH_PremierRecentOrdersPage_ExporttoExcel_Esupport--------->\n  "+e);
		}
	}

}

