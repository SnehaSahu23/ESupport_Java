package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9934416_AMER_ED_GOS_PCF_OrdersupportpremierExport_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_9934416_AMER_ED_GOS_PCF_OrdersupportpremierExport_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_9934416_AMER_ED_GOS_PCF_OrdersupportpremierExport_ESUPPORT");        
			
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
			obj_EsupportOrderHomeWorkflow.VerifyExportOptionAboveGrid(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.changeTimeFrameAndClickOnExport_lessThan2000(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickClearButton(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.changeTimeFrameAndClickOnExport_greaterThan2000(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_9934416_AMER_ED_GOS_PCF_OrdersupportpremierExport_ESUPPORT--------->\n  "+e);

		}

	}
}
