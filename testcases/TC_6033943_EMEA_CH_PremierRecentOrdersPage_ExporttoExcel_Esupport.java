package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6033943_EMEA_CH_PremierRecentOrdersPage_ExporttoExcel_Esupport extends BaseTest
{
	@Test
	public void validate_TC_z_EMEA_CH_PremierRecentOrdersPage_ExporttoExcel_Esupport() 
	{
		try
		{
			System.out.println("Starts TC# _6033943_EMEA_CH"); 
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
//			obj_EsupportOrderHomeWorkflow.handlePremierPopup(driver);
//			obj_EsupportRecentOrderWorkflow.clickOrderStatusLink(driver);
			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()));
			obj_EsupportOrderHomeWorkflow.exportToExcel(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6033943_EMEA_CH_PremierRecentOrdersPage_ExporttoExcel_Esupport--------->\n  "+e);
		}
	}
}

