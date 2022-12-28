package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5775778_AMER_IE_Critical_Links_EnterpriseSupport_Esupport extends BaseTest{
	@Test
	public void validate_TC_5775778_AMER_IE_Critical_Links_EnterpriseSupport_Esupport(){


		try
		{

			System.out.println("Starting TC_5775778_AMER_IE_Critical_Links_EnterpriseSupport_Esupport..."); 

			System.out.println("Integrated HomePage.");

			obj_EsupportOrderHomeWorkflow.handleCookies(driver);

			obj_EsupportIntegratedHomePageWorkflow.verifyIntegratedSupportHomePage(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyCriticalLinks(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOnTechDirectLink(driver);
			driver.navigate().back();
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOnMS360Link(driver);
			
			

		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5775778_AMER_IE_Critical_Links_EnterpriseSupport_Esupport--------->\n  "+e);
		}



	}

}