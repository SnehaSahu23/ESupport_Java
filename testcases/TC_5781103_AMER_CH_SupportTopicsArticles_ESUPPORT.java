package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5781103_AMER_CH_SupportTopicsArticles_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5781103_AMER_CH_SupportTopicsArticles_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5781103_AMER_CH_SupportTopicsArticles_ESUPPORT");
			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ToClick_SupportArticlesTab(driver);
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.clickArticleLink(driver);
			obj_EsupportContentWorkflow.changeLanguageArticle(driver);
			obj_EsupportContentWorkflow.changeCountryArticle(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5781103_AMER_CH_SupportTopicsArticles_ESUPPORT--------->\n  "+e);

		}

	}
}


