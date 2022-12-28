package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5766888_AMER_CH_ContactTechnicalSupport_ExpressServiceCode_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5766888_AMER_CH_ContactTechnicalSupport_ExpressServiceCode_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5766888_AMER_CH_ContactTechnicalSupport_ExpressServiceCode_ESUPPORT");
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));



		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5766888_AMER_CH_ContactTechnicalSupport_ExpressServiceCode_ESUPPORT--------->\n  "+e);

		}

	}
}


