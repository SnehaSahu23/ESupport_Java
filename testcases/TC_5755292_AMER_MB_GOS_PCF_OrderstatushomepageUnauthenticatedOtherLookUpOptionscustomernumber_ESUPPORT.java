package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5755292_AMER_MB_GOS_PCF_OrderstatushomepageUnauthenticatedOtherLookUpOptionscustomernumber_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_5755292_AMER_MB_GOS_PCF_OrderstatushomepageUnauthenticatedOtherLookUpOptionscustomernumber_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_5755292_AMER_MB_GOS_PCF_OrderstatushomepageUnauthenticatedOtherLookUpOptionscustomernumber_ESUPPORT");        
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            
            obj_EsupportMobileWorkflow.validateOrderHomePage(driver);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.clickOnOtherLookUpOptions(driver);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.selectCustomerNumberFromDropdown(driver);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.enterAllDetailsAndClickOnFindOrder(driver,TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal()),TestNGCreator.TestData.get(Esupport.PONumber.ordinal()),TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()));
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5755292_AMER_MB_GOS_PCF_OrderstatushomepageUnauthenticatedOtherLookUpOptionscustomernumber_ESUPPORT--------->\n  "+e);

		}

	}
}
