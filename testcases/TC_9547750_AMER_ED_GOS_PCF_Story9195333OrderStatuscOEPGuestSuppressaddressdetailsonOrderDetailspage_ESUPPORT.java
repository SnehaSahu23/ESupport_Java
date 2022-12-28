package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9547750_AMER_ED_GOS_PCF_Story9195333OrderStatuscOEPGuestSuppressaddressdetailsonOrderDetailspage_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_9547750_AMER_ED_GOS_PCF_Story9195333OrderStatuscOEPGuestSuppressaddressdetailsonOrderDetailspage_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_9547750_AMER_ED_GOS_PCF_Story9195333OrderStatuscOEPGuestSuppressaddressdetailsonOrderDetailspage_ESUPPORT");        
			
			obj_EsupportOrderHomeWorkflow.validateOrderHomePage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.validateOrderNumberSearch(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.verifyAddressDetailsForUnauthenticated(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_9547750_AMER_ED_GOS_PCF_Story9195333OrderStatuscOEPGuestSuppressaddressdetailsonOrderDetailspage_ESUPPORT--------->\n  "+e);

		}

	}
}

