package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9070109_AMER_IE_SecurityLandingPage_SearchabilityEnhancementPhraseSearch extends BaseTest
{
	@Test
	public void validate_TC_9070109_AMER_IE_SecurityLandingPage_SearchabilityEnhancementPhraseSearch() 
	{
		try
		{
			System.out.println("Starts TC_9070109_AMER_IE_SecurityLandingPage_SearchabilityEnhancementPhraseSearch");
			obj_EsupportSecurityLandingPageWorkflow.handleCookies(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifySecurityAndAdvisoryHeader(driver);
			obj_EsupportSecurityLandingPageWorkflow.searchTextAndVerifyTitleColumn(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(5000);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9070109_AMER_IE_SecurityLandingPage_SearchabilityEnhancementPhraseSearch--------->\n  "+e);
		}
	}
}