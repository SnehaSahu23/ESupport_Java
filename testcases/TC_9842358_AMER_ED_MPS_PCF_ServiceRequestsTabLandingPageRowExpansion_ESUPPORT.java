package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9842358_AMER_ED_MPS_PCF_ServiceRequestsTabLandingPageRowExpansion_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9842358_AMER_ED_MPS_PCF_ServiceRequestsTabLandingPageRowExpansion_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9842358_AMER_ED_MPS_PCF_ServiceRequestsTabLandingPageRowExpansion_ESUPPORT()");
			
//			obj_EsupportMPSWorkflow.clickSignIn(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.SignInToMyAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.clickOnServiceRequestTab(driver);
			obj_EsupportMPSWorkflow.clickOnContactSupportLink_SRTab(driver);
			obj_EsupportMPSWorkflow.verifyColumnNamesInGrid_SRTab(driver);
		
			obj_EsupportMPSWorkflow.clickOnExpandButtonOfFirstDisplayedRow_SRTab(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9842358_AMER_ED_MPS_PCF_ServiceRequestsTabLandingPageRowExpansion_ESUPPORT()--------->\n  "+e);
		}
	}
}

