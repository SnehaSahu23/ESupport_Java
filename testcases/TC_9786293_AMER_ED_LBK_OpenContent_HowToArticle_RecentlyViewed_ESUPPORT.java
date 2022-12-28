package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9786293_AMER_ED_LBK_OpenContent_HowToArticle_RecentlyViewed_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9786293_AMER_ED_LBK_OpenContent_HowToArticle_RecentlyViewed_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9786293_AMER_ED_LBK_OpenContent_HowToArticle_RecentlyViewed_ESUPPORT()");
			
			obj_EsupportContentWorkflow.launchArticlePageForRecentlyViewedSectionValidations(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9786293_AMER_ED_LBK_OpenContent_HowToArticle_RecentlyViewed_ESUPPORT()--------->\n  "+e);
		}
	}
}

