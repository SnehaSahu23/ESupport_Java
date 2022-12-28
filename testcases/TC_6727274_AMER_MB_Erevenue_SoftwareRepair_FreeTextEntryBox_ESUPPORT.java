package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6727274_AMER_MB_Erevenue_SoftwareRepair_FreeTextEntryBox_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6727274_AMER_MB_Erevenue_SoftwareRepair_FreeTextEntryBox_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6727274_AMER_MB_Erevenue_SoftwareRepair_FreeTextEntryBox_ESUPPORT");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			//obj_EsupportContentWorkflow.handleCookies(driver);
            obj_EsupportMobileWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportMobileWorkflow.clickOnBuySoftwareSupport(driver);
            obj_EsupportMobileWorkflow.selectPaymentMethodAndClickNextButton(driver);
            obj_EsupportMobileWorkflow.selectCheckBoxForIAgreeSoftwareSupportAndEnterIssue(driver);
			
            obj_EsupportMobileWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
            obj_EsupportMobileWorkflow.clickOnBuySoftwareSupport(driver);
            obj_EsupportMobileWorkflow.selectPaymentMethodAndClickNextButton(driver);
            obj_EsupportMobileWorkflow.selectCheckBoxForIAgreeSoftwareSupportAndEnterIssue(driver);
			
            obj_EsupportMobileWorkflow.ValidateFreeTextBoxEnteringMoreThan150Characters(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.VerifyIssueDetailsPageOfPopUpAfterEnteringSpecialCharacters(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportMobileWorkflow.VerifyNextButtonInIssueDetailsPageOfPopup(driver);
			obj_EsupportMobileWorkflow.VerifyTheLabelOfTextBox(driver);
			

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6727274_AMER_MB_Erevenue_SoftwareRepair_FreeTextEntryBox_ESUPPORT--------->\n  "+e);
		}
	}
}