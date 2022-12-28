package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10114535_AMER_MB_IPS_LEMC_SeriesHeroProductdropdown_Esupport extends MobilePage
{
	@Test
	public void validate_TC_10114535_AMER_MB_IPS_LEMC_SeriesHeroProductdropdown_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_10114535_AMER_MB_IPS_LEMC_SeriesHeroProductdropdown_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.Emaillogin(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
            Thread.sleep(5000);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            
			obj_EsupportMobileWorkflow.searchSeriesName(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportMobileWorkflow.SelectModelOrSeriesFromDropDown(driver);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10114535_AMER_MB_IPS_LEMC_SeriesHeroProductdropdown_Esupport--------->\n  "+e);
		}
	}
}