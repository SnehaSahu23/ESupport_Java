package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5775852_AMER_CH_DigitalProductsScenariosProductsVerifysortinginDigitalProductspage_Esupport extends BaseTest {
	@Test
	public void validate_TC_5775852_AMER_CH_DigitalProductsScenariosProductsVerifysortinginDigitalProductspage_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5775852_AMER_CH_DigitalProductsScenariosProductsVerifysortinginDigitalProductspage_Esupport");

			//obj_EsupportDDLWorkflow.handleCookies(driver);

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);

			obj_EsupportDDLWorkflow.validemailaddress(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver, TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver); 
			obj_EsupportDDLWorkflow.clickDigitalProductsTab(driver);
			obj_EsupportDDLWorkflow.VerifySoftwareProductsGrid(driver);
			obj_EsupportDDLWorkflow.toVerifyLicenseDateSorting(driver);
			obj_EsupportDDLWorkflow.toVerifyProductNameSorting(driver);			
			obj_EsupportDDLWorkflow.toVerifyPrimaryIDSorting(driver);
			obj_EsupportDDLWorkflow.toVerifyOrderNumberSorting(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5775253_AMER_CH_LoginScenariosAuthenticationVerifyInvalidCredentials_Esupport--------->\n  "+e);
		}
	}
}
