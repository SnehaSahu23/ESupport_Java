package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7692874_AMER_CH_IPS_LEMC_Serialized_RequestContractRenewal_Customer_Login_Esupport extends BaseTest
{
	@Test
	public void validate_TC_7692874_AMER_CH_IPS_LEMC_Serialized_RequestContractRenewal_Customer_Login_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_7692874_AMER_CH_IPS_LEMC_Serialized_RequestContractRenewal_Customer_Login_Esupport");

			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIPSWorkflow.VerifyLinkForRequestContractRenewals(driver);
			
			obj_EsupportIPSWorkflow.ClickOnLinkForRequestContractRenewals(driver);
			obj_EsupportIPSWorkflow.VerifyRequestContractRenewalsPopUp(driver);
			obj_EsupportIPSWorkflow.ValidateByRemovingContactNameAndContactPhone(driver);
			obj_EsupportIPSWorkflow.EnterAllDetailsAndSelectRenewMyContract(driver);
			obj_EsupportIPSWorkflow.ClickOnCancelButton(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7692874_AMER_CH_IPS_LEMC_Serialized_RequestContractRenewal_Customer_Login_Esupport--------->\n  "+e);
		}
	}
}
