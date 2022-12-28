package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5780929_AMER_FF_ProductManagementScenarios_ProductInformation_AddLicenseName_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_5780929_AMER_FF_ProductManagementScenarios_ProductInformation_AddLicenseName_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_5780929_AMER_FF_ProductManagementScenarios_ProductInformation_AddLicenseName_ESUPPORT");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.clickDigitalProductsTab(driver);
			
			obj_EsupportDDLWorkflow.ToEnter_keywordsubmit(driver);
			
			
			obj_EsupportDDLWorkflow.ToClick_Orderdetails(driver);
			obj_EsupportDDLWorkflow.ToVerify_Productsearchtabs(driver);
			
		   obj_EsupportDDLWorkflow.ToVerifyEnter_Licencename(driver);
		   
		  
			
			
		
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5780929_AMER_FF_ProductManagementScenarios_ProductInformation_AddLicenseName_ESUPPORT--------->\n  "+e);
		}
	}
}
