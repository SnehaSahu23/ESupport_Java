package com.dell.delta_uat_automation.esupport.testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5755162_AMER_IE_PremierRecentOrdersPage_ExporttoExcel_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5755162_AMER_IE_PremierRecentOrdersPage_ExporttoExcel_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# _5755162_AMER_IE"); 
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal())); 
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
			Thread.sleep(7000);
			driver.get(driver.getCurrentUrl());
			Thread.sleep(7000);
//			obj_EsupportOrderHomeWorkflow.handlePremierPopup(driver);
//			obj_EsupportRecentOrderWorkflow.clickOrderStatusLink(driver);
			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()));
			obj_EsupportOrderHomeWorkflow.exportToExcel(driver);
			
			Robot rb= new Robot();			
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5755162_AMER_IE_PremierRecentOrdersPage_ExporttoExcel_Esupport--------->\n  "+e);
		}
	}

}

