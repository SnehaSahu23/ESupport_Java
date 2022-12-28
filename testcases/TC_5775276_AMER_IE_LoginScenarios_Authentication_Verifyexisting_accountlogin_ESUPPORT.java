package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5775276_AMER_IE_LoginScenarios_Authentication_Verifyexisting_accountlogin_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5775276_AMER_IE_LoginScenarios_Authentication_Verifyexisting_accountlogin_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5775276_AMER_IE_LoginScenarios_Authentication_Verifyexisting_accountlogin_ESUPPORT");
			obj_EsupportDDLWorkflow.handleCookies(driver);
			obj_EsupportDDLWorkflow.VerifySignInbutton(driver);
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.validemailaddress(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver,TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver);
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5775276_AMER_IE_LoginScenarios_Authentication_Verifyexisting_accountlogin_ESUPPORT--------->\n  "+e);

		}

	}
}