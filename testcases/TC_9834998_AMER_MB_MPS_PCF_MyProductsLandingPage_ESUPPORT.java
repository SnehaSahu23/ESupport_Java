package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9834998_AMER_MB_MPS_PCF_MyProductsLandingPage_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_9834998_AMER_MB_MPS_PCF_MyProductsLandingPage_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9834998_AMER_MB_MPS_PCF_MyProductsLandingPage_ESUPPORT()");
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
//			obj_EsupportMobileWorkflow.clickSignIn(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
            obj_EsupportMobileWorkflow.SignInToMyAccount(driver, MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMobileWorkflow.validateOptionsAboveGridInMyProductsTab(driver);
			obj_EsupportMobileWorkflow.verifyColumnNamesInGrid(driver);
//			obj_EsupportMobileWorkflow.vlidateSortingColumns(driver);
			
			obj_EsupportMobileWorkflow.VerifyPageNumbersDisplayingUnderPaginationSection(driver);
			obj_EsupportMobileWorkflow.ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent(driver);
			obj_EsupportMobileWorkflow.ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9834998_AMER_MB_MPS_PCF_MyProductsLandingPage_ESUPPORT()--------->\n  "+e);
		}
	}
}
