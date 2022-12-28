package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5780144_AMER_IE_Homepage_FindMyDellEMCProducts_LEMC_CustomerAccount_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_5780144_AMER_IE_Homepage_FindMyDellEMCProducts_LEMC_CustomerAccount_Esupport() 
	{

		try
		{
			//scenario1
			System.out.println("Starts TC_5780144_AMER_IE_Homepage_FindMyDellEMCProducts_LEMC_CustomerAccount_Esupport");
			
//			obj_EsupportCoveoWorkflow.ClickSignIn(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.toClick_FindMyDellEMCProducts(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			//removed below as functionality changed
//			obj_EsupportIntegratedHomePageWorkflow.toVerify_FindMyDellEMCProductsTabs(driver);
//			obj_EsupportIntegratedHomePageWorkflow.toSearch_In_productSearch_FindMyDellEMCProduct(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()));
//			//scenario2
//			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.toClick_FindMyDellEMCProducts(driver);
//			obj_EsupportIntegratedHomePageWorkflow.toSearch_In_MyCustomGroups_FindMyDellEMCProduct(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()),"Site Group");
//			//scenario3
//			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.toClick_FindMyDellEMCProducts(driver);
//			obj_EsupportIntegratedHomePageWorkflow.clickOnAccountSitesTab(driver);
//            obj_EsupportIntegratedHomePageWorkflow.handleSiteSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.City.ordinal()));
//            obj_EsupportIntegratedHomePageWorkflow.ToClick_AccountlistTab(driver);
//            obj_EsupportIntegratedHomePageWorkflow.ToClick_AnyselectProduct(driver);
//            obj_EsupportIntegratedHomePageWorkflow.TOVerify_DellEMCProductSupportPage(driver);

		
		
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5780144_AMER_IE_Homepage_FindMyDellEMCProducts_LEMC_CustomerAccount_Esupport--------->\n  "+e);

		}

	}
}


