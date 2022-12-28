package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9899095_AMER_CH_GOS_PCF_DPIDSearchOrdercollectionview_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_9899095_AMER_CH_GOS_PCF_DPIDSearchOrdercollectionview_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_9899095_AMER_CH_GOS_PCF_DPIDSearchOrdercollectionview_ESUPPORT");        
			
			obj_EsupportOrderHomeWorkflow.validateOrderHomePage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.validateDPIDNumberSearch(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.VerifyCollectionViewPage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.VerifyViewOrderDetailsButton(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.verifyPricingDetailsForUnauthenticated(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickOnViewOrderDetailsButton(driver);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_9899095_AMER_CH_GOS_PCF_DPIDSearchOrdercollectionview_ESUPPORT--------->\n  "+e);

		}

	}
}