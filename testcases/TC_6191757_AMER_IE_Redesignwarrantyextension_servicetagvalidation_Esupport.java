

package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6191757_AMER_IE_Redesignwarrantyextension_servicetagvalidation_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6191757_AMER_IE_Redesignwarrantyextension_servicetagvalidation_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6191757_AMER_IE_Redesignwarrantyextension_servicetagvalidation_Esupport");
			
			obj_EsupportIncidentsWorkflow.ToVerify_WarrentyServicetag(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_servicetagvalidinvalid(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			Thread.sleep(2000);
			
			obj_EsupportIncidentsWorkflow.ToVerify_WarrentyServicetag(driver);
			
			obj_EsupportIncidentsWorkflow.ToVerify_servicetagvalidinvalid(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			
			
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6191757_AMER_IE_Redesignwarrantyextension_servicetagvalidation_Esupport--------->\n  "+e);
		}
	}
}

