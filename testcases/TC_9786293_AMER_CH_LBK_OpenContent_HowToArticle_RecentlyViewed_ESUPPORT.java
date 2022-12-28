package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9786293_AMER_CH_LBK_OpenContent_HowToArticle_RecentlyViewed_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9786293_AMER_CH_LBK_OpenContent_HowToArticle_RecentlyViewed_ESUPPORT() 
	{
		try
		{
//			obj_EsupportContentWorkflow.ClearCache(driver);
			System.out.println("Starts TC_9786293_AMER_CH_LBK_OpenContent_HowToArticle_RecentlyViewed_ESUPPORT()");
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportContentWorkflow.launchArticlePageForRecentlyViewedSectionValidations(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Failed in TC_9786293_AMER_CH_LBK_OpenContent_HowToArticle_RecentlyViewed_ESUPPORT()--------->\n  "+e);
		}
	}
}
