package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9839297_AMER_IE_MPS_PCF_MPSRowexpansionPartsAndAccessoriesDocumentationDiagnosticsAndExtendOrUpgradeLinks_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9839297_AMER_IE_MPS_PCF_MPSRowexpansionPartsAndAccessoriesDocumentationDiagnosticsAndExtendOrUpgradeLinks_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9839297_AMER_IE_MPS_PCF_MPSRowexpansionPartsAndAccessoriesDocumentationDiagnosticsAndExtendOrUpgradeLinks_ESUPPORT()");
			
//			obj_EsupportMPSWorkflow.clickSignIn(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.SignInToMyAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.clickOnExpandButtonOfFirstDisplayedRow(driver);
			obj_EsupportMPSWorkflow.clickOnPartsAndAccessoriesLink(driver);
			obj_EsupportMPSWorkflow.clickOnDocumentationLink(driver);
			
			obj_EsupportMPSWorkflow.clickOnDiagnosticsLink(driver);
			obj_EsupportMPSWorkflow.clickOnDriversAndDownloadsLink(driver);
			
			//obj_EsupportMPSWorkflow.clickOnExtendOrUpgradeLink(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9839297_AMER_IE_MPS_PCF_MPSRowexpansionPartsAndAccessoriesDocumentationDiagnosticsAndExtendOrUpgradeLinks_ESUPPORT()--------->\n  "+e);
		}
	}
}

