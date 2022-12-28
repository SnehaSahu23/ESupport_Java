package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5795600_AMER_FF_ContactOrderSupport_OrderDetails_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5795600_AMER_FF_ContactOrderSupport_OrderDetails_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5795600_AMER_FF_ContactOrderSupport_OrderDetails_ESUPPORT");

			obj_EsupportIncidentsWorkflow.ToVerify_ContanctOrderSupport(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.ToVerify_ClickContanctOrderSupportSearch(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));


		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5795600_AMER_FF_ContactOrderSupport_OrderDetails_ESUPPORT--------->\n  "+e);

		}

	}
}

