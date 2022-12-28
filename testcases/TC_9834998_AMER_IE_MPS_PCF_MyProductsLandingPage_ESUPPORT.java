package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9834998_AMER_IE_MPS_PCF_MyProductsLandingPage_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9834998_AMER_IE_MPS_PCF_MyProductsLandingPage_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9834998_AMER_IE_MPS_PCF_MyProductsLandingPage_ESUPPORT()");
			
//			obj_EsupportMPSWorkflow.clickSignIn(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.SignInToMyAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.validateOptionsAboveGridInMyProductsTab(driver);
			obj_EsupportMPSWorkflow.verifyColumnNamesInGrid(driver);
			obj_EsupportMPSWorkflow.vlidateSortingColumns(driver);
			
			obj_EsupportMPSWorkflow.VerifyPageNumbersDisplayingUnderPaginationSection(driver);
			obj_EsupportMPSWorkflow.ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent(driver);
			obj_EsupportMPSWorkflow.ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9834998_AMER_IE_MPS_PCF_MyProductsLandingPage_ESUPPORT()--------->\n  "+e);
		}
	}
}
