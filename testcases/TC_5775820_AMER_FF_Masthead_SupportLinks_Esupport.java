package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5775820_AMER_FF_Masthead_SupportLinks_Esupport extends BaseTest{
	
	
	@Test
	public void validate_TC_5775820_AMER_FF_Masthead_SupportLinks_Esupport(){
		

		try
		{
			System.out.println("Starting TC_5775820_AMER_FF_Masthead_SupportLinks_Esupport..."); 
			
			System.out.println("Integrated HomePage.");
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.verifyIntegratedSupportHomePage(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyMastheadLinks(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnTechDirectLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			//obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnProductSupportLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
		//	obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnKnowledgdeBaseLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			//obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnServiceRequestsLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
		//	obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnOrderSupportLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			//obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnContactSupportLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			//obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5775820_AMER_FF_Masthead_SupportLinks_Esupport--------->\n  "+e);
		}
			

		
	}

}
