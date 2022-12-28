package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7057781_AMER_CH_Contact_SelfHelpOptions_DiagnoseYourProblem_LDELL_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7057781_AMER_CH_Contact_SelfHelpOptions_DiagnoseYourProblem_LDELL_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7057781_AMER_CH_Contact_SelfHelpOptions_DiagnoseYourProblem_LDELL_ESUPPORT");
			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.VerifyDiagnoseYourProblemSelfHelpOption(driver);
			obj_EsupportIncidentsWorkflow.ClickRunQuickTest(driver);
//			driver.navigate().back();
			
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
//			obj_EsupportIncidentsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			obj_EsupportIncidentsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
			obj_EsupportProductionValidationsWorkflow.ClickGSeriesLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportProductionValidationsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.VerifyDiagnoseYourProblemSelfHelpOption(driver);
			obj_EsupportIncidentsWorkflow.ClickRunQuickTest(driver);
//			driver.navigate().back();
			obj_EsupportIPSWorkflow.signOut(driver);
			
			//execute all steps after signout
			
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.VerifyDiagnoseYourProblemSelfHelpOption(driver);
			obj_EsupportIncidentsWorkflow.ClickRunQuickTest(driver);
//			driver.navigate().back();
			
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
//			obj_EsupportIncidentsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			obj_EsupportIncidentsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
			obj_EsupportProductionValidationsWorkflow.ClickGSeriesLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportProductionValidationsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.VerifyDiagnoseYourProblemSelfHelpOption(driver);
			obj_EsupportIncidentsWorkflow.ClickRunQuickTest(driver);
//			driver.navigate().back();
			
//			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
//			obj_EsupportIncidentsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);
//			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7057781_AMER_CH_Contact_SelfHelpOptions_DiagnoseYourProblem_LDELL_ESUPPORT--------->\n  "+e);

		}

	}
}
