package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5783885_AMER_ED_Details_selected_product_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5783885_AMER_ED_Details_selected_product_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5783885_AMER_ED_Details_selected_product_ESUPPORT");
			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ToVerify_Productpage(driver);
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5783885_AMER_ED_Details_selected_product_ESUPPORT--------->\n  "+e);

		}

	}
}
