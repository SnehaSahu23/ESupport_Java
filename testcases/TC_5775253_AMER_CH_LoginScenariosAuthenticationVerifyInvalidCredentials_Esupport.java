package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5775253_AMER_CH_LoginScenariosAuthenticationVerifyInvalidCredentials_Esupport extends BaseTest {
	@Test
	public void validate_TC_5775253_AMER_CH_LoginScenariosAuthenticationVerifyInvalidCredentials_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5775253_AMER_CH_LoginScenariosAuthenticationVerifyInvalidCredentials_Esupport");

			//obj_EsupportDDLWorkflow.handleCookies(driver);
			obj_EsupportDDLWorkflow.VerifySignInbutton(driver);
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);

			obj_EsupportDDLWorkflow.invalidemailaddress(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.invalidPassword(driver, TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.validateErrorMessage(driver); 


		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5775253_AMER_CH_LoginScenariosAuthenticationVerifyInvalidCredentials_Esupport--------->\n  "+e);
		}
	}
}
