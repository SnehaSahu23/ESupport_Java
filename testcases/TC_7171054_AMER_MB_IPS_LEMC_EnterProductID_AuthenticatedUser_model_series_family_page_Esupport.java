package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7171054_AMER_MB_IPS_LEMC_EnterProductID_AuthenticatedUser_model_series_family_page_Esupport extends MobilePage
{
	@Test
	public void validate_TC_7171054_AMER_MB_IPS_LEMC_EnterProductID_AuthenticatedUser_model_series_family_page_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_7171054_AMER_MB_IPS_LEMC_EnterProductID_AuthenticatedUser_model_series_family_page_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.clickSignIn(driver);
			obj_EsupportMobileWorkflow.Emaillogin(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
            //obj_EsupportMobileWorkflow.launchUrl(driver, "https://www.dell.com/support/home/en-us/product-support/product/xtremio-family/overview");
			
            driver.get("https://www.dell.com/support/home/en-us/product-support/product/xtremio-family/overview");
			obj_EsupportMobileWorkflow.verifyEnterDetailsLink(driver);			
			
			obj_EsupportMobileWorkflow.clickEnterDetailsLink(driver);
			
			obj_EsupportMobileWorkflow.EnterInvalidProductIDAndClickSubmitButton(driver);
			
			obj_EsupportMobileWorkflow.EnterValidProductIDAndClickSubmitButton1(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			obj_EsupportMobileWorkflow.signOut(driver);
			
			//obj_EsupportIPSWorkflow.launchurl(driver);

			obj_EsupportMobileWorkflow.launchUrl(driver, "https://www.dell.com/support/home/en-us/product-support/product/vvnx/overview");
			
			obj_EsupportMobileWorkflow.clickSignIn(driver);
			obj_EsupportMobileWorkflow.Emaillogin(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.verifyEnterDetailsLink(driver);			
			
			obj_EsupportMobileWorkflow.clickEnterDetailsLink(driver);
			
			obj_EsupportMobileWorkflow.EnterInvalidProductIDAndClickSubmitButton(driver);
			
//			obj_EsupportIPSWorkflow.clickEnterServiceTagPopupCloseButton(driver);
			
			obj_EsupportMobileWorkflow.EnterValidProductIDAndClickSubmitButton1(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7171054_AMER_MB_IPS_LEMC_EnterProductID_AuthenticatedUser_model_series_family_page_Esupport--------->\n  "+e);
		}
	}
}
