package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6114646_AMER_FF_SRneedslisted_MySupportRequestlist_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_6114646_AMER_FF_SRneedslisted_MySupportRequestlist_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6114646_AMER_FF_SRneedslisted_MySupportRequestlist_Esupport");
			obj_EsupportIncidentsWorkflow.ToVerify_ClickCOntanctUS(driver);
			
			obj_EsupportIncidentsWorkflow.ToClick_ServiceRequestheader(driver);
			
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ToClick_ViewallDellandEMCService(driver);
			
			Thread.sleep(6000);
					}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6114646_AMER_FF_SRneedslisted_MySupportRequestlist_Esupport--------->\n  "+e);
		}
	}
}
