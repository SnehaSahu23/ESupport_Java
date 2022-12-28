package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8438900_AMER_ED_Content_ArticlesDetailsPage_SecurityKnowledgeArticlesPage extends BaseTest {


	@Test
	public void validate_TC_8438900_AMER_ED_Content_ArticlesDetailsPage_SecurityKnowledgeArticlesPage() 
	{
		try
		{
			System.out.println("Starts TC_8438900_AMER_ED_Content_ArticlesDetailsPage_SecurityKnowledgeArticlesPage()");
		//	obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.validateArticleDetails(driver);
			obj_EsupportContentWorkflow.verifyLessAndMoreLinkAndEmailIcon(driver);
			obj_EsupportContentWorkflow.verifyActiveTab(driver);
			obj_EsupportContentWorkflow.verifyArticleContentDetailsSecurityAdvisory(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticlePropertiesDetails(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticleAttachmentsDetails(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticleLegalInformation(driver);
			obj_EsupportContentWorkflow.clickOnJumpToTopIcon(driver);
			
			//Security KB Remedy Available
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			obj_EsupportContentWorkflow.validateArticleDetails(driver);
			obj_EsupportContentWorkflow.verifyLessAndMoreLinkAndEmailIcon(driver);
			obj_EsupportContentWorkflow.verifyActiveTab(driver);
			obj_EsupportContentWorkflow.verifyArticleContentDetailsSecurityAdvisory(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticlePropertiesDetails(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticleAttachmentsDetails(driver);
			obj_EsupportContentWorkflow.clickAndVerifySeverityDisclaimerDetails(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticleLegalInformation(driver);
			obj_EsupportContentWorkflow.clickOnJumpToTopIcon(driver);
			
			//Security KB Remedy in Progress
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			obj_EsupportContentWorkflow.validateArticleDetails(driver);
			obj_EsupportContentWorkflow.verifyLessAndMoreLinkAndEmailIcon(driver);
			obj_EsupportContentWorkflow.verifyActiveTab(driver);
			obj_EsupportContentWorkflow.verifyArticleContentDetailsSecurityAdvisory(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticlePropertiesDetails(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticleAttachmentsDetails(driver);
			obj_EsupportContentWorkflow.clickAndVerifySeverityDisclaimerDetails(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticleLegalInformation(driver);
			obj_EsupportContentWorkflow.clickOnJumpToTopIcon(driver);
			
			//Verify Level 50 User 
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportContentWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[6]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			obj_EsupportContentWorkflow.verifyArticleContentDetails_Level50(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticlePropertiesDetails_Level50(driver);
			obj_EsupportContentWorkflow.clickAndVerifyArticleAttachmentsDetails_Level50(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8438900_AMER_ED_Content_ArticlesDetailsPage_SecurityKnowledgeArticlesPage()--------->\n  "+e);
		}
	}
}

