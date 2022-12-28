package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9404238_AMER_IE_LBK_OpenContent_HowTo_Internal_L50_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9404238_AMER_IE_LBK_OpenContent_HowTo_Internal_L50_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9404238_AMER_IE_LBK_OpenContent_HowTo_Internal_L50_ESUPPORT()");
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
//			obj_EsupportContentWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.validateArticleDetails_L304050(driver);
			obj_EsupportContentWorkflow.verifyPrintFunctionality_L50(driver);
			obj_EsupportContentWorkflow.ValidateChangingLanguageFromDropDown_ForArticle(driver);
			obj_EsupportContentWorkflow.validateSummaryFunctionality(driver);
			
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			
			obj_EsupportContentWorkflow.verifyClickingOnAnyTabTabIshighlighted(driver);
			obj_EsupportContentWorkflow.verifyArticleContentDetails_HowToL50(driver);
			obj_EsupportContentWorkflow.clickAndVerifyAttachmentsDetails(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticlePropertiesDetails(driver);
			
			obj_EsupportContentWorkflow.verifyClickingOnRateThisArticleOnLeftRail(driver);
			
			obj_EsupportContentWorkflow.verifyMouseOverOnStarRatingUnderAccurate(driver);
			obj_EsupportContentWorkflow.verifyMouseOverOnStarRatingUnderUseful(driver);
			obj_EsupportContentWorkflow.verifyMouseOverOnStarRatingUnderEasyToUnderstandOptions(driver);
			obj_EsupportContentWorkflow.verifySelectingYesOrNoOptionUnderWasThisArticleHelpful(driver);
			obj_EsupportContentWorkflow.ValidateFeedbackFormEnteringmoreThan3000Chars(driver);
			obj_EsupportContentWorkflow.ValidationOfSendFeedbackButtonWithSelectionOfAllInput(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9404238_AMER_IE_LBK_OpenContent_HowTo_Internal_L50_ESUPPORT()--------->\n  "+e);
		}
	}
}

