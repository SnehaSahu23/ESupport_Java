package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5774887_AMER_FF_EnterLEMC_Serialnumber_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_5774887_AMER_FF_EnterLEMC_Serialnumber_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5774887_AMER_FF_EnterLEMC_Serialnumber_ESUPPORT");

		  obj_EsupportIntegratedHomePageWorkflow.ToVerify_EnterLEMCSerialNumber(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportIntegratedHomePageWorkflow.EmailloginEMCSerialnumber(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIntegratedHomePageWorkflow.TOVerify_DellEMCProductSupportPage(driver);


		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5774887_AMER_FF_EnterLEMC_Serialnumber_ESUPPORT--------->\n  "+e);

		}

	}

}
