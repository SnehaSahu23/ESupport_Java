package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5775867_AMER_IE_Masthead_Support_links_LEMC_hotuser_or_employee_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5775867_AMER_IE_Masthead_Support_links_LEMC_hotuser_or_employee_ESUPPORT() 
	{

		try
		{
			Thread.sleep(10000);
			System.out.println("Starts TC_5775867_AMER_IE_Masthead_Support_links_LEMC_hotuser_or_employee_ESUPPORT");
			
//			obj_EsupportCoveoWorkflow.ClickSignIn(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIntegratedHomePageWorkflow.verifyMastheadLinks(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOnProductSupportLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyproductsupportpageLinks(driver);
			driver.navigate().back();
		obj_EsupportIntegratedHomePageWorkflow.clickOnKnowledgdeBaseLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyKnowledgebasejumppage(driver);
			obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], "Support");
			driver.navigate().back();
			obj_EsupportIntegratedHomePageWorkflow.clickOnServiceRequestsLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyServiceRequestjumppage(driver);
			driver.navigate().back();
			obj_EsupportIntegratedHomePageWorkflow.clickOnOrderSupportLink(driver);
			driver.navigate().back();
		//	obj_EsupportIntegratedHomePageWorkflow.clickOnContactSupportLink_LEMC(driver);
			obj_EsupportIncidentsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);
		//	obj_EsupportIntegratedHomePageWorkflow.verifyContactsupportjumppageForLEMCUser(driver);
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
		//	obj_EsupportIntegratedHomePageWorkflow.toClick_FindMyDellEMCProducts(driver);
//			obj_EsupportIntegratedHomePageWorkflow.toSearch_In_productSearch_FindMyDellEMCProductcontanct(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()));
//			obj_EsupportIntegratedHomePageWorkflow.ToVerify_allcontactchannels(driver);
	//	obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5775867_AMER_IE_Masthead_Support_links_LEMC_hotuser_or_employee_ESUPPORT--------->\n  "+e);

		}

	}

}

