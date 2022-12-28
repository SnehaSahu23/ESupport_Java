package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5780284_AMER_IE_Contactusjumppage_DellEMCProducts__LEMCCustomer_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_5780284_AMER_IE_Contactusjumppage_DellEMCProducts__LEMCCustomer_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 5780284_AMER_IE_Contactusjumppage_DellEMCProducts__LEMCCustomer_ESUPPORT");


//			obj_EsupportCoveoWorkflow.ClickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportCoveoWorkflow.handleCookies(driver);

			driver.navigate().to("https://www.dell.com/support/incidents-online/us/en/19/contactus/Dynamic?ref=contactus");
			obj_EsupportCoveoWorkflow.handleCookies(driver);

			obj_EsupportIntegratedHomePageWorkflow.ToClick_AnyselectProductCOntanctheader(driver);
			obj_EsupportIntegratedHomePageWorkflow.toClick_FindMyDellEMCProducts(driver);
			obj_EsupportIntegratedHomePageWorkflow.toVerify_FindMyDellEMCProductsTabs(driver);
			obj_EsupportIntegratedHomePageWorkflow.toSearch_In_productSearch_FindMyDellEMCProductcontanct(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()));
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_AnyselectProductCOntanctheader(driver);
			//scenario2
			driver.navigate().to("https://www.dell.com/support/incidents-online/us/en/19/contactus/Dynamic?ref=contactus");
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.toClick_FindMyDellEMCProducts(driver);
			obj_EsupportIntegratedHomePageWorkflow.toSearch_In_MyCustomGroups_FindMyDellEMCProduct(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()),"Site Group"); 
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_AnyselectProductCOntanctheader(driver);

			//scenario3
			driver.navigate().to("https://www.dell.com/support/incidents-online/us/en/19/contactus/Dynamic?ref=contactus");
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.toClick_FindMyDellEMCProducts(driver);

			obj_EsupportIntegratedHomePageWorkflow.clickOnAccountSitesTab(driver);

			obj_EsupportIntegratedHomePageWorkflow.handleSiteSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.City.ordinal()));
			obj_EsupportIntegratedHomePageWorkflow.ToClick_AccountlistTab(driver);

			obj_EsupportIntegratedHomePageWorkflow.ToClick_AnyselectProduct(driver);

			obj_EsupportIntegratedHomePageWorkflow.ToVerify_AnyselectProductCOntanctheader(driver);

			Thread.sleep(2000);

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5780284_AMER_IE_Contactusjumppage_DellEMCProducts__LEMCCustomer_ESUPPORT--------->\n  "+e);

		}

	}

}
