package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5780116_AMER_CH_SerialNumberSearch_Esupport extends BaseTest{
	@Test
	public void validate_TC_5780116_AMER_CH_SerialNumberSearch_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5780116_AMER_CH_SerialNumberSearch_Esupport");
			 
            obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_blackCheckOnUsername(driver);
			obj_EsupportIntegratedHomePageWorkflow.toVerifyLockIconInFindMyDellEMCProductLink1(driver);
			obj_EsupportIntegratedHomePageWorkflow.TOVerify_FindMyDellEMCProductsLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.EnterLEMCSerailNumberSearch(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			//obj_EsupportIntegratedHomePageWorkflow.EnterLEMCServiceRequestSearch(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]); 





		}
		catch(Exception e)
		{
			Assert.fail("Failed while TC_5780116_AMER_CH_SerialNumberSearch_Esupport--------->\n  "+e);
		}
	}
}