package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5835879_AMER_CH_OOWFailureMailinExpressServiceUI_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5835879_AMER_CH_OOWFailureMailinExpressServiceUI_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_5835879_AMER_CH_OOWFailureMailinExpressServiceUI_ESUPPORT");
			obj_EsupportErevenueWorkflow.handleCookies(driver);			
		}
		catch(Exception e)
		{
			Assert.fail("Failed while TC_5835879_AMER_CH_OOWFailureMailinExpressServiceUI_ESUPPORT--------->\n  "+e);
		}

	}
}