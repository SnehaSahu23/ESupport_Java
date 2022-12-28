package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8500012_AMER_FF_SupportHomePageChanges_Story7114003ConsumePurchasedProductsAndRecentlyViewedProductsComponentOnDriversJumpPage_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_8500012_AMER_FF_SupportHomePageChanges_Story7114003ConsumePurchasedProductsAndRecentlyViewedProductsComponentOnDriversJumpPage_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8500012_AMER_FF_SupportHomePageChanges_Story7114003ConsumePurchasedProductsAndRecentlyViewedProductsComponentOnDriversJumpPage_ESUPPORT");
				
			obj_EsupportDriverandDownloadsWorkflow.clickDriversandDownloadsLink(driver);
			obj_EsupportIPSWorkflow.VerifyDetectPCOrSAAndRecentlyViewedProducts(driver);
			obj_EsupportIPSWorkflow.VerifyClickingOnRecentlyViewedProduct(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			obj_EsupportProductionValidationsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);

			obj_EsupportDriverandDownloadsWorkflow.clickDriversandDownloadsLink(driver);
			obj_EsupportIPSWorkflow.VerifyDetectPCOrSAAndRecentlyViewedProducts(driver);
			obj_EsupportIPSWorkflow.VerifyClickingOnRecentlyViewedProduct(driver);
			
			obj_EsupportProductionValidationsWorkflow.signOut(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			obj_EsupportProductionValidationsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);

			obj_EsupportDriverandDownloadsWorkflow.clickDriversandDownloadsLink(driver);
			obj_EsupportIPSWorkflow.VerifyDetectPCOrSAAndRecentlyViewedProducts(driver);
			obj_EsupportIPSWorkflow.VerifyClickingOnRecentlyViewedProduct(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8500012_AMER_FF_SupportHomePageChanges_Story7114003ConsumePurchasedProductsAndRecentlyViewedProductsComponentOnDriversJumpPage_ESUPPORT--------->\n  "+e);
		}
	}
}
