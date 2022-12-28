package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8028914_AMER_CH_MPS_PROD_TESTING_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_8028914_AMER_CH_MPS_PROD_TESTING_ESUPPORT() 
	{

		try
		{
			System.out.println("Starting TC_8028914_AMER_CH_MPS_PROD_TESTING_ESUPPORT");
			
			obj_EsupportProductionValidationsWorkflow.verifyMPS_ProductionAutomationFunctionality(driver);			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8028914_AMER_CH_MPS_PROD_TESTING_ESUPPORT--------->\n  "+e);

		}

	}

}