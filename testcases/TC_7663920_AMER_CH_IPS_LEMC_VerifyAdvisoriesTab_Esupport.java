package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7663920_AMER_CH_IPS_LEMC_VerifyAdvisoriesTab_Esupport extends BaseTest
{
	@Test
	public void validate_TC_7663920_AMER_CH_IPS_LEMC_VerifyAdvisoriesTab_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_7663920_AMER_CH_IPS_LEMC_VerifyAdvisoriesTab_Esupport");
			obj_EsupportIncidentsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
//			obj_EsupportIPSWorkflow.ClickOnFindMyDellEMCProducts(driver);
//			obj_EsupportIntegratedHomePageWorkflow.clickOnFindMyDellEMCProductsLink(driver);
//			obj_EsupportIPSWorkflow.InProductSearchTabEnterProductID(driver);
//			
//			obj_EsupportIPSWorkflow.ClickOnFirstProductIdFromDropDown(driver);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.ClickOnAdvisoriesTab(driver);
			
			obj_EsupportIPSWorkflow.VerifySecurityAdvisoryGridOnTheProductModelPage(driver);

			obj_EsupportIPSWorkflow.VerifyGrid(driver);
			
//			obj_EsupportIPSWorkflow.ClickOnFirstAdvisoryIDFromGrid(driver);
			
			obj_EsupportIPSWorkflow.ClickOnFirstSecurityAdvisoryExpandbutton(driver);
			
			
			obj_EsupportIPSWorkflow.SelectCriticalUnderSeverityLevel(driver);
			obj_EsupportIPSWorkflow.ClickOnClearFilters(driver);
//			obj_EsupportIPSWorkflow.ClickOnShowMore(driver);
//			obj_EsupportIPSWorkflow.SearchAdvisoryIDAndValidateGrid(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7663920_AMER_CH_IPS_LEMC_VerifyAdvisoriesTab_Esupport--------->\n  "+e);
		}
	}
}
