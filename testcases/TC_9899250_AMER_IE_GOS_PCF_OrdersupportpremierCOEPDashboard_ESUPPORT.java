package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9899250_AMER_IE_GOS_PCF_OrdersupportpremierCOEPDashboard_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_9899250_AMER_IE_GOS_PCF_OrdersupportpremierCOEPDashboard_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_9899250_AMER_IE_GOS_PCF_OrdersupportpremierCOEPDashboard_ESUPPORT");        
			
			obj_EsupportOrderHomeWorkflow.validateOrderHomePage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.ClickOnPremierAccountSignIn(driver);
			Thread.sleep(6000);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.accountSelectionForPremierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/order-status/en-us/order-support");
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.verifyDashBoardSection_Premier(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.verifyDefaultTimeFrame(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.verifyGridBelowDashboard(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.searchForOrderNumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickClearButton(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.searchForPONumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.PONumber.ordinal()));
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickClearButton(driver);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_9899250_AMER_IE_GOS_PCF_OrdersupportpremierCOEPDashboard_ESUPPORT--------->\n  "+e);

		}

	}
}

