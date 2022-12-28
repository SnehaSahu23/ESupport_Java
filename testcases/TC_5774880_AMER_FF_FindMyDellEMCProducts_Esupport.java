package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5774880_AMER_FF_FindMyDellEMCProducts_Esupport extends BaseTest{
	
	@Test
	public void validate_TC_5774880_AMER_FF_FindMyDellEMCProducts_Esupport(){
			
		try
		{
			System.out.println("Starting TC_5774880_AMER_FF_FindMyDellEMCProducts_Esupport..."); 
			
			System.out.println("Integrated HomePage.");
			Thread.sleep(10000);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.toVerifyLockIconInFindMyDellEMCProductLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOnFindMyDellEMCProductsLink(driver);
						
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5774880_AMER_FF_FindMyDellEMCProducts_Esupport--------->\n  "+e);
		}
	}

}
