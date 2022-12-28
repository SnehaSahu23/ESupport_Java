package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5786145_AMER_FF_Customerlengthchangesfrom9to12_Esupport extends BaseTest
{

	@Test
	public void validate_TC_5786145_AMER_FF_Customerlengthchangesfrom9to12_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_5786145_AMER_FF_Customerlengthchangesfrom9to12_Esupport");


			obj_EsupportMPSWorkflow.handleCookies(driver);
			obj_EsupportMPSWorkflow.MPSLogin(driver);
			obj_EsupportMPSWorkflow.validateTabs(driver);
			obj_EsupportMPSWorkflow.clickOnFindAddProduct(driver);
			obj_EsupportMPSWorkflow.handleCookies(driver);
			obj_EsupportMPSWorkflow.selectCustomerNumber(driver);
			obj_EsupportMPSWorkflow.validateCustomerElements(driver);
			obj_EsupportMPSWorkflow.enterCustomerNumber(driver);


		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5786145_AMER_FF_Customerlengthchangesfrom9to12_Esupport--------->\n  "+e);

		}

	}
}

