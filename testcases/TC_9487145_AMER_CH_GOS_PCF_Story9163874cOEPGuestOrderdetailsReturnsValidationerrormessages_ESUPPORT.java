package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9487145_AMER_CH_GOS_PCF_Story9163874cOEPGuestOrderdetailsReturnsValidationerrormessages_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_9487145_AMER_CH_GOS_PCF_Story9163874cOEPGuestOrderdetailsReturnsValidationerrormessages_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_9487145_AMER_CH_GOS_PCF_Story9163874cOEPGuestOrderdetailsReturnsValidationerrormessages_ESUPPORT");        
			
			obj_EsupportOrderHomeWorkflow.validateOrderHomePage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.validateOrderNumberSearch(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.verifyActionSectionForReturnLink(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickOnReturnButton(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.validateEnteringInvalidCustomerNumber(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_9487145_AMER_CH_GOS_PCF_Story9163874cOEPGuestOrderdetailsReturnsValidationerrormessages_ESUPPORT--------->\n  "+e);

		}

	}
}
