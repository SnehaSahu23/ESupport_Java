package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6000193_AMER_ED_SupportSearchoptimizedMasthead_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_6000193_AMER_ED_SupportSearchoptimizedMasthead_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6000193_AMER_ED_SupportSearchoptimizedMasthead_Esupport");

			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyMastheadLinks(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnProductSupportLink(driver);			
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnKnowledgdeBaseLink(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnServiceRequestsLink(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnOrderSupportLink(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnContactSupportLink(driver);
			
		//	obj_EsupportCoveoWorkflow.handleHeaderLinks(driver);
			obj_EsupportCoveoWorkflow.handleFooterLinks(driver);
			
			obj_EsupportCoveoWorkflow.displaySignInOptions(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.to_ClickCountrySelector_Arrow(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOnProductSupportLink(driver);	
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			obj_EsupportCoveoWorkflow.ClickSignIn(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],  TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyMastheadLinks(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnProductSupportLink(driver);			
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnKnowledgdeBaseLink(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnServiceRequestsLink(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnOrderSupportLink(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnContactSupportLink(driver);
		//	obj_EsupportCoveoWorkflow.handleHeaderLinks(driver);
			obj_EsupportCoveoWorkflow.handleFooterLinks(driver);
			
			obj_EsupportCoveoWorkflow.displaySignInOptions(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.to_ClickCountrySelector_Arrow(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOnProductSupportLink(driver);	
			
			obj_EsupportCoveoWorkflow.ToVerify_searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			obj_EsupportCoveoWorkflow.Logout(driver);
			obj_EsupportCoveoWorkflow.clickPremierSignIn(driver);
			obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],  TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			
			obj_EsupportCoveoWorkflow.selectPremierStore(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
			
			obj_EsupportOrderHomeWorkflow.handlePremierPopup(driver);
			obj_EsupportCoveoWorkflow.handlePremierHeaderLinks(driver);
			obj_EsupportCoveoWorkflow.handlePremierFooterLinks(driver);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while TC_6000193_AMER_ED_SupportSearchoptimizedMasthead_Esupport--------->\n  "+e);
		}
	}
}