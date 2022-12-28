package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5755323_AMER_CH_GOS_PCF_OrderstatushomepageUnauthenticatedOtherlookupoptionBillinginformation_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_5755323_AMER_CH_GOS_PCF_OrderstatushomepageUnauthenticatedOtherlookupoptionBillinginformation_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_5755323_AMER_CH_GOS_PCF_OrderstatushomepageUnauthenticatedOtherlookupoptionBillinginformation_ESUPPORT");        
			
			obj_EsupportOrderHomeWorkflow.validateOrderHomePage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickOnOtherLookUpOptions(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.selectBillingInformationFromDropdown(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.enterAllDetailsAndClickOnFindOrder_BillingInformation(driver,TestNGCreator.TestData.get(Esupport.FirstName.ordinal()),TestNGCreator.TestData.get(Esupport.LastName.ordinal()),TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()),TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()));
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5755323_AMER_CH_GOS_PCF_OrderstatushomepageUnauthenticatedOtherlookupoptionBillinginformation_ESUPPORT--------->\n  "+e);

		}

	}
}
