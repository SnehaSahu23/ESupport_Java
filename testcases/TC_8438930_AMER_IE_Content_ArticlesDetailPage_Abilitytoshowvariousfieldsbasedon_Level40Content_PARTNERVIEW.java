package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8438930_AMER_IE_Content_ArticlesDetailPage_Abilitytoshowvariousfieldsbasedon_Level40Content_PARTNERVIEW extends BaseTest
{
	@Test
	public void validate_TC_8438930_AMER_IE_Content_ArticlesDetailPage_Abilitytoshowvariousfieldsbasedon_Level40Content_PARTNERVIEW() 
	{
		try
		{
			System.out.println("Starts TC_8438930_AMER_IE_Content_ArticlesDetailPage_Abilitytoshowvariousfieldsbasedon_Level40Content_PARTNERVIEW");
			obj_EsupportContentWorkflow.handleCookies(driver);
			
			//Scenario : Validate when a Level 40 user is signed in and is accessing articles that are level 40 and below
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			//Scenario : An unauthenicated customer lower than level 40 tries to directly access  level 40 articles
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportContentWorkflow.launchArticlePageAndNavigateToSignInPage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			//Scenario : A level 40 user is trying to access level 50 articles
			
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportContentWorkflow.LaunchArticlePageAndverifyArticlePermissionMessage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8438930_AMER_IE_Content_ArticlesDetailPage_Abilitytoshowvariousfieldsbasedon_Level40Content_PARTNERVIEW--------->\n  "+e);
		}
	}
}

