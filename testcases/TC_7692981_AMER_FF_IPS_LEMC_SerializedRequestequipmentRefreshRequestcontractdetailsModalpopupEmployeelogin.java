package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7692981_AMER_FF_IPS_LEMC_SerializedRequestequipmentRefreshRequestcontractdetailsModalpopupEmployeelogin extends BaseTest
{
	@Test
	public void validate_TC_7692981_AMER_FF_IPS_LEMC_LEMC_SerializedRequestequipmentRefreshRequestcontractdetailsModalpopupEmployeelogin() 
	{
		try
		{
			System.out.println("Starts TC_7692981_AMER_FF_IPS_LEMC_SerializedRequestequipmentRefreshRequestcontractdetailsModalpopupEmployeelogin");

			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
//			obj_EsupportContentWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
//			obj_EsupportIPSWorkflow.employeeLogin_Firefox(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.VerifyLinkForRequestEquipmentRefresh(driver);
			obj_EsupportIPSWorkflow.VerifyLinkForRequestContractRenewals(driver);
			
			obj_EsupportIPSWorkflow.ClickOnLinkForRequestEquipmentRefresh(driver);
			obj_EsupportIPSWorkflow.VerifyRequesEquipmentRefreshPopUp(driver);
			obj_EsupportIPSWorkflow.ClickOnCancelButtonInRequestEquipmentRequest(driver);
			obj_EsupportIPSWorkflow.ClickOnLinkForRequestContractRenewals(driver);
			obj_EsupportIPSWorkflow.VerifyRequestContractRenewalsPopUp(driver);
			obj_EsupportIPSWorkflow.ClickOnCancelButton(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7692981_AMER_FF_IPS_LEMC_SerializedRequestequipmentRefreshRequestcontractdetailsModalpopupEmployeelogin--------->\n  "+e);
		}
	}
}