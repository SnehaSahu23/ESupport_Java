package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5782254_AMER_CH_GOS_PCF_OrderstatusUSVerifythePremierinvoicingreportfunctionality_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_5782254_AMER_CH_GOS_PCF_OrderstatusUSVerifythePremierinvoicingreportfunctionality_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC# TC_5782254_AMER_CH_GOS_PCF_OrderstatusUSVerifythePremierinvoicingreportfunctionality_ESUPPORT"); 
			
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
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19/Invoice/List?c=us&l=en&s=gen");
			Thread.sleep(6000);
			driver.get(driver.getCurrentUrl());
			Thread.sleep(6000);
			driver.get(driver.getCurrentUrl());
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickOnAnyInvoiceFromTheGridAndValidate(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.searchForInvoiceAndValidateGrid(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			Thread.sleep(6000);
			obj_EsupportRecentOrderWorkflow.calendarVerification(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5782254_AMER_CH_GOS_PCF_OrderstatusUSVerifythePremierinvoicingreportfunctionality_ESUPPORT--------->\n  "+e);
		}
	}

}