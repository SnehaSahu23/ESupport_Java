package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9899199_AMER_IE_GOS_PCF_OrdersupportTransactionalMyaccount_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_9899199_AMER_IE_GOS_PCF_OrdersupportTransactionalMyaccount_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_9899199_AMER_IE_GOS_PCF_OrdersupportTransactionalMyaccount_ESUPPORT");        
			
			obj_EsupportOrderHomeWorkflow.validateOrderHomePage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.ClickOnMyAccountSignIn(driver);
			Thread.sleep(6000);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.VerifyOrdersInCollectionViewPage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.VerifyCollectionViewPage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.VerifyPriceCardOnEachOrder(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.VerifyViewOrderDetailsButtonOnEachCard(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.VerifyPackingSlipAndInvoiceLinkOnFirstDisplayedCard(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.VerifyOrderNumberAndDPIDDetailsOnFirstDisplayedCard(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickOnViewPackingSlipLink(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickOnInvoiceSlipLink(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickOnFirstOrderNumberDisplayed(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickOnDPIDNumber(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.VerifyDownloadRecordsLinkAndclickOnIt(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_9899199_AMER_IE_GOS_PCF_OrdersupportTransactionalMyaccount_ESUPPORT--------->\n  "+e);

		}

	}
}
