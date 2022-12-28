package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5775867_AMER_FF_Masthead_Support_links_LEMC_hotuser_or_employee_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5775867_AMER_FF_Masthead_Support_links_LEMC_hotuser_or_employee_ESUPPORT() 
	{

		try
		{
			Thread.sleep(10000);
			System.out.println("Starts TC_5775867_AMER_FF_Masthead_Support_links_LEMC_hotuser_or_employee_ESUPPORT");
			
//			obj_EsupportCoveoWorkflow.ClickSignIn(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyMastheadLinks(driver);
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.clickOnProductSupportLink(driver);
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.verifyproductsupportpageLinks(driver);
//			driver.navigate().back();
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.clickOnKnowledgdeBaseLink(driver);
//			obj_EsupportIntegratedHomePageWorkflow.verifyKnowledgebasejumppage(driver);
//			obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], "Support");
//			driver.navigate().back();
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.clickOnServiceRequestsLink(driver);
//			obj_EsupportIntegratedHomePageWorkflow.verifyServiceRequestjumppage(driver);
//			driver.navigate().back();
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.clickOnOrderSupportLink(driver);
//			driver.navigate().back();
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.clickOnContactSupportLink_LEMC(driver);
			obj_EsupportIncidentsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyContactsupportjumppageForLEMCUser(driver);
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
		//	obj_EsupportIntegratedHomePageWorkflow.toClick_FindMyDellEMCProducts(driver);
//			obj_EsupportIntegratedHomePageWorkflow.toSearch_In_productSearch_FindMyDellEMCProductcontanct(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()));
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportIncidentsWorkflow.ValidateContactChannelsAreEnabledUnderContactChannels(driver);
//			driver.navigate().back();
//			obj_EsupportCoveoWorkflow.handleCookies(driver);

			//this functionality not applicable to LEMC user
//			obj_EsupportIntegratedHomePageWorkflow.Click_anyproduct_underrecentviewedsection(driver);
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.ClickChangeProduct(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5775867_AMER_FF_Masthead_Support_links_LEMC_hotuser_or_employee_ESUPPORT--------->\n  "+e);

		}

	}

}
