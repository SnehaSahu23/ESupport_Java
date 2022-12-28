package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9942513_AMER_MB_GOS_PCF_OrdersupportPremierCOEPDashboardOrdernumbersearchandmultipleordernumbersearch_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_9942513_AMER_MB_GOS_PCF_OrdersupportPremierCOEPDashboardOrdernumbersearchandmultipleordernumbersearch_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_9942513_AMER_MB_GOS_PCF_OrdersupportPremierCOEPDashboardOrdernumbersearchandmultipleordernumbersearch_ESUPPORT");        
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
			obj_EsupportMobileWorkflow.searchForOrderNumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0]);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.searchForOrderNumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[1]);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.searchForOrderNumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[2]);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.searchForOrderNumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[3]);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.searchForOrderNumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[4]);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.searchForOrderNumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[5]);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.searchForOrderNumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[6]);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.searchForOrderNumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[7]);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.searchForOrderNumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[8]);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.searchForOrderNumberAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[9]);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_9942513_AMER_MB_GOS_PCF_OrdersupportPremierCOEPDashboardOrdernumbersearchandmultipleordernumbersearch_ESUPPORT--------->\n  "+e);

		}

	}
}

