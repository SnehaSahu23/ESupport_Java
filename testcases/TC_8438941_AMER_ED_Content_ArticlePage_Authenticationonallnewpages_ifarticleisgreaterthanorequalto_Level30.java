package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8438941_AMER_ED_Content_ArticlePage_Authenticationonallnewpages_ifarticleisgreaterthanorequalto_Level30 extends BaseTest
{
	@Test
	public void validate_TC_8438941_AMER_ED_Content_ArticlePage_Authenticationonallnewpages_ifarticleisgreaterthanorequalto_Level30() 
	{
		try
		{
			System.out.println("Starts TC_8438941_AMER_ED_Content_ArticlePage_Authenticationonallnewpages_ifarticleisgreaterthanorequalto_Level30");
			obj_EsupportContentWorkflow.handleCookies(driver);
			
			//Scenario : Level 30 user is signed in and is trying to access an article that is level 30 or below.

			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			//Scenario : An unauthenticated user is trying to access LEVEL 30 articles
			
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportContentWorkflow.launchArticlePageAndNavigateToSignInPage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			//Scenario : Level 30 user is signed in and is trying to access an article that is level 40 or level 50
			
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportContentWorkflow.LaunchArticlePageAndverifyArticlePermissionMessage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
		
			//Scenario : An unauthenticated user is trying to access articles that is level 10
			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(5000);
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4]);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8438941_AMER_ED_Content_ArticlePage_Authenticationonallnewpages_ifarticleisgreaterthanorequalto_Level30--------->\n  "+e);
		}
	}
}