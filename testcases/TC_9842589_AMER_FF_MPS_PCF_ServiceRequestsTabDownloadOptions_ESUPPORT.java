package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9842589_AMER_FF_MPS_PCF_ServiceRequestsTabDownloadOptions_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9842589_AMER_FF_MPS_PCF_ServiceRequestsTabDownloadOptions_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9842589_AMER_FF_MPS_PCF_ServiceRequestsTabDownloadOptions_ESUPPORT()");
			
//			obj_EsupportMPSWorkflow.clickSignIn(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.SignInToMyAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.clickOnServiceRequestTab(driver);
			obj_EsupportMPSWorkflow.validateDownloadButtonAboveGrid(driver);
			obj_EsupportMPSWorkflow.ClickDownloadButtonAboveGrid_AfterFilter(driver);
			
			obj_EsupportMPSWorkflow.validateFilterSection(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportMPSWorkflow.ClickDownloadButtonAboveGrid_AfterFilter(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9842589_AMER_FF_MPS_PCF_ServiceRequestsTabDownloadOptions_ESUPPORT()--------->\n  "+e);
		}
	}
}
