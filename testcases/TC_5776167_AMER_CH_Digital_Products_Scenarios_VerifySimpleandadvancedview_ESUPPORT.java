package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5776167_AMER_CH_Digital_Products_Scenarios_VerifySimpleandadvancedview_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5776167_AMER_CH_Digital_Products_Scenarios_VerifySimpleandadvancedview_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5776167_AMER_CH_Digital_Products_Scenarios_VerifySimpleandadvancedview_ESUPPORT");
			obj_EsupportDDLWorkflow.handleCookies(driver);
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.Verifyvaluesincolumns(driver);
			obj_EsupportDDLWorkflow.ProductRegistrationTab(driver);
			obj_EsupportDDLWorkflow.verifypartnerview(driver);
			
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5776167_AMER_CH_Digital_Products_Scenarios_VerifySimpleandadvancedview_ESUPPORT--------->\n  "+e);

		}

	}
}