package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9942486_AMER_MB_GOS_PCF_OrdersupportPremierCOEPDashboardPOSearchandPOpartialsearch_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_9942486_AMER_MB_GOS_PCF_OrdersupportPremierCOEPDashboardPOSearchandPOpartialsearch_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_9942486_AMER_MB_GOS_PCF_OrdersupportPremierCOEPDashboardPOSearchandPOpartialsearch_ESUPPORT");        
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            
            obj_EsupportMobileWorkflow.validateOrderHomePage(driver);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.ClickOnPremierAccountSignIn(driver);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.accountSelectionForPremierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.launchURL(driver, "https://www.dell.com/support/order-status/en-us/order-support");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.searchForPONumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.PONumber.ordinal()));
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.clickClearButton(driver);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.searchForPONumberAndValidateGrid_2(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_9942486_AMER_MB_GOS_PCF_OrdersupportPremierCOEPDashboardPOSearchandPOpartialsearch_ESUPPORT--------->\n  "+e);

		}

	}
}
