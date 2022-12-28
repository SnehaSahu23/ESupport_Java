package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8438937_AMER_IE_Content_StarRatingonNewPages extends BaseTest 
{
	@Test
	public void validate_TC_8438937_AMER_IE_Content_StarRatingonNewPages() 
	{
		try
		{
			System.out.println("Starts TC_8438937_AMER_IE_Content_StarRatingonNewPages");
			obj_EsupportContentWorkflow.handleCookies(driver);

			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.verifyFeedbackSection(driver);
			obj_EsupportContentWorkflow.verifyAccurateStarValues(driver);
			obj_EsupportContentWorkflow.verifyUsefulStarValues(driver);
			obj_EsupportContentWorkflow.verifyEasyToUnderstandStarValues(driver);
			obj_EsupportContentWorkflow.verifySendFeedbackButtonEnabled(driver);
			obj_EsupportContentWorkflow.verifyTextAllowedinFeedbackSection(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8438937_AMER_IE_Content_StarRatingonNewPages--------->\n  "+e);
		}
	}
}

