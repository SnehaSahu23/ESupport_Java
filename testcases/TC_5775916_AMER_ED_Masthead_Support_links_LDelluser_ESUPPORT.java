package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5775916_AMER_ED_Masthead_Support_links_LDelluser_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5775916_AMER_ED_Masthead_Support_links_LDelluser_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5775916_AMER_ED_Masthead_Support_links_LDelluser");
//			obj_EsupportCoveoWorkflow.ClickSignIn(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyMastheadLinks(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.clickOnProductSupportLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.toVerifyLockIconInFindMyDellEMCProductLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOnFindMyDellEMCProducts_RequestLink(driver);
			//obj_EsupportIntegratedHomePageWorkflow.clickOnFindMyDellEMCProductsLink(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.Click_anyproduct_underrecentviewedsection(driver);
//			driver.navigate().back();
			obj_EsupportIntegratedHomePageWorkflow.ClickChangeProduct(driver);
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			
//			driver.navigate().back();
			obj_EsupportIntegratedHomePageWorkflow.clickOnKnowledgdeBaseLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyKnowledgebasejumppage(driver);
			//obj_EsupportIntegratedHomePageWorkflow.toVerifyLockIconInFindMyDellEMCProductLink(driver);
			//obj_EsupportIntegratedHomePageWorkflow.clickOnFindMyDellEMCProductsLink(driver);
			obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], "Support");
			driver.navigate().back();
//			driver.navigate().back();
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.ClickChangeProduct(driver);
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOnServiceRequestsLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyServiceRequestjumppage(driver);
			driver.navigate().back();
    		obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOnOrderSupportLink(driver);
			driver.navigate().back();
			
			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.clickOnContactSupportLink_employee(driver);
			obj_EsupportIncidentsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);
			obj_EsupportIntegratedHomePageWorkflow.verifyContactsupportjumppage(driver);
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.clickOnFindMyDellEMCProducts_RequestLink(driver);
			//obj_EsupportIntegratedHomePageWorkflow.toClick_FindMyDellEMCProducts(driver);
//			obj_EsupportIntegratedHomePageWorkflow.toSearch_In_productSearch_FindMyDellEMCProductcontanct(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()));
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.ToVerify_allcontactchannels(driver);
//			driver.navigate().back();
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
			
		//	obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.signOut(driver);

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5775916_AMER_ED_Masthead_Support_links_LDelluser_ESUPPORT--------->\n  "+e);

		}

	}

}