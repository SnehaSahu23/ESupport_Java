package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9487003_AMER_ED_GOS_PCF_Story9173548cOEPGuestOrderdetailsServicetagsSystemNonSystemorders_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_9487003_AMER_ED_GOS_PCF_Story9173548cOEPGuestOrderdetailsServicetagsSystemNonSystemorders_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_9487003_AMER_ED_GOS_PCF_Story9173548cOEPGuestOrderdetailsServicetagsSystemNonSystemorders_ESUPPORT");        
			
			obj_EsupportOrderHomeWorkflow.validateOrderHomePage(driver);
			Thread.sleep(6000);
			//System Order Number
			obj_EsupportOrderHomeWorkflow.validateOrderNumberSearch(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0]);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.validateServiceTagSectionInOrederDetailsPage(driver);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.launchURL(driver);
			Thread.sleep(6000);
			//Non system Order Number
			obj_EsupportOrderHomeWorkflow.validateOrderNumberSearch(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[1]);
			Thread.sleep(6000);
			obj_EsupportOrderHomeWorkflow.validateServiceTagSectionForNonSystemOrder(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_9487003_AMER_ED_GOS_PCF_Story9173548cOEPGuestOrderdetailsServicetagsSystemNonSystemorders_ESUPPORT--------->\n  "+e);

		}

	}
}
