package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7458140_AMER_CH_IPS_LEMC_EnterProductID_AuthenticatedUser_model_series_family_pageAcceptHyphen_Esupport extends BaseTest
{
	@Test
	public void validate_TC_7458140_AMER_CH_IPS_LEMC_EnterProductID_AuthenticatedUser_model_series_family_pageAcceptHyphen_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_7458140_AMER_CH_IPS_LEMC_EnterProductID_AuthenticatedUser_model_series_family_pageAcceptHyphen_Esupport");

			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.launchUrl(driver, "https://www.dell.com/support/home/us/en/04/product-support/product/vmax-series/overview");
			
			obj_EsupportIPSWorkflow.verifyEnterDetailsLink(driver);			
			
			obj_EsupportIPSWorkflow.clickEnterDetailsLink(driver);
			
			
			obj_EsupportIPSWorkflow.EnterValidProductIDAndClickSubmitButton1(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			obj_EsupportIPSWorkflow.signOut(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7458140_AMER_CH_IPS_LEMC_EnterProductID_AuthenticatedUser_model_series_family_pageAcceptHyphen_Esupport--------->\n  "+e);
		}
	}
}
