package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5775807_AMER_ED_Digital_Products_Scenarios_VerifyProductsPage_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5775807_AMER_ED_Digital_Products_Scenarios_VerifyProductsPage_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5775807_AMER_ED_Digital_Products_Scenarios_VerifyProductsPage_ESUPPORT");
			obj_EsupportDDLWorkflow.handleCookies(driver);
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.validemailaddress(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver,TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver);
			
			obj_EsupportDDLWorkflow.clickDigitalProductsTab(driver);
			obj_EsupportDDLWorkflow.VerifyDigitalProductstabinleftnav(driver);
			obj_EsupportDDLWorkflow.VerifySearchBysection(driver);
			obj_EsupportDDLWorkflow.VerifyButtonsUnderSearchBysection(driver);
			obj_EsupportDDLWorkflow.VerifySoftwareProductsGrid(driver);
			obj_EsupportDDLWorkflow.Verifyvaluesincolumns(driver);
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5775807_AMER_ED_Digital_Products_Scenarios_VerifyProductsPage_ESUPPORT--------->\n  "+e);

		}

	}
}