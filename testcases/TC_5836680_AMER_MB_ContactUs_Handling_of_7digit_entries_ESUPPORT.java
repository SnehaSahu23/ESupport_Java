package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;


public class TC_5836680_AMER_MB_ContactUs_Handling_of_7digit_entries_ESUPPORT extends MobilePage {
	@Test
	public void validate_TC_5836680_AMER_MB_ContactUs_Handling_of_7digit_entries_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5836680");

			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);

//			obj_EsupportCoveoWorkflow.handleCookies(driver);

//			obj_EsupportCoveoWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
            obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.ToLogin_ValidCredentials(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
            obj_EsupportMobileWorkflow.Search_Values_7digitEntries(driver, MobileTestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0],"Support");
			Thread.sleep(10000);
			obj_EsupportMobileWorkflow.toVerify_CoveoResults_7digitEntries(driver,"1");
			Thread.sleep(10000);
//			driver.navigate().back();
			obj_EsupportMobileWorkflow.Search_Values_7digitEntries(driver, MobileTestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1],"Support");
			Thread.sleep(10000);
			obj_EsupportMobileWorkflow.toVerify_CoveoResults_7digitEntries(driver,"2");
			Thread.sleep(10000);
//			driver.navigate().back();

			obj_EsupportMobileWorkflow.Search_Values_7digitEntries(driver, MobileTestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[2],"Support");
			Thread.sleep(10000);
			obj_EsupportMobileWorkflow.toVerify_CoveoResults_7digitEntries(driver,"3");

			obj_EsupportMobileWorkflow.signOut(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5836680_AMER_MB_ContactUs_Handling_of_7digit_entries_ESUPPORT--------->\n  "+e);

		}

	}

}
