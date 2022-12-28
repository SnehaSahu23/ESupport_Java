package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9942641_AMER_FF_GOS_PCF_OrdersupportPremierCOEPDashboardChangeaccountaccessgroup_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_9942641_AMER_FF_GOS_PCF_OrdersupportPremierCOEPDashboardChangeaccountaccessgroup_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_9942641_AMER_FF_GOS_PCF_OrdersupportPremierCOEPDashboardChangeaccountaccessgroup_ESUPPORT");        
			
			obj_EsupportOrderHomeWorkflow.validateOrderHomePage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.ClickOnPremierAccountSignIn(driver);
			Thread.sleep(6000);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.accountSelectionForPremierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()).split(";")[0]);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/order-status/en-us/order-support");
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickOnChangeAccountOrAccessGroup(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.accountSelectionForPremierLogin_ClickingOnChangeAccout(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()).split(";")[1]);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_9942641_AMER_FF_GOS_PCF_OrdersupportPremierCOEPDashboardChangeaccountaccessgroup_ESUPPORT--------->\n  "+e);

		}

	}
}
