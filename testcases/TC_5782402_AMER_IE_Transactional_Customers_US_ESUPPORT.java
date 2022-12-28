package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5782402_AMER_IE_Transactional_Customers_US_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_5782402_AMER_IE_Transactional_Customers_US_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 5782402_AMER_IE");
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			Thread.sleep(7000);
			 obj_EsupportIPSWorkflow.clickSignIn(driver);
			 obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			 obj_EsupportOrderHomeWorkflow.handlePremierPopup(driver);
//			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/premier/us/en");
			//obj_EsupportOrderHomeWorkflow.premierLogin(driver);
//			if(TestNGCreator.TestData.get(Esupport.Username.ordinal()).equalsIgnoreCase("h_neharkar@dell.com"))
//			{
//				System.out.println("Matched......");
//				obj_EsupportOrderHomeWorkflow.handleCookies(driver);
//			}
//			else
//			{
//				obj_EsupportOrderHomeWorkflow.handlePremierPopup(driver);
//				obj_EsupportOrderHomeWorkflow.handleCookies(driver);
//			}




//			obj_EsupportRecentOrderWorkflow.clickOrderStatusLink(driver);
			 Thread.sleep(7000);
			obj_EsupportRecentOrderWorkflow.PROrderHeader(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.RecentOrdercolumns(driver);

			obj_EsupportRecentOrderWorkflow.StatusRecentOrder(driver);
			obj_EsupportRecentOrderWorkflow.timeFrameRecentOrder(driver);

			//obj_EsupportRecentOrderWorkflow.CalenderFromdateApplyReset(driver);
			obj_EsupportRecentOrderWorkflow.itemsPerpagedropdown(driver);
			obj_EsupportRecentOrderWorkflow.OptinsDPIDdisplayUS(driver);
			obj_EsupportRecentOrderWorkflow.SelectAnActionDropdown(driver);

			obj_EsupportRecentOrderWorkflow.ToVerify_notselectedPoNumberinToggle(driver);
			obj_EsupportRecentOrderWorkflow.Clickonanyorders(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.PurchasedetailsHeader(driver);
			//obj_EsupportOrderHomeWorkflow.handleCookies(driver);


			obj_EsupportRecentOrderWorkflow.ToVerify_clickOptinsTaggle(driver);



			Thread.sleep(3000);


		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5782402_AMER_IE_Transactional_Customers_US_ESUPPORT--------->\n  "+e);

		}

	}

}
