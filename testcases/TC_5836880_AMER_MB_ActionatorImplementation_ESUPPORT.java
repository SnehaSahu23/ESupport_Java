package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;

public class TC_5836880_AMER_MB_ActionatorImplementation_ESUPPORT extends MobilePage 
{
	@Test
	public void validate_TC_5836880_AMER_CH_ActionatorImplementation_ESUPPORT() 
	{

		try
		{
			//scenario1
			System.out.println("Starts TC_5836880_AMER_CH_ActionatorImplementation_ESUPPORT");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
            obj_EsupportMobileWorkflow.Select_Search_Values(driver, MobileTestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], "Support");
			Thread.sleep(30000);
			//            obj_EsupportCoveoWorkflow.handleCaptcha(driver);
			//            Thread.sleep(30000);
			//            Thread.sleep(30000);
			//            Thread.sleep(30000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.select_actionatorLink(driver,"Dell");
//			driver.navigate().back();
			obj_EsupportMobileWorkflow.Select_Search_Values(driver, MobileTestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[2], "Support");
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.select_actionatorLink(driver,"EMC");
			//scenario2
//			obj_EsupportCoveoWorkflow.ClickSignIn(driver);
			
			obj_EsupportMobileWorkflow.EmployeeLogin(driver, MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMobileWorkflow.Select_Search_Values(driver, MobileTestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1], "Support");
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.select_actionatorLink(driver,"EMC");
//			driver.navigate().back();
			obj_EsupportMobileWorkflow.Select_Search_Values(driver, MobileTestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[2], "Support");
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.select_actionatorLink(driver,"Dell");
			obj_EsupportMobileWorkflow.signOut(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5836880_AMER_CH_ActionatorImplementation_ESUPPORT--------->\n  "+e);

		}

	}
}