package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7692874_AMER_MB_IPS_LEMC_Serialized_RequestContractRenewal_Customer_Login_Esupport extends MobilePage
{
	@Test
	public void validate_TC_7692874_AMER_MB_IPS_LEMC_Serialized_RequestContractRenewal_Customer_Login_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_7692874_AMER_MB_IPS_LEMC_Serialized_RequestContractRenewal_Customer_Login_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.clickSignIn(driver);
			obj_EsupportMobileWorkflow.Emaillogin(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            
			obj_EsupportMobileWorkflow.ClickSearchServiceTag(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportMobileWorkflow.VerifyLinkForRequestContractRenewals(driver);
			
			obj_EsupportMobileWorkflow.ClickOnLinkForRequestContractRenewals(driver);
			obj_EsupportMobileWorkflow.VerifyRequestContractRenewalsPopUp(driver);
			obj_EsupportMobileWorkflow.ValidateByRemovingContactNameAndContactPhone(driver);
			obj_EsupportMobileWorkflow.EnterAllDetailsAndSelectRenewMyContract(driver);
			obj_EsupportMobileWorkflow.ClickOnCancelButton(driver);
			
			//obj_EsupportMobileWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7692874_AMER_MB_IPS_LEMC_Serialized_RequestContractRenewal_Customer_Login_Esupport--------->\n  "+e);
		}
	}
}
