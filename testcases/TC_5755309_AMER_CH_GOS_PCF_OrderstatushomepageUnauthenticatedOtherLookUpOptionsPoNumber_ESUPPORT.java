package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5755309_AMER_CH_GOS_PCF_OrderstatushomepageUnauthenticatedOtherLookUpOptionsPoNumber_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_5755309_AMER_CH_GOS_PCF_OrderstatushomepageUnauthenticatedOtherLookUpOptionsPoNumber_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_5755309_AMER_CH_GOS_PCF_OrderstatushomepageUnauthenticatedOtherLookUpOptionsPoNumber_ESUPPORT");        
			
			obj_EsupportOrderHomeWorkflow.validateOrderHomePage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.clickOnOtherLookUpOptions(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.selectPONumberFromDropdown(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.enterAllDetailsAndClickOnFindOrder_PONUmber(driver,TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal()),TestNGCreator.TestData.get(Esupport.PONumber.ordinal()));
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5755309_AMER_CH_GOS_PCF_OrderstatushomepageUnauthenticatedOtherLookUpOptionsPoNumber_ESUPPORT--------->\n  "+e);

		}

	}
}
