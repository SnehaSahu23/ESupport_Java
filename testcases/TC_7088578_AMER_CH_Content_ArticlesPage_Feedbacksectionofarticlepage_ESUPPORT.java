package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7088578_AMER_CH_Content_ArticlesPage_Feedbacksectionofarticlepage_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7088578_AMER_CH_Content_ArticlesPage_Feedbacksectionofarticlepage_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7088578_AMER_CH_Content_ArticlesPage_Feedbacksectionofarticlepage_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.NavigateToAnArticlePage(driver);
			obj_EsupportContentWorkflow.FeedbackSectionPageValidation(driver);
			obj_EsupportContentWorkflow.SendFeedbackButtonValidationToGetDefaultStatus(driver);
			obj_EsupportContentWorkflow.ValidationOfErrorMessageWithOutSelectingAllStarRating(driver);
			obj_EsupportContentWorkflow.ValidationOfErrorMessageWithOutSelectingYesOrNobutton(driver);
			obj_EsupportContentWorkflow.ValidationOfErrorMessageWithSpecialCharsInTextBox(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.ValidationOfSendFeedbackButtonWithSelectionOfValidInput(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7088578_AMER_CH_Content_ArticlesPage_Feedbacksectionofarticlepage_ESUPPORT--------->\n  "+e);
		}
	}
}
