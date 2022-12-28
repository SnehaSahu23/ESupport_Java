package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5795550_AMER_IE_NavigationtoContactOrderSupport_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_5795550_AMER_IE_NavigationtoContactOrderSupport_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5795550_AMER_IE_NavigationtoContactOrderSupport_Esupport");
			obj_EsupportIncidentsWorkflow.navigateToOrderSupportPageOne(driver);	
			obj_EsupportIncidentsWorkflow.navigateToOrderSupportPageTwo(driver);	
			obj_EsupportIncidentsWorkflow.navigateToOrderSupportPageThree(driver);	
			
			
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while TC_5795550_AMER_IE_NavigationtoContactOrderSupport_Esupport--------->\n  "+e);
		}

	}
}

