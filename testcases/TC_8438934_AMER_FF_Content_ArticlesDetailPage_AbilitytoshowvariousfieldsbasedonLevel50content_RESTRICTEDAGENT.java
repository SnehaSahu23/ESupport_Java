package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8438934_AMER_FF_Content_ArticlesDetailPage_AbilitytoshowvariousfieldsbasedonLevel50content_RESTRICTEDAGENT extends BaseTest
{
	@Test
	public void validate_TC_8438934_AMER_FF_Content_ArticlesDetailPage_AbilitytoshowvariousfieldsbasedonLevel50content_RESTRICTEDAGENT() 
	{
		try
		{
			System.out.println("Starts TC_8438934_AMER_FF_Content_ArticlesDetailPage_AbilitytoshowvariousfieldsbasedonLevel50content_RESTRICTEDAGENT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			
			//Scenario : Level 50 user is signed in and is trying to access an article details page
			
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			//Scenario : Level 40 and below user trying to access level 50 articles
			
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			Thread.sleep(5000);
			obj_EsupportContentWorkflow.verifyArticlePermissionMessage(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8438934_AMER_FF_Content_ArticlesDetailPage_AbilitytoshowvariousfieldsbasedonLevel50content_RESTRICTEDAGENT--------->\n  "+e);
		}
	}
}

