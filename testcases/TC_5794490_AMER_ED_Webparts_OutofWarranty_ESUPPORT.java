
package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5794490_AMER_ED_Webparts_OutofWarranty_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5794490_AMER_ED_Webparts_OutofWarranty_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5794490_AMER_ED_Webparts_OutofWarranty_ESUPPORT");
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTagOOW(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIncidentsWorkflow.ToClick_VerifyWebparts(driver);



		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5794490_AMER_ED_Webparts_OutofWarranty_ESUPPORT--------->\n  "+e);

		}

	}
}


