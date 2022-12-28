package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5775106_AMER_Multiple_Matches_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_5775106_AMER_Multiple_Matches_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 5775106");
			// Thread.sleep(1000000);

			obj_EsupportIntegratedHomePageWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));




		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5775106_AMER_Multiple_Matches_ESUPPORT--------->\n  "+e);

		}

	}

}

