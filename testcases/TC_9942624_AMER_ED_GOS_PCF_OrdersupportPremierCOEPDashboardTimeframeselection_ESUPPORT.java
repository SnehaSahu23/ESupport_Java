package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9942624_AMER_ED_GOS_PCF_OrdersupportPremierCOEPDashboardTimeframeselection_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_9942624_AMER_ED_GOS_PCF_OrdersupportPremierCOEPDashboardTimeframeselection_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_9942624_AMER_ED_GOS_PCF_OrdersupportPremierCOEPDashboardTimeframeselection_ESUPPORT");        
			
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
			obj_EsupportContentWorkflow.UnexpectedPopup_Prod(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.changeTimeFrameAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()),TestNGCreator.TestData.get(Esupport.Optional.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Optional.ordinal()).split(";")[1]);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_9942624_AMER_ED_GOS_PCF_OrdersupportPremierCOEPDashboardTimeframeselection_ESUPPORT--------->\n  "+e);

		}

	}
}
