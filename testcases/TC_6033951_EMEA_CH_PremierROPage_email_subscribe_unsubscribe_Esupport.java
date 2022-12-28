package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6033951_EMEA_CH_PremierROPage_email_subscribe_unsubscribe_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6033951_EMEA_CH_PremierROPage_email_subscribe_unsubscribe_Esupport() 
	{
		try
		{
			System.out.println("Starts TC# _6033951_EMEA_CH");		
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			obj_EsupportOrderHomeWorkflow.premierLogin(driver, TestNGCreator.TestData.get(Esupport.Account.ordinal()) );
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
//			obj_EsupportOrderHomeWorkflow.handlePremierPopup(driver);
//			obj_EsupportRecentOrderWorkflow.clickOrderStatusLink(driver);
			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()));
			obj_EsupportRecentOrderWorkflow.premierActionDropdown(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()));
			//obj_EsupportRecentOrderWorkflow.handlePremierStatusDropdown_UK(driver, TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()));
			obj_EsupportRecentOrderWorkflow.handleCheckbox(driver,true);	
			obj_EsupportRecentOrderWorkflow.handleSubscribePopup(driver, true);
			obj_EsupportRecentOrderWorkflow.handleCheckbox(driver,false);
			obj_EsupportRecentOrderWorkflow.handleSubscribePopup(driver, false);
			Thread.sleep(6000);

		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6033951_EMEA_CH_PremierROPage_email_subscribe_unsubscribe_Esupport --------->\n  "+e);
		}
	}
}
