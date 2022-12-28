package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7663920_AMER_MB_IPS_LEMC_VerifyAdvisoriesTab_Esupport extends MobilePage
{
	@Test
	public void validate_TC_7663920_AMER_MB_IPS_LEMC_VerifyAdvisoriesTab_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_7663920_AMER_MB_IPS_LEMC_VerifyAdvisoriesTab_Esupport");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            
            obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.Emaillogin(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
//			obj_EsupportIPSWorkflow.ClickOnFindMyDellEMCProducts(driver);
//			obj_EsupportIntegratedHomePageWorkflow.clickOnFindMyDellEMCProductsLink(driver);
//			obj_EsupportIPSWorkflow.InProductSearchTabEnterProductID(driver);
//			
//			obj_EsupportIPSWorkflow.ClickOnFirstProductIdFromDropDown(driver);
			
			
			obj_EsupportMobileWorkflow.searchServiceTag(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportMobileWorkflow.ClickOnAdvisoriesTab(driver);
			
			obj_EsupportMobileWorkflow.VerifySecurityAdvisoryGridOnTheProductModelPage(driver);

			obj_EsupportMobileWorkflow.VerifyGrid(driver);
			
			obj_EsupportMobileWorkflow.ClickOnFirstAdvisoryIDFromGrid(driver);
			
			obj_EsupportMobileWorkflow.ClickOnFirstSecurityAdvisoryExpandbutton(driver);
			
			
			obj_EsupportMobileWorkflow.SelectCriticalUnderSeverityLevel(driver);
			obj_EsupportMobileWorkflow.ClickOnClearFilters(driver);
			obj_EsupportMobileWorkflow.ClickOnShowMore(driver);
			obj_EsupportMobileWorkflow.SearchAdvisoryIDAndValidateGrid(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7663920_AMER_MB_IPS_LEMC_VerifyAdvisoriesTab_Esupport--------->\n  "+e);
		}
	}
}